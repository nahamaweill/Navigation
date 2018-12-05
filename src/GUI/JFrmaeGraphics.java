package GUI;
import java.awt.Color;
/**
 * Code taken from: https://javatutorial.net/display-text-and-graphics-java-jframe
 * 
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JFrmaeGraphics extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		    Image image = Toolkit.getDefaultToolkit().getImage("Ariel1");
			int w = this.getWidth();
			int h = this.getHeight();
			 g.setColor(Color.red);
			 g.fillOval(w/3, h/3, w/3, h/3);
			g.setColor(Color.blue);
			String s = " ["+w+","+h+"]";
		    g.drawString(s, w/3, h/2);
		    g.drawImage(image, w, h, getBackground(), null);
		   
		    
	}
	
	public static void main(String[] args){
		JFrame frame= new JFrame("JavaTutorial.net");	
		frame.getContentPane().add(new JFrmaeGraphics());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setName("JFrame example");
		frame.add(new JLabel(new ImageIcon("Ariel1")));
	}
}