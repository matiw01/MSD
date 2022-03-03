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
		//number of active neighbors
		int numOfAliveNeigh = this.calculateNeighbours();
		switch (currentState){
			case 0:
				if (numOfAliveNeigh == 3) {
					nextState = 1;
				}
				else {
					nextState = currentState;
				}
				break;
			case 1:
				if (numOfAliveNeigh != 2 && numOfAliveNeigh != 3){
					nextState = 0;
				}
				else {
					nextState = currentState;
				}
				break;
		}
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
