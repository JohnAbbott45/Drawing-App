import javax.swing.JFrame;

public class DrawingPadMain {

	public static void main(String[] args) {
		TheWindow w = new TheWindow();
		w.setVisible(true);
		w.setExtendedState(JFrame.MAXIMIZED_BOTH);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
