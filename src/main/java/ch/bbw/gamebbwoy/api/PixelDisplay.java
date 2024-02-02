package ch.bbw.gamebbwoy.api;

/**
 * Interface representing a rectangular screen along and the option to modify individual pixels.
 */
public interface PixelDisplay {

	/**
	 * Overrides a single pixel on the screen with the specified color.
	 * The point (0,0) is the pixel top left. x-coordinate goes right.
	 * y-coordinate goes down.
	 *
	 * @param x     The horizontal distance from top left.
	 *              Must be in bounds 0 to {@link PixelDisplay#getPixelWidth()} (exclusive).
	 * @param y     The vertical distance from top left.
	 *              Must be in bounds 0 to {@link PixelDisplay#getPixelHeight()} (exclusive).
	 * @param color The four supported color values, never <i>null</i>.
	 */
	void setPixel(int x, int y, PixelColor color);

	/**
	 * @return The screen width (Breite) in pixels. Corresponds to the x-coordinate.
	 */
	default int getPixelWidth() {
		return 160;
	}

	/**
	 * @return The screen height (Höhe) in pixels. Corresponds to the y-coordinate.
	 */
	default int getPixelHeight() {
		return 144;
	}

	/**
	 * Resets all pixel to color {@code PixelColor#WHITE}.
	 */
	default void clear() {
		for (int y = 0; y < getPixelHeight(); y++) {
			for (int x = 0; x < getPixelHeight(); x++) {
				setPixel(x, y, PixelColor.WHITE);
			}
		}
	}

}
