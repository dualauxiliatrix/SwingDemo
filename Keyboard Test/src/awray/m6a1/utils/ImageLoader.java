package awray.m6a1.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {
	// private constructor to prevent the instantiation of this class
	private ImageLoader() {
	}

	// will store loaded images here so we don't load them again
	private static HashMap<String, BufferedImage> cache = new HashMap<>();

	// will be used all across the game to load images
	public static BufferedImage load(String name) {
		// will first look in the cache
		BufferedImage found = cache.get(name);

		if (found == null) {
			try {
				found = ImageIO.read(new File("src/Graphics/" + name + ".png"));
				cache.put(name, found);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return found;
	}
}
