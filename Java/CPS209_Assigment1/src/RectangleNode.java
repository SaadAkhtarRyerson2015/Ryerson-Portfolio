/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class RectangleNode extends GraphElement
{
	private Rectangle rectangle;
	
	public RectangleNode(int x, int y)
	{
		super(x, y);
		rectangle = new Rectangle(x, y, 150, 50);
		selected = false;
	}
	
	public boolean isClicked(double x, double y)
	{
		
		return rectangle.contains(x, y);
	}
	
    public boolean applyLabel()
    {
    	return true;
    }
	
	public void draw(Graphics2D g2)
	{
		if(this.getIsSelected()){
			rectangle.setLocation((int) this.getXPos(), (int) this.getYPos());
			g2.setColor(Color.green);
			
		}
		g2.draw(rectangle);
		g2.setColor(color);
		
		if(!this.getLabel().equals("")) {
			int lblx = (int) this.getXPos() + 40;
			int lbly = (int) this.getYPos() + 20;
			g2.drawString(this.getLabel(), lblx, lbly);
		}
		
	}
	
	public void setPoint2(int x, int y)
	{
		
	}
	
}
