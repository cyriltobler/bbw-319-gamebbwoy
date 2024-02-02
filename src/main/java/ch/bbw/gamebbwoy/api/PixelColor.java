package ch.bbw.gamebbwoy.api;

/**
 * The GameBbwoy supports only four colors from
 * {@link PixelColor#WHITE} (no color) to {@link PixelColor#BLACK} (very dark).
 */
public enum PixelColor {
	WHITE,
	LOW,
	HIGH,
	BLACK;

	/**
	 * @param colorIndex a color value from 0 to 3 (inclusive).
	 * @return the corresponding PixelColor enum
	 */
	public static PixelColor fromValue(int colorIndex) {
		if (colorIndex < WHITE.ordinal() || BLACK.ordinal() < colorIndex) {
			throw new IllegalArgumentException("invalid color-index provided: " + colorIndex +
					", expected would be a value between 0 and 3 (inclusive)");
		}
		return values()[colorIndex];
	}
}
