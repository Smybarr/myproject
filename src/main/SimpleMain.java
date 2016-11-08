package main;

import model.SimpleModel;
import model.swing.SwingAnimatorBuilder;

/**
 * A static class to demonstrate the visualization aspect of
 * simulation.
 * 
 * Running SimpleMain displays 2 parallel roads, one with a car moving slowly. 
 * 
 * PREVIOUS RUN NOTES:
 * - 2 cars moving in opposite directions on roads with following attributes (for both roads):
 * 		random color
 * 		random speed (is speed determined by road length?)
 * 		random destruction upon reaching end of road
 * 
 * CURRENT RUN NOTES:
 * 
 * 
 * 
 */

public class SimpleMain {
	
	private SimpleMain() { }
	
	public static void main(String[] args) {
		
		
		SimpleModel m = new SimpleModel(new SwingAnimatorBuilder());
		
		//run(int duration); run the simulation for duration seconds;
		m.run(500);
		//dispose(); throw away this model; 
		m.dispose();
		System.exit(0);
	}
}

