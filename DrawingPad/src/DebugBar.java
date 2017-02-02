import java.util.*;
import javax.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;

public class DebugBar extends JPanel{
	
	public JLabel statusBar;
	public JButton b;
	public Color color = Color.BLACK;
	private JSlider sizeSet;
	
	DebugBar(){
		statusBar = new JLabel("Default");
		add(statusBar);
		
		
		b = new JButton("Change Color");
		add(b);
		
		b.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					color = JColorChooser.showDialog(null, "Pick a color", color);
					if(color==null){
						color=(Color.BLACK);
					}
					
					Canvas.currentColor = color;
				}
			}
		);
		
		sizeSet = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 10);
		sizeSet.setMajorTickSpacing(10);
		add(sizeSet);
		sizeSet.setPaintTicks(true);
		sizeSet.addChangeListener(
			new ChangeListener(){
				public void stateChanged(ChangeEvent e){
					Canvas.size = sizeSet.getValue();
				}
			}
		);
		
		
		
		
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(150, 50);
	}
	
}
