/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */

import java.awt.Color;
import java.awt.Graphics2D;

// General element of a graph (nodes and edges)

abstract public class GraphElement {
	private double xPos;
	private double yPos;
	protected String label;
	protected Color color;
	boolean selected;

	public GraphElement() {
		xPos = 0;
		yPos = 0;
		label = "";
		color = Color.BLACK;
	}

	public GraphElement(double x, double y) {
		xPos = x;
		yPos = y;
		label = "";
		color = Color.BLACK;
	}

	public final double getXPos() {
		return xPos;
	}

	public final double getYPos() {
		return yPos;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void moveTo(double xLoc, double yLoc) {
		xPos = xLoc;
		yPos = yLoc;
	}

	public String toString() {
		String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n";
		return str;
	}

	abstract void setPoint2(int x, int y);
	
	abstract void draw(Graphics2D g2);

	abstract boolean isClicked(double x, double y);

	abstract boolean applyLabel();
	
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setIsSelected(boolean val) {
		this.selected = val;
	}

	public boolean getIsSelected() {
		return this.selected;
	}
}
