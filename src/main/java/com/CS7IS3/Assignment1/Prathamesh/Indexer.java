package com.CS7IS3.Assignment1.Prathamesh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {

	private static HashMap<String, String> textBeforeMarker;

	public Indexer() {
		textBeforeMarker = new HashMap<>();
		textBeforeMarker.put(".W", "department");
		textBeforeMarker.put(".B", "authors");
		textBeforeMarker.put(".A", "title");
	}

	public void index(Analyzer analyzer) throws IOException {
		Path PathToCranfieldCollection = Paths.get("./cranfield-collection/cran.all.1400");
		List<String> linesInCranfieldCollection = Files.readAllLines(PathToCranfieldCollection);
		ArrayList<Document> documentsInCranfieldCollection = new ArrayList<Document>();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);

		Document document = new Document();
		String text = "";
		boolean inAbstractSection = false;

		for (int lineIndex = 0; lineIndex < linesInCranfieldCollection.size(); lineIndex++) {
			String cranfieldLine = linesInCranfieldCollection.get(lineIndex);
			// .A, .B or .W = Author, Bibliographic information, Abstract
			if (cranfieldLine.startsWith(".A") || cranfieldLine.startsWith(".B") || cranfieldLine.startsWith(".W")) {
				if (!inAbstractSection) {
					// If we reach .W, we need to collect the content of the abstract next
					if (cranfieldLine.equals(".W")) {
						inAbstractSection = true;
					}
					document.add(new TextField(Indexer.textBeforeMarker.get(cranfieldLine), text, Field.Store.YES));
					text = "";
				}
			}
			// .I = Document ID
			else if (cranfieldLine.startsWith(".I")) {
				// If this is not the first .I, we just finished collecting from the abstract
				if (lineIndex != 0) {
					document.add(new TextField("abstract", text, Field.Store.YES));
					documentsInCranfieldCollection.add(document);
				}
				lineIndex++; // Skip over .T which is always after .I
				document = new Document();
				inAbstractSection = false;
				text = "";

			}
			// Reached a new line of text, so we append it to our current accumulated text
			else {
				text += cranfieldLine + " ";
			}
		}
		// Don't forget to add the content for the last .W at the end of the corpus
		document.add(new TextField("abstract", text, Field.Store.YES));
		documentsInCranfieldCollection.add(document);

		try (Directory directory = FSDirectory.open(Paths.get("./index"))) {
			config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
			try (IndexWriter writer = new IndexWriter(directory, config)) {
				writer.addDocuments(documentsInCranfieldCollection);
			}
		}
	}

}
