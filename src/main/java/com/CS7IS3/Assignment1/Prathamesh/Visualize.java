package com.CS7IS3.Assignment1.Prathamesh;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

public class Visualize {

	public static JFreeChart getChart(float standardAnalyzerBM25QueryParserMAP,
			float standardAnalyzerBM25QueryParserSetRecall, float standardAnalyzerBM25MultiFieldQueryParserMAP,
			float standardAnalyzerBM25MultiFieldQueryParserSetRecall, float standardAnalyzerVSMQueryParserMAP,
			float standardAnalyzerVSMQueryParserSetRecall, float standardAnalyzerVSMMultiFieldQueryParserMAP,
			float standardAnalyzerVSMMultiFieldQueryParserSetRecall, float standardAnalyzerLMDirichletQueryParserMAP,
			float standardAnalyzerLMDirichletQueryParserSetRecall,
			float standardAnalyzerLMDirichletMultiFieldQueryParserMAP,
			float standardAnalyzerLMDirichletMultiFieldQueryParserSetRecall,
			float standardAnalyzerLMJelinekMercerQueryParserMAP,
			float standardAnalyzerLMJelinekMercerQueryParserSetRecall,
			float standardAnalyzerLMJelinekMercerMultiFieldQueryParserMAP,
			float standardAnalyzerLMJelinekMercerMultiFieldQueryParserSetRecall,
			float cranfieldAnalyzerBM25QueryParserMAP, float cranfieldAnalyzerBM25QueryParserSetRecall,
			float cranfieldAnalyzerBM25MultiFieldQueryParserMAP,
			float cranfieldAnalyzerBM25MultiFieldQueryParserSetRecall, float cranfieldAnalyzerVSMQueryParserMAP,
			float cranfieldAnalyzerVSMQueryParserSetRecall, float cranfieldAnalyzerVSMMultiFieldQueryParserMAP,
			float cranfieldAnalyzerVSMMultiFieldQueryParserSetRecall, float cranfieldAnalyzerLMDirichletQueryParserMAP,
			float cranfieldAnalyzerLMDirichletQueryParserSetRecall,
			float cranfieldAnalyzerLMDirichletMultiFieldQueryParserMAP,
			float cranfieldAnalyzerLMDirichletMultiFieldQueryParserSetRecall,
			float cranfieldAnalyzerLMJelinekMercerQueryParserMAP,
			float cranfieldAnalyzerLMJelinekMercerQueryParserSetRecall,
			float cranfieldAnalyzerLMJelinekMercerMultiFieldQueryParserMAP,
			float cranfieldAnalyzerLMJelinekMercerMultiFieldQueryParserSetRecall) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Scores using the StandardAnalyzer

