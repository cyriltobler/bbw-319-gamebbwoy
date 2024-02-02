package ch.bbw.gamebbwoy.api;


public interface PixelDrawing {

	/**
	 * Called once before the first drawing.
	 *
	 * @param graphic the pixel-graphic instance to draw on.
	 */
	default void initialize(PixelDisplay graphic) {
	}

	/**
	 * A tick is invoked once per frame. So this method is called several times per second to re-draw the display.
	 *
	 * @param graphic the pixel-graphic instance to draw on.
	 */
	void tick(PixelDisplay graphic);
}
