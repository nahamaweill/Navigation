package Packman_Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Geom.Point3D;

public class Map {

	private Image image;

	Map() {
		image = null;
	}

	Map(String imgLocation) throws IOException {
		File f = new File(imgLocation);
		image = ImageIO.read(f);
	}

	public Point3D Pixel2Point(Pixel pixel) {
		int width = image.getWidth((ImageObserver) this.image);
		int height = image.getHeight((ImageObserver) this.image);
		double x = pixel.getX() / (double) height;
		double y = pixel.getY() / (double) width;
		Point3D ans = new Point3D(x, y);
		return ans;
	}

	final int image_width = 1433;
	final int image_height = 642;

	public Pixel Point2Pixel(Point3D point) {
		int width = image.getWidth((ImageObserver) this.image);
		int height = image.getHeight((ImageObserver) this.image);
		int w = width / image_width;
		int h = height / image_height;
		Pixel ans = new Pixel(point.get_x() * h, point.get_y() * w);
		return ans;
	}
	
	

}
