package ge.edu.freeuni.sdp.snake.model;

import java.util.ArrayList;
import java.util.List;

public class Universe {

	private List<Being> _population;
	private Topology _topology;

	public Universe(Topology topology) {
		this(topology, new ArrayList<Being>());
	}
        
        public Universe(Topology topology, List<Being> population) {
		_population = population;
		_topology = topology;
	}

	public void move() {
		for (int i = 0; i < _population.size(); i++) {
			Being current = _population.get(i);
			current.move(_topology);
		}
	}

	/*
	 * Let population of universe interact with each other. During interaction
	 * one being may kill another or eat and grow. What to do during interaction
	 * is implemented in concrete beings method .interactWith()
	 */
	public void interact() {

		for (int i = 0; i < _population.size(); i++) {
			Being current = _population.get(i);
			for (int j = 0; j < _population.size(); j++) {
				Being other = _population.get(j);

				Point head = current.getHead();
				// Skip if its own head, but don't skip own ass
				if (current == other && head == other.getHead())
					continue;
				if (other.contains(head)) {
					current.interactWith(other);
				}
			}
		}
	}

	/**
	 * Iterates population and remove those beings which have .isAlive()==false
	 * Note: list changes it size when elements are removed.
	 */
	public void removeZombies() {
		for (int i = _population.size() - 1; i >= 0; i--) {
			if (!_population.get(i).isAlive()) {
				_population.remove(i);
			}
		}
	}

	/**
	 * Iterates population, asks every being .contains(point), returns the one
	 * which responds with true.
	 * 
	 * @param point
	 * @return
	 */
	public Being getBeingAt(Point point) {
		for (int i = 0; i < _population.size(); i++) {
			Being current = _population.get(i);
			if (current.contains(point)) {
				return current;
			}
		}
		return null;
	}

	public void addBeing(Being being) {
		_population.add(being);
	}
}