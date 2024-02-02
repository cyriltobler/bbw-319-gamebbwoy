package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.internal.GameBbwoy;

public class ExampleDrawing implements PixelDrawing, ButtonListener {

	private final PixelSprite ball = PixelSprite.ball();
	private final MovableSprite movingBall = new MovableSprite(ball);
	private final Starfield starfield = new Starfield();

	public static void main(String[] args) throws Throwable {
		GameBbwoy.playGame(new ExampleDrawing());
	}

	@Override
	public void initialize(PixelDisplay graphic) {
		// put the ball in the middle of the screen
		ball.setX((double) graphic.getPixelWidth() / 2);
		ball.setY((double) graphic.getPixelHeight() / 2);
	}

	@Override
	public void tick(PixelDisplay graphic) {
		graphic.clear();
		starfield.tick(graphic); // background is drawn before the ball
		movingBall.tick(graphic);
	}

	@Override
	public void onButtonPress(GameButton button) {
		System.out.println("down: " + button);
		movingBall.onButton(button, true);
	}

	@Override
	public void onButtonRelease(GameButton button) {
		System.out.println("up: " + button);
		movingBall.onButton(button, false);
	}
}
