package model;

/**
 * A car remembers its position from the beginning of its road.
 * Cars have random velocity and random movement pattern:
 * when reaching the end of a road, the dot either resets its position
 * to the beginning of the road, or reverses its direction.
 */

public class Car implements Agent {
	Car() { } // Created only by this package
	
//Car behavior depends on distance to the nearest obstacle; 
//3 attributes regulating car behavior (may vary from car to car); 
	//private double maxVelocity (in MP class)
	//private double breakDistance;
	//private double stopDistance;
	
	/**if backAndForth == 1 via Math.random,
	 * then backAndForth = true; else backAndForth = false 
	 * 
	 * backAndForth = true; car is never destroyed! 
	 * 		- Cars originate at source once
	 * 		- Cars bounce off everything (end of roads/lights)
	 * backAndForth = false; all sinks!
	 * 		- Cars continue to originate at original source
	 * 		- Cars sink every time they hit the end of a road (segment?)
	 * 
	 * CARS NEVER NEED TO GO BACK AND FORTH! 
	 * LEAVE AS FALSE OR REMOVE ATTRIBUTE COMPLETELY!
	 * 
	 * */
	
	//car will never need to go back and forth; leave as false for now, remove when refactoring later;
	private boolean backAndForth = false; //Math.round(Math.random()) == 1 ? true : false;
	private double position = 0;
	private double velocity = 3; //(int) Math.ceil(Math.random() * MP.maxVelocity);
	private java.awt.Color color = new java.awt.Color((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));
	
	public double getPosition() {
		return position;
	}

	public java.awt.Color getColor() {
		return color;
	}

	/*is this where we need to place logic for Car to transfer to new road segment 
	 *after light? I want to say no.
	 *
	 *I want to say the best design would be to reset Car position to 0 after reaching end of
	 *road, and adding the code to transfer a copy of the car to the next road segment in roads list
	 *in a different class (single responsibilty principle?)
	 *
	*/
	public void run(double time) {
		if (backAndForth) {
			if (((position + velocity) < 0) || ((position + velocity) > (MP.roadLength-MP.carLength)))
				velocity *= -1;
		} else {
			if ((position + velocity) > (MP.roadLength-MP.carLength))
				//setting position as MP.roadLength - MP.carLength stops car at intersection (light);
				position = MP.roadLength - MP.carLength;
		}

		position += velocity;
	}
}
