package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.ButtonListener.GameButton;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class MoveableSpriteTest implements WithAssertions {

	@Test
	void onButtonRightAcceleratesX() {
		// GIVEN
		var mover = new MovableSprite(null);
		var xBefore = mover.xAcceleration;

		// WHEN
		mover.onButton(GameButton.RIGHT, true);

		// THEN
		assertThat(mover.xAcceleration).isGreaterThan(xBefore);
	}
}
