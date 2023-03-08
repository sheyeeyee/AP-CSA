package snake;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {	
	public BufferedImage loader(String filePath) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filePath));
		}
		catch(IOException e) {
			System.err.println(e);
		}
		return img;
	}
	
//	BufferedImage trophy; {
//		try {
//			File file = new File("src/images/trophy for score.png");
//			FileInputStream fis = new FileInputStream(file);
//			trophy = ImageIO.read(fis);
//		}
//		catch(IOException e) {
//			System.err.println(e);
//		}
//	}
//	BufferedImage snake; {
//		try {
//			File file = new File("src/images/snakeimage.png");
//			FileInputStream fis = new FileInputStream(file);
//			trophy = ImageIO.read(fis);
//		}
//		catch(IOException e) {
//			System.err.println(e);
//		}
//	}
}
