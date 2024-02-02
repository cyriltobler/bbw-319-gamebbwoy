package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

import java.util.List;

/**
 * Draws a <a href="https://de.wikipedia.org/wiki/Sprite_(Computergrafik)">Sprite</a>.
 */
public class PixelSprite implements PixelDrawing {

	private final List<Integer> pixels;
	private final int width;
	private final int height;
	/**
	 * x,y are represented as {@code double} to move it around the screen fluently. When drawing it, they are always
	 * reduced (rounded down) to an {@code int}.
	 */
	private double x;
	private double y;

	/**
	 * A Pixel-Image represented as a one-dimensional array. {@code width * height} must be the same as
	 * {@code pixels.size()}.
	 *
	 * @param pixels One-dimensional array holding all pixel values. Pixel at position (h,w) can be obtained via
	 *               pixels.get(h + w * height).
	 * @param width  (Breite) in pixels
	 * @param height (Höhe) in pixels
	 */
	public PixelSprite(List<Integer> pixels, int width, int height) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		if (width * height != pixels.size()) {
			throw new IllegalArgumentException("pixel size does not match provided width/height");
		}
	}

	public static PixelSprite ball() {
		// Note only valid PixelColor values are used here
		// @formatter:off
		return new PixelSprite(List.of(
				0, 3, 3, 3, 0,
				3, 1, 1, 1, 3,
				3, 1, 1, 1, 3,
				3, 1, 1, 1, 3,
				0, 3, 3, 3, 0), 5, 5);
		// @formatter:on
	}

	@Override
	public void tick(PixelDisplay graphic) {
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				var color = pixels.get(h + w * height);
				graphic.setPixel(w + (int) x, h + (int) y, PixelColor.fromValue(color));
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
