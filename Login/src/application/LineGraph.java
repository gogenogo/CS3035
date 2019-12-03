package application;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class LineGraph extends Pane {
	
	
	public LineGraph(String title, String week, double[] array) { 
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")));  
		xAxis.setLabel("Day of the Week"); 
		yAxis.setLabel("Total spending $");
		LineChart<CategoryAxis, NumberAxis> linechart = new LineChart(xAxis, yAxis);
		linechart.setTitle(title);
		XYChart.Series<CategoryAxis, NumberAxis> series = new XYChart.Series<CategoryAxis, NumberAxis>();
		//series.setName("Week of:" + week);
		linechart.setLegendVisible(false);
		series.getData().add(new XYChart.Data("Sun", array[1]));
		series.getData().add(new XYChart.Data("Mon", array[2]));
		series.getData().add(new XYChart.Data("Tue", array[3]));
		series.getData().add(new XYChart.Data("Wed", array[4]));
		series.getData().add(new XYChart.Data("Thu", array[5]));
		series.getData().add(new XYChart.Data("Fri", array[6]));
		series.getData().add(new XYChart.Data("Sat", array[0]));

		linechart.getData().add(series);
		linechart.setMaxSize(400, 350);
		this.getChildren().add(linechart);
	}
	
}
