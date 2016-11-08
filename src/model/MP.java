package model;

/**
 * Static class for model parameters. 
 * QUESTION: Is this where the defaults should be initialized as constants?
 */
public class MP {
	private MP() { }
	/** Simulation time step (seconds); default=0.1 */
	public static double timeStep = 0.1;
	/** Simulation run time (seconds); default=1000 */
	public static double runTime = 1000;
	/** Grid size (number of roads); default = 2 rows, 3 columns; */
	public static int gridSize = 17;
	/** Traffic Pattern; default = alternating (simple pattern = false); */
	public static boolean simpleTrafficPattern = false;
	/** Car generation delay (seconds/car); default = min 2.0, max 25.0; */
	public static double carGenerationDelay = 11.0;
	/** Intersection length (meters); default = min 10.0, max 15.0; */
	public static double intersectionLength = 10.0;
	/** Car stop distance (meters); default = min 0.5, max 5.0; */
	public static double carStopDistance = 3.0;
	/** Car brake distance (meters); default = min 9.0, max 10.0; */
	public static double carBrakeDistance = 9.5;
	/** Traffic light green time (seconds); default = min 30.0, max 180.0; */
	public static double greenLightTime = 105.0;
	/** Traffic light yellow time (seconds); default = min 4.0, max 5.0 */
	public static double yellowLightTime = 4.5;
	/** Length of cars, in meters; default = min 5.0, max 10.0 */
	public static double carLength = 7.5;
	/** Length of roads, in meters; default = min 200.0, max 500.0; */
	public static double roadLength = 200.0;
	/** Maximum car velocity, in meters/second; default = min 10.0, max 15.0; */
	public static double maxVelocity = 6;
}

