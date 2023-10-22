package com.CS7IS3.Assignment1.Prathamesh;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {
	IndexSearcher indexSearcher;
	QueryParser queryParser;
	DirectoryReader directoryReader;
	Directory indexDirectory;

	public Searcher(Analyzer analyzer, Similarity similarity, QueryParser parser) throws IOException {
		Path pathToIndex = Paths.get("./index");
		indexDirectory = FSDirectory.open(pathToIndex);
		directoryReader = DirectoryReader.open(indexDirectory);
		indexSearcher = new IndexSearcher(directoryReader);
		indexSearcher.setSimilarity(similarity);
		queryParser = parser;
	}

	public void searchForCommandLine() throws Exception {
		String userQuery = "";
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("Enter text to search (or control+c to exit): ");
				userQuery = scanner.nextLine().trim();
				if (!userQuery.equals("")) {
					System.out.println("Searching for " + userQuery + ":");
					Query query = queryParser.parse(userQuery);
					ScoreDoc[] searchResults = indexSearcher.search(query, 5).scoreDocs;
					System.out.println("Search results:");
					for (int i = 0; i < searchResults.length; i++) {
						Document document = indexSearcher.doc(searchResults[i].doc);
						System.out.println(
								i + 1 + ". \"" + document.get("title") + "\" [Score: " + searchResults[i].score + "]");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exiting search functionality.");
		} finally {
			directoryReader.close();
			indexDirectory.close();
		}
	}

	public void searchForScoring(String queryForScoring, int queryId, BufferedWriter buffer) throws Exception {
		Query query = queryParser.parse(QueryParser.escape(queryForScoring));
		ScoreDoc[] results = indexSearcher.search(query, 1400).scoreDocs;
		for (int resultIndex = 0; resultIndex < results.length; resultIndex++) {
			String scoreLine = queryId + " 0 " + (results[resultIndex].doc + 1) + " " + (resultIndex + 1) + " "
					+ results[resultIndex].score + " STANDARD";
			buffer.write(scoreLine);
			buffer.newLine();
		}
	}

}