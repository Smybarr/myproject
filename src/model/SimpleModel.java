package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import util.Animator;

/**
 * An example to model for a simple visualization.
 * The model contains two roads.
 * See {@link #SimpleModel(AnimatorBuilder)}.
 */
public class SimpleModel extends Observable {
	private List<Agent> agents;
	private Animator animator;
	private boolean disposed;
	private double time;

	/** Creates a model to be visualized using the <code>builder</code>.
	 *  If the builder is null, no visualization is performed.
	 *  Each road has one {@link Car}.
	 *
	 */
	public SimpleModel(AnimatorBuilder builder) {
		if (builder == null) {
			builder = new NullAnimatorBuilder();
		}
		agents = new ArrayList<Agent>();
		//setup is where objects in the model are created
		setup(builder);
		animator = builder.getAnimator();
		super.addObserver(animator);
	}

	/**
	 * Run the simulation for <code>duration</code> model seconds.
	 */
	public void run(int duration) {
		if (disposed)
			throw new IllegalStateException();
		for (int i=0; i<duration; i++) {
			time++;
			Agent[] agents_copy = agents.toArray(new Agent[0]);
			for (Agent a : agents_copy) {
				a.run(time);
			}
			super.setChanged();
			super.notifyObservers();
		}
	}

	/**
	 * Throw away this model.
	 */
	public void dispose() {
		animator.dispose();
		disposed = true;
	}

	//Added a 2nd Car object (c2) and ran r2.accept(c2) to place it on the road;
	private void setup(AnimatorBuilder builder) {
		//beginning to experiment with additional functionality;	
		Road r1 = new Road();
		Road r2 = new Road();
		Light l1 = new Light();
		builder.addHorizontalRoad(r1, 0, 1, false);
		//plan on adding various components found in Model but not currently in SimpleModel
		builder.addVerticalRoad(r2, 1, 0, false);
		//add a light 
		builder.addLight(l1, 1, 1);
		Car c1 = new Car();
		r1.accept(c1);
		agents.add(c1);
		
		Road r3 = new Road();
		builder.addHorizontalRoad(r2, 1, 1, false);
		Car c2 = new Car();
		r2.accept(c2);
		agents.add(c2);

		
		// Road oldroad = null;
		// for (int j = 0; j <= columns; j++) {
		//   Road newroad = new Road();
		//   builder.addHorizontalRoad(newroad, 0, (eastToWest? columns-j : j), eastToWest);
		//   newroad.setNext(oldroad);
		//   oldroad = newroad;
		// }
	}
}
