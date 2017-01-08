/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Edge extends GraphElement
{
	private Point2D.Double p1;
	private Point2D.Double p2;
	private Line2D.Double line;
	private boolean isP1Set;
	private boolean isP2Set;
	
	public Edge(int x, int y)
	{
		super(x, y);
		p1 = new Point2D.Double(x,y);
		p2 = new Point2D.Double(x,y);
		line = new Line2D.Double(p1,p2);
		isP1Set = true;
		isP2Set = false;
	}
	
	public void setPoint2(int x, int y)
	{
		isP2Set = true;
		p2 = new Point2D.Double(x,y);
		line = new Line2D.Double(p1,p2);
	}
	
	public boolean getIsP1Set()
	{
		return isP1Set;
	}
	
	public void setIsP1Set(boolean val)
	{
		isP1Set = val;
	}
	
	public boolean getIsP2Set()
	{
		return isP2Set;
	}
	
	public void setIsP2Set(boolean val)
	{
		isP2Set = val;
	}
	
	public boolean isClicked(double x, double y)
	{
		
		return line.intersects(x, y, 10, 10);
	}
	
    public boolean applyLabel()
    {
    	return true;
    }
	
	public void draw(Graphics2D g2)
	{
		if(this.getIsSelected())
			g2.setColor(Color.green);
			
		g2.draw(line);
		g2.setColor(color);
		
		
	}

}
