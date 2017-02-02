import java.util.*;
import javax.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TheWindow extends JFrame{

	private Canvas canvas;
	private DebugBar debugBar;
	
	
	TheWindow(){
		super("Drawing Pad");
		
		canvas = new Canvas();
		debugBar = canvas.debug;
		
		setLayout(new BorderLayout());
		add(debugBar, BorderLayout.SOUTH);
		add(canvas, BorderLayout.NORTH);
	}
	
}
