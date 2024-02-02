package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.ButtonListener.GameButton;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;

public class MovableSprite implements PixelDrawing {

	private final PixelSprite sprite;
	double xVelocity;
	double yVelocity;
	double xAcceleration;
	double yAcceleration;

	public MovableSprite(PixelSprite sprite) {
		this.sprite = sprite;
	}

	public void onButton(GameButton button, boolean isDown) {
		switch (button) {
			case UP -> yAcceleration = isDown ? -0.05 : 0;
			case DOWN -> yAcceleration = isDown ? 0.05 : 0;
			case LEFT -> xAcceleration = isDown ? -0.05 : 0;
			case RIGHT -> xAcceleration = isDown ? 0.05 : 0;
			default -> {
			} // ignore the rest
		}
	}

	@Override
	public void tick(PixelDisplay graphic) {
		xVelocity += xAcceleration;
		yVelocity += yAcceleration;

		var nextX = sprite.getX() + xVelocity;
		if (nextX < 0) { // out of bound on the left
			xVelocity = -xVelocity;
			nextX = -nextX;
		} else if (graphic.getPixelWidth() < (int) (sprite.getWidth() + nextX)) { // out of bounds right
			xVelocity = -xVelocity;
			var overlap = nextX + sprite.getWidth() - graphic.getPixelWidth();
			nextX -= 2 * overlap;
		}
		sprite.setX(nextX);

		var nextY = sprite.getY() + yVelocity;
		if (nextY < 0) { // out of bound on top
			yVelocity = -yVelocity;
			nextY = -nextY;
		} else if (graphic.getPixelHeight() < (int) (sprite.getHeight() + nextY)) { // out of bounds bottom
			yVelocity = -yVelocity;
			var overlap = nextY + sprite.getHeight() - graphic.getPixelHeight();
			nextY -= 2 * overlap;
		}
		sprite.setY(nextY);

		sprite.tick(graphic);
	}
}
