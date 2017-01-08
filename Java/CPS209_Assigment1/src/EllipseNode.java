/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class EllipseNode extends GraphElement {
	
	private Ellipse2D.Double ellipse;

	public EllipseNode(int x, int y) {
		super(x, y);
		ellipse = new Ellipse2D.Double(x, y, 150, 50);
		selected = false;
	}

	public boolean isClicked(double x, double y) {

		return ellipse.contains(x, y);
	}

	public boolean applyLabel() {
		return true;
	}

	public void draw(Graphics2D g2) {
		if (this.getIsSelected()) {
			ellipse.setFrame(this.getXPos(), this.getYPos(), 150, 50);
			g2.setColor(Color.green);

		}
		g2.draw(ellipse);
		g2.setColor(color);

		if (!this.getLabel().equals("")) {
			int lblx = (int) this.getXPos() + 40;
			int lbly = (int) this.getYPos() + 20;
			g2.drawString(this.getLabel(), lblx, lbly);
		}

	}
	
	public void setPoint2(int x, int y)
	{
		
	}
}
