package Packman_Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Map {

	private Image image;

	Map() {
		image = null;
	}

	Map(String imgLocation) throws IOException {
		File f = new File(imgLocation);
		image = ImageIO.read(f);
	}

	public Point2D Pixel2Point(Pixel pixel) {
		int width = image.getWidth((ImageObserver) this.image);
		int height = image.getHeight((ImageObserver) this.image);
		
		return null;
	}

}
