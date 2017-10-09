package project3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class BarChart extends JFrame {

	private JFreeChart barChart = null;

	public BarChart(String chartTitle, String xContent, String yContent, DefaultCategoryDataset dataset,
			Paint[] colorPaintArr) {
		super("applicationTitle");
		barChart = ChartFactory.createBarChart(chartTitle, xContent, yContent, dataset, PlotOrientation.VERTICAL, false,
				false, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBackground(Color.white);

		final CategoryPlot plot = barChart.getCategoryPlot();
		final CategoryAxis axis = plot.getDomainAxis();
		final ValueAxis axis2 = plot.getRangeAxis();
		plot.setNoDataMessage("NO DATA!");
		final CategoryItemRenderer renderer = new CustomRenderer(colorPaintArr);
		renderer.setItemLabelsVisible(true);
		plot.setRenderer(renderer);
		renderer.setBaseItemLabelGenerator(new IntervalCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelPaint(Color.white);

		renderer.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_RIGHT));

		renderer.setBaseItemLabelGenerator(new CategoryItemLabelGenerator() {

			@Override
			public String generateRowLabel(CategoryDataset dataset, int row) {
				return "Your Row Text  " + row;
			}

			@Override
			public String generateColumnLabel(CategoryDataset dataset, int column) {
				return "Your Column Text  " + column;
			}

			@Override
			public String generateLabel(CategoryDataset dataset, int a, int b) {

				return "" + dataset.getValue(a, b) + "   ";
			}

		});

		Font font = new Font("columnNames", Font.BOLD, 20);
		axis.setTickLabelFont(font);
		Font font2 = new Font("Values", Font.BOLD, 16);
		axis2.setTickLabelFont(font2);
		Font font3 = new Font("xyContents", Font.BOLD, 18);
		plot.getDomainAxis().setLabelFont(font3);
		plot.getRangeAxis().setLabelFont(font3);

		renderer.setItemLabelFont(font);

		add(chartPanel);

		pack();
		setTitle("Bar chart");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(chartPanel);

	}

	public JFreeChart getBarChart() {
		return barChart;
	}

	public void setBarChart(JFreeChart barChart) {
		this.barChart = barChart;
	}

	class CustomRenderer extends BarRenderer {

		/** The colors. */
		private Paint[] colors;

		/**
		 * Creates a new renderer.
		 *
		 * @param colors
		 *            the colors.
		 */
		public CustomRenderer(final Paint[] colors) {
			this.colors = colors;
		}

		/**
		 * Returns the paint for an item. Overrides the default behaviour inherited from
		 * AbstractSeriesRenderer.
		 *
		 * @param row
		 *            the series.
		 * @param column
		 *            the category.
		 *
		 * @return The item color.
		 */
		public Paint getItemPaint(final int row, final int column) {
			return this.colors[column % this.colors.length];
		}
	}

}