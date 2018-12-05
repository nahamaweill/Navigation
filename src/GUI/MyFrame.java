package GUI;

import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements MouseListener {

	public BufferedImage myImage;
    public File f = null;
    private ArrayList<Point> click=null;


	public MyFrame()
	{
		myGUI();
		this.addMouseListener(this);

	}

	private void myGUI() {
		
		try{
		      f = new File("C:\\Users\\nahama\\Desktop\\Ex3\\Ariel1.jpg");
		      myImage = ImageIO.read(f);
		    }catch(IOException e){
		      System.out.println(e);
		    }
		
		MenuBar menuBar = new MenuBar();

		this.setMenuBar(menuBar);
		this.setLocation(200, 200);
		this.setSize(500, 500);


	}

	int x = -1;
	int y = -1;

	public void paint(Graphics g)
	{

		g.drawImage(myImage, 0, 0, this);

		if(x!=-1 && y!=-1)
		{
			int r = 20;
			x = x - (r / 2);
			y = y - (r / 2);
			g.fillOval(x, y, r, r);
//			for (int i=0; i<click.size(); i++)
//			{
//				
//			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg0.getX() + "," + arg0.getY() +")");
		x = arg0.getX();
		y = arg0.getY();
		Point p= new Point(arg0.getX(),arg0.getY());
//		click.add(p);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
