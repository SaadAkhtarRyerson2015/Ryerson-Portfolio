/*
 * Name: Saad Akhtar
 * Student ID: 500539435
 * Class: CPS 209
 * 
 * */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GraphElementComponent extends JComponent {

	private ArrayList<GraphElement> shapes = new ArrayList<GraphElement>();
	private int selectedIndex = -1;
	public static String label = "";
	public static boolean drawLabel = false;
	private boolean lineDrawn = false;

	public GraphElementComponent() {

		class MousePressListener implements MouseListener {
			public void mousePressed(MouseEvent event) {

				int x = event.getX();
				int y = event.getY();

				if (SwingUtilities.isRightMouseButton(event)) {
					if (!shapes.isEmpty() && selectedIndex >= 0) {
						shapes.remove(shapes.get(selectedIndex));
						selectedIndex = -1;
						repaint();
					}
				}

				if (GraphElementViewer.getIsEdgePressed()) {

					Edge newPoint = new Edge(x, y);
					shapes.add(newPoint);
					lineDrawn = false;
					selectedIndex = shapes.size() - 1;
				}

				for (int i = 0; i < shapes.size(); i++) {

					if (shapes.get(i).isClicked(x, y)) {
						selectedIndex = i;
						shapes.get(i).setIsSelected(true);
					} else {
						shapes.get(i).setIsSelected(false);
					}
				}
				repaint();

			}

			public void mouseReleased(MouseEvent event) {

				int x = event.getX();
				int y = event.getY();

				if (GraphElementViewer.getIsRectanglePressed()) {

					GraphElementViewer.setIsRectanglePressed(false);
					RectangleNode newShape = new RectangleNode(x, y);
					shapes.add(newShape);
					repaint();

				}

				if (GraphElementViewer.getIsEllipsePressed()) {
					GraphElementViewer.setIsEllipsePressed(false);
					EllipseNode newShape = new EllipseNode(x, y);
					shapes.add(newShape);
					repaint();
				}

				if (GraphElementViewer.getIsEdgePressed()) {
					lineDrawn = true;
					GraphElementViewer.setIsEdgePressed(false);
				}

			}

			public void mouseClicked(MouseEvent event) {
			}

			public void mouseEntered(MouseEvent event) {
			}

			public void mouseExited(MouseEvent event) {
			}
		}

		MousePressListener mListener = new MousePressListener();
		this.addMouseListener(mListener);

		class MouseMotion implements MouseMotionListener {
			public void mouseDragged(MouseEvent event) {

				if (GraphElementViewer.getIsEdgePressed() && selectedIndex >= 0) {
					int x = event.getX();
					int y = event.getY();

					shapes.get(selectedIndex).setPoint2(x, y);
					lineDrawn = true;
					repaint();
				} else {
					if (!shapes.isEmpty() && selectedIndex >= 0) {
						shapes.get(selectedIndex).moveTo(event.getX(),
								event.getY());
						repaint();
					}
				}
			}

			public void mouseMoved(MouseEvent event) {
			}
		}

		MouseMotion motionListener = new MouseMotion();
		addMouseMotionListener(motionListener);
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		if (!shapes.isEmpty()) {
			for (GraphElement shape : shapes) {
				if (shape.getIsSelected()) {

					if (GraphElementComponent.drawLabel) {
						shape.setLabel(label);
						GraphElementComponent.drawLabel = false;
					}
				}
				shape.draw(g2);
			}
		}

	}

	public static void setLabel(String lbl) {
		label = lbl;
		drawLabel = true;
	}

}
