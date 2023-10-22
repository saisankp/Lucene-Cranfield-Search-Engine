package com.CS7IS3.Assignment1.Prathamesh;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class Main {

	public static void main(String[] args) throws Exception {
		Analyzer analyzer = null;
		Similarity scoring = null;
		QueryParser parser = null;
		if (args.length != 0) {
			if (args[0].equals("--operation") && args.length > 1) {
				analyzer = getAnalyzerFromArguments(args[2]);
				switch (args[1].toLowerCase()) {
				case "index":
					Indexer indexer = new Indexer();
					indexer.index(analyzer);
					System.out.println("Indexing completed using the " + args[2]);
				case "search":
					if (args.length == 5) {
						scoring = getSimilarityScoringFromArguments(args[3]);
						parser = getQueryParserFromArguments(args[4], analyzer);
						Searcher searcher = new Searcher(analyzer, scoring, parser);
						searcher.searchForCommandLine();
					}
				case "evaluate":
					if (args.length == 5) {
						scoring = getSimilarityScoringFromArguments(args[3]);
						parser = getQueryParserFromArguments(args[4], analyzer);
						Scorer scorer = new Scorer();
						scorer.score(analyzer, scoring, parser);
					}
				}
			} else if (args[0].equals("--visualize") && args.length > 1) {
				SwingUtilities.invokeLater(() -> {
					try {
						JFreeChart chart = Visualize.getChart(Float.parseFloat(args[1]), Float.parseFloat(args[2]),
								Float.parseFloat(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]),
								Float.parseFloat(args[6]), Float.parseFloat(args[7]), Float.parseFloat(args[8]),
								Float.parseFloat(args[9]), Float.parseFloat(args[10]), Float.parseFloat(args[11]),
								Float.parseFloat(args[12]), Float.parseFloat(args[13]), Float.parseFloat(args[14]),
								Float.parseFloat(args[15]), Float.parseFloat(args[16]), Float.parseFloat(args[17]),
								Float.parseFloat(args[18]), Float.parseFloat(args[19]), Float.parseFloat(args[20]),
								Float.parseFloat(args[21]), Float.parseFloat(args[22]), Float.parseFloat(args[23]),
								Float.parseFloat(args[24]), Float.parseFloat(args[25]), Float.parseFloat(args[26]),
								Float.parseFloat(args[27]), Float.parseFloat(args[28]), Float.parseFloat(args[29]),
								Float.parseFloat(args[30]), Float.parseFloat(args[31]), Float.parseFloat(args[32]));
						ChartUtilities.saveChartAsPNG(new File("visualization.png"), chart, 1280, 720);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			} else {
				System.out.println("An invalid argument was passed in. Try again.");
			}
		} else {
			System.out.println("No arguments were passed in. Try again.");
			System.exit(-1);
		}

	}

	public static Analyzer getAnalyzerFromArguments(String analyzer) {
		if (analyzer.equals("StandardAnalyzer")) {
			return new StandardAnalyzer();
		} else if (analyzer.equals("CranfieldAnalyzer")) {
			return new CranfieldAnalyzer();
		} else {
			System.out.println("Invalid analyzer requested. Try again.");
			System.exit(-1);
			return null;
		}
	}

	public static Similarity getSimilarityScoringFromArguments(String scoring) {
		if (scoring.equals("BM25")) {
			return new BM25Similarity();
		} else if (scoring.equals("VSM")) {
			return new ClassicSimilarity();
		} else if (scoring.equals("LMDirichlet")) {
			return new LMDirichletSimilarity();
		} else if (scoring.equals("LMJelinekMercer")) {
			return new LMJelinekMercerSimilarity(0.7f);
		} else {
			System.out.println("Invalid similarity requested. Try again.");
			System.exit(-1);
			return null;
		}
	}

	public static QueryParser getQueryParserFromArguments(String parser, Analyzer analyzer) {
		if (parser.equals("QueryParser")) {
			return new QueryParser("abstract", analyzer);
		} else if (parser.equals("MultiFieldQueryParser")) {
			HashMap<String, Float> weightings = new HashMap<>();
			weightings.put("title", 0.3f);
			weightings.put("abstract", 0.7f);
			weightings.put("department", 0.05f);
			return new MultiFieldQueryParser(new String[] { "title", "abstract", "department" }, analyzer, weightings);
		} else {
			System.out.println("Invalid parser requested. Try again.");
			System.exit(-1);
			return null;
		}
	}

}
