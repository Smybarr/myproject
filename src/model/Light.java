package model;

/**
 * A light has a boolean state.
 * 
 * PATTERN: Use a state pattern here? 
 */
public class Light implements Agent {
	
	Light() { } // Created only by this package

	private boolean state;

	public boolean getState() {
		return state;
	}
	
	public void run(double time) {
		if (time % 40 == 0) {
			state = !state;
		}
	}
}

