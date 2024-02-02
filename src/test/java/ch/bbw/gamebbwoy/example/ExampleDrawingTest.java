package ch.bbw.gamebbwoy.example;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class ExampleDrawingTest implements WithAssertions {

	private static class MockGraphic implements PixelDisplay {
		int count = 0;
		@Override
		public void setPixel(int x, int y, PixelColor color) {
			if (color != PixelColor.WHITE) {
				count++;
			}
		}
	}

	@Test
	void thereIsABall() {
		// GIVEN
		var graphic = new MockGraphic();
		var logic = new ExampleDrawing();

		// WHEN
		logic.tick(graphic);

		// THEN
		assertThat(graphic.count).as("drawing a 5x5 ball")
				.isEqualTo(5 * 5 - 4); // 4 edge pixels not colored
	}
}
