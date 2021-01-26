package fr.epita.viz;

import java.util.Arrays;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.Histogram;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class Main {

	public static void main(String[] args) {


		// Create Chart
		CategoryChart chart = new CategoryChartBuilder()
				.width(800).height(600)
				.title("grades distribution")
				.xAxisTitle("grades")
				.yAxisTitle("# of occurrences")
				.theme(Styler.ChartTheme.GGPlot2).build();

		// Customize Chart

		// Series
		chart.addSeries("grades", Arrays.asList(5.0,4.0,3.0), Arrays.asList(2.0, 4.0,2.0));

		new SwingWrapper<CategoryChart>(chart).displayChart();


	}
}
