import java.util.*;
import java.util.List;

import javax.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Canvas extends JPanel{
	
	public DebugBar debug;
	private String details;
	private int circX=9999;
	private int circY=9999;
	private List<Integer> drawnX = new ArrayList<Integer>();
	private List<Integer> drawnY = new ArrayList<Integer>();
	public static int size=5;
	private List<Color> colors = new ArrayList<Color>();
	public static Color currentColor = Color.BLACK;
	private JButton clear;
	private List<Integer> sizes = new ArrayList<Integer>();
	
	Canvas(){
		
		debug = new DebugBar();
		
		addMouseMotionListener(
			new MouseClass(){
				public void mouseDragged(MouseEvent event){
					details = String.format("X:%s   Y:%s", event.getX(), event.getY());
					debug.statusBar.setText(details);
					
					circX = event.getX();
					circY = event.getY();
					
					drawnX.add(circX);
					drawnY.add(circY);
					colors.add(currentColor);
					sizes.add(size);
					
					repaint();
				}
			}	
		);
		
		clear = new JButton("Clear Screen");
		add(clear);
		clear.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					clearScreen();
					repaint();
				}
			}
		);
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i=0;i<drawnY.size();i++){
			g.setColor(colors.get(i));
			g.fillOval(drawnX.get(i), drawnY.get(i), sizes.get(i), sizes.get(i));
		}
		
	}
	
	public class MouseClass extends MouseAdapter{
	}
	
	
	public Dimension getPreferredSize(){
		return new Dimension(100, 785);
	}
	
	public void clearScreen(){
		drawnX = new ArrayList<Integer>();
		drawnY = new ArrayList<Integer>();
		colors = new ArrayList<Color>();
		sizes = new ArrayList<Integer>();
	}
	
}
