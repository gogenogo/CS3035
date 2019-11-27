package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CWidget extends Pane {
	private Canvas canvas;
	private final double width;
	private final double height;
	private final DoubleProperty percentProperty = new SimpleDoubleProperty();
	
	CWidget(double width, double height, double percentage){
		canvas = new Canvas(width, height);
		this.width = width - 16;
		this.height = height - 16;
		this.getChildren().add(canvas);
		percentProperty.set(percentage);
		drawArc();
	}
	
	public double getPercentvalue() {
        return percentProperty.get();
    }
	
	public int convertPercentageDegrees() {
		return (int) ((percentProperty.get() * 360) / 100);
	}
	
	public void drawArc() {
		
		GraphicsContext gc1 = canvas.getGraphicsContext2D();
		gc1.setFont(Font.font("Roboto", FontWeight.BOLD, 14));
		gc1.fillText(Integer.toString((int) percentProperty.get()), width/2, canvas.getHeight()/2 + 4);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.web("#EFFDFC"));
		gc.setLineWidth(8);
		gc.strokeArc(8, 8, width, height, 90 - (360 - this.convertPercentageDegrees()), (360 - this.convertPercentageDegrees()), ArcType.OPEN);
		if (percentProperty.get() > 55) {
			gc1.setStroke(Color.BLUE);
		} else if (percentProperty.get() > 25 && percentProperty.get() <= 55){
			gc1.setStroke(Color.web("#FFD361"));
		} else if (percentProperty.get() <= 25) {
			gc1.setStroke(Color.web("#FF3B77"));
		}
		gc1.strokeArc(8, 8, width, height, 90, this.convertPercentageDegrees(), ArcType.OPEN);
		
	}
	public DoubleProperty percentageValueProperty() {
        return percentProperty;
    }
    public void setcontrolvalue(double value) {
    	percentProperty.set(value);
    }
	

}
