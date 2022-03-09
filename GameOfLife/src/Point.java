import java.util.ArrayList;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		if (currentState > 0)
			nextState = currentState - 1;
		if (!neighbors.isEmpty() && neighbors.get(0).currentState == 0)
			neighbors.get(0).nextState = currentState;

	}

	public void drop(){
		if (Math.random() < 0.05)
			nextState = 6;
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	public int calculateNeighbours() {
		int numOfAliveNeigh = 0;
		for (Point neighbour : neighbors){
			if (neighbour.getState() == 1)
				numOfAliveNeigh ++;
		}
		return numOfAliveNeigh;
	}
}
