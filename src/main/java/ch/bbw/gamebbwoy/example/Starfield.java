package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

import java.util.List;
import java.util.stream.Stream;

/**
 * Draws a starfield-effect.
 */
public class Starfield implements PixelDrawing {

	private final List<Star> stars = Stream.generate(Star::new).limit(100).toList();

	@Override
	public void tick(PixelDisplay graphic) {
		for (var star : stars) {
			star.tick(graphic);
		}
	}

	static class Star implements PixelDrawing {

		private final double vx = (Math.random() - 0.5) * 2;
		private final double vy = (Math.random() - 0.5) * 1.5;
		private double x;
		private double y;

		@Override
		public void tick(PixelDisplay graphic) {
			var halfWidth = graphic.getPixelWidth() / 2;
			var halfHeight = graphic.getPixelHeight() / 2;
			x += vx;
			y += vy;
			if (Math.abs(x) >= halfWidth || Math.abs(y) >= halfHeight) { // reset to center
				x = 0;
				y = 0;
			}
			// stars become more visible the further out they are
			var color = (int) Math.min((Math.abs(x) + Math.abs(y)) / (halfWidth + halfHeight) * 4 + 0.5, 3);
			graphic.setPixel((int) x + halfWidth, (int) y + halfHeight, PixelColor.fromValue(color));
		}
	}
}