		// BM25 scoring
		dataset.addValue(standardAnalyzerBM25QueryParserMAP, "MAP", "StandardAnalyzer + BM25 + QueryParser");
		dataset.addValue(standardAnalyzerBM25QueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + BM25 + QueryParser");
		dataset.addValue(standardAnalyzerBM25MultiFieldQueryParserMAP, "MAP",
				"StandardAnalyzer + BM25 + MultiFieldQueryParser");
		dataset.addValue(standardAnalyzerBM25MultiFieldQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + BM25 + MultiFieldQueryParser");

		// VSM scoring
		dataset.addValue(standardAnalyzerVSMQueryParserMAP, "MAP", "StandardAnalyzer + VSM + QueryParser");
		dataset.addValue(standardAnalyzerVSMQueryParserSetRecall, "Set_Recall", "StandardAnalyzer + VSM + QueryParser");
		dataset.addValue(standardAnalyzerVSMMultiFieldQueryParserMAP, "MAP",
				"StandardAnalyzer + VSM + MultiFieldQueryParser");
		dataset.addValue(standardAnalyzerVSMMultiFieldQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + VSM + MultiFieldQueryParser");

		// LMDirichlet scoring
		dataset.addValue(standardAnalyzerLMDirichletQueryParserMAP, "MAP",
				"StandardAnalyzer + LMDirichlet + QueryParser");
		dataset.addValue(standardAnalyzerLMDirichletQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + LMDirichlet + QueryParser");
		dataset.addValue(standardAnalyzerLMDirichletMultiFieldQueryParserMAP, "MAP",
				"StandardAnalyzer + LMDirichlet + MultiFieldQueryParser");
		dataset.addValue(standardAnalyzerLMDirichletMultiFieldQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + LMDirichlet + MultiFieldQueryParser");

		// LMJelinekMercer scoring
		dataset.addValue(standardAnalyzerLMJelinekMercerQueryParserMAP, "MAP",
				"StandardAnalyzer + LMJelinekMercer + QueryParser");
		dataset.addValue(standardAnalyzerLMJelinekMercerQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + LMJelinekMercer + QueryParser");
		dataset.addValue(standardAnalyzerLMJelinekMercerMultiFieldQueryParserMAP, "MAP",
				"StandardAnalyzer + LMJelinekMercer + MultiFieldQueryParser");
		dataset.addValue(standardAnalyzerLMJelinekMercerMultiFieldQueryParserSetRecall, "Set_Recall",
				"StandardAnalyzer + LMJelinekMercer + MultiFieldQueryParser");

		// Scores using the CranfieldAnalyzer

		// BM25 scoring
		dataset.addValue(cranfieldAnalyzerBM25QueryParserMAP, "MAP", "CranfieldAnalyzer + BM25 + QueryParser");
		dataset.addValue(cranfieldAnalyzerBM25QueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + BM25 + QueryParser");
		dataset.addValue(cranfieldAnalyzerBM25MultiFieldQueryParserMAP, "MAP",
				"CranfieldAnalyzer + BM25 + MultiFieldQueryParser");
		dataset.addValue(cranfieldAnalyzerBM25MultiFieldQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + BM25 + MultiFieldQueryParser");

		// VSM scoring
		dataset.addValue(cranfieldAnalyzerVSMQueryParserMAP, "MAP", "CranfieldAnalyzer + VSM + QueryParser");
		dataset.addValue(cranfieldAnalyzerVSMQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + VSM + QueryParser");
		dataset.addValue(cranfieldAnalyzerVSMMultiFieldQueryParserMAP, "MAP",
				"CranfieldAnalyzer + VSM + MultiFieldQueryParser");
		dataset.addValue(cranfieldAnalyzerVSMMultiFieldQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + VSM + MultiFieldQueryParser");

		// LMDirichlet scoring
		dataset.addValue(cranfieldAnalyzerLMDirichletQueryParserMAP, "MAP",
				"CranfieldAnalyzer + LMDirichlet + QueryParser");
		dataset.addValue(cranfieldAnalyzerLMDirichletQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + LMDirichlet + QueryParser");
		dataset.addValue(cranfieldAnalyzerLMDirichletMultiFieldQueryParserMAP, "MAP",
				"CranfieldAnalyzer + LMDirichlet + MultiFieldQueryParser");
		dataset.addValue(cranfieldAnalyzerLMDirichletMultiFieldQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + LMDirichlet + MultiFieldQueryParser");

		// LMJelinekMercer scoring
		dataset.addValue(cranfieldAnalyzerLMJelinekMercerQueryParserMAP, "MAP",
				"CranfieldAnalyzer + LMJelinekMercer + QueryParser");
		dataset.addValue(cranfieldAnalyzerLMJelinekMercerQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + LMJelinekMercer + QueryParser");
		dataset.addValue(cranfieldAnalyzerLMJelinekMercerMultiFieldQueryParserMAP, "MAP",
				"CranfieldAnalyzer + LMJelinekMercer + MultiFieldQueryParser");
		dataset.addValue(cranfieldAnalyzerLMJelinekMercerMultiFieldQueryParserSetRecall, "Set_Recall",
				"CranfieldAnalyzer + LMJelinekMercer + MultiFieldQueryParser");

		// Create chart based on the dataset
		JFreeChart chart = ChartFactory.createBarChart("Evaluation of search engines", "", "Score", dataset,
				PlotOrientation.HORIZONTAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis xAxis = plot.getDomainAxis();
		ValueAxis yAxis = plot.getRangeAxis();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setShadowVisible(false);
		renderer.setDrawBarOutline(true);
		for (int i = 0; i < dataset.getRowCount(); i++) {
			Paint black = Color.BLACK;
			renderer.setSeriesOutlinePaint(i, black);
			renderer.setSeriesOutlineStroke(i, new BasicStroke(1.5f));
		}
		Font boldFont = new Font("Serif", Font.BOLD, 13);
		xAxis.setTickLabelFont(boldFont);
		yAxis.setTickLabelFont(boldFont);
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(new Font("Serif", Font.BOLD, 20));
		legend.setLegendItemGraphicPadding(new RectangleInsets(0, 10, 0, 10));

		return chart;
	}
}
