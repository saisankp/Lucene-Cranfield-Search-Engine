package com.CS7IS3.Assignment1.Prathamesh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.similarities.Similarity;

public class Scorer {
	static ArrayList<String> queries;

	public Scorer() throws IOException {
		queries = parseCranfieldQueries();
	}

	public ArrayList<String> parseCranfieldQueries() throws IOException {
		Path queryFilePath = Paths.get("./cranfield-collection/cran.qry");
		List<String> queryLines = Files.readAllLines(queryFilePath);
		ArrayList<String> queries = new ArrayList<String>();
		String text = "";
		for (int queryIndex = 0; queryIndex < queryLines.size(); queryIndex++) {
			String queryLine = queryLines.get(queryIndex);
			// .I = Document ID
			if (queryLine.startsWith(".I")) {
				if (queryIndex != 0) {
					queries.add(text);
				}
				queryIndex++; // Skip over .W which is always after .I
				text = "";
			}
			// .W = Query text
			else {
				text += queryLine + " ";
			}
			// Add the final query on the last line
			if (queryIndex == queryLines.size() - 1) {
				queries.add(text);
			}
		}

		return queries;
	}

	public void score(Analyzer analyzer, Similarity similarity, QueryParser parser) throws Exception {
		File directory = new File("./evaluation");

		if (!directory.exists()) {
			directory.mkdirs();
		}
		FileWriter fileWriter = new FileWriter("./evaluation/scores", false);
		BufferedWriter buffer = new BufferedWriter(fileWriter);

		Searcher searcher = new Searcher(analyzer, similarity, parser);
		for (int i = 0; i < queries.size(); i++) {
			searcher.searchForScoring(queries.get(i), i + 1, buffer);
		}

		buffer.close();
		fileWriter.close();
	}

}