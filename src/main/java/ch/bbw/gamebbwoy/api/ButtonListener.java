package ch.bbw.gamebbwoy.api;

public interface ButtonListener {

	/**
	 * Fires when a button is pressed at least once.
	 * Depending on the keyboard, this event is re-triggered rapidly.
	 *
	 * @param button the button that is held down
	 */
	void onButtonPress(GameButton button);

	/**
	 * Fires once a button is released.
	 *
	 * @param button the button that is released
	 */
	void onButtonRelease(GameButton button);

	enum GameButton {
		LEFT,
		RIGHT,
		UP,
		DOWN,
		SPACE,
		CTRL
	}

}
