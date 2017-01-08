/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GraphElementViewer 
{
	static boolean isRectanglePressed = false;
	static boolean isEllipsePressed = false;
	static boolean isLabelPressed = false;
	static boolean isEdgePressed = false;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
	      
		final int FRAME_WIDTH  = 1000;
		final int FRAME_HEIGHT = 700;
  
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("CPS 209 Assignment 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
	    frame.add(panel,BorderLayout.NORTH);
	    
	    final JButton btnRectangle = new JButton("Rectangle");
	    panel.add(btnRectangle);
	    
	    class RectangleButtonListener implements ActionListener
	    { 
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		isRectanglePressed= true;
	    		isEllipsePressed = false;
	    		isLabelPressed = false;
	    		isEdgePressed = false;
	    	}      
	    }
	    
	    ActionListener rectButtonListener = new RectangleButtonListener();
	    btnRectangle.addActionListener(rectButtonListener);
	    	    
	    final JButton btnEclipse = new JButton("Ellipse");
	    panel.add(btnEclipse);
	    
	    class EllipseButtonListener implements ActionListener
	    { 
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		isRectanglePressed= false;
	    		isEllipsePressed = true;
	    		isLabelPressed = false;
	    		isEdgePressed = false;
	    	}      
	    }
	    
	    ActionListener ellipseButtonListener = new EllipseButtonListener();
	    btnEclipse.addActionListener(ellipseButtonListener);
	    
	    final JButton btnEdge = new JButton("Edge");
	    panel.add(btnEdge);
	    
	    class EdgeButtonListener implements ActionListener
	    { 
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		isRectanglePressed = false;
	    		isEllipsePressed = false;
	    		isLabelPressed = false;
	    		isEdgePressed = true;
	    	}      
	    }
	    
	    ActionListener btnEdgeListener = new EdgeButtonListener();
	    btnEdge.addActionListener(btnEdgeListener);
	    
	    final JButton btnLabel = new JButton("Label");
	    panel.add(btnLabel);
	    
	    
	    final JTextField txtLabel = new JTextField(10);
	    panel.add(txtLabel);
	    
	    final JComponent component = new GraphElementComponent();
	    frame.add(component);
	    
	    class LabelButtonListener implements ActionListener
	    { 
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		isRectanglePressed = false;
	    		isEllipsePressed = false;
	    		isLabelPressed = true;
	    		isEdgePressed = false;
	    		
	    		String lblText = txtLabel.getText();
	    		if(!lblText.equals("")) {
	    			GraphElementComponent.setLabel(lblText);
	    			component.repaint();
	    		}
	    		
	    	}      
	    }
	    
	    ActionListener lblButtonListener = new LabelButtonListener();
	    btnLabel.addActionListener(lblButtonListener);
	    
	    
	    frame.setVisible(true);
	}
	
	public static boolean getIsRectanglePressed()
	{
		return isRectanglePressed;
	}
	
	public static void setIsRectanglePressed(boolean val)
	{
		isRectanglePressed = val; 
	}
	
	public static boolean getIsEllipsePressed()
	{
		return isEllipsePressed;
	}
	
	public static void setIsEllipsePressed(boolean val)
	{
		isEllipsePressed = val; 
	}
	
	public static boolean getIsLabelPressed()
	{
		return isLabelPressed;
	}
	
	public static void setIsLabelPressed(boolean val)
	{
		isLabelPressed = val; 
	}
	
	public static boolean getIsEdgePressed()
	{
		return isEdgePressed;
	}
	
	public static void setIsEdgePressed(boolean val)
	{
		isEdgePressed = val; 
	}

}
