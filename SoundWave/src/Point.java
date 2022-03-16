import java.util.Random;

public class Point {

	public static Integer []types ={0,1,2};
	public int sinInput;
	public int type;
	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;


	public Point() {
		clear();
		type = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		nVel = 0;
		eVel = 0;
		sVel = 0;
		wVel = 0;
		pressure = 0;
		type = 0;
	}

	public void updateVelocity() {
		if (type == 0) {
			nVel = nVel - nNeighbor.pressure + pressure;
			eVel = eVel - eNeighbor.pressure + pressure;
			wVel = wVel - wNeighbor.pressure + pressure;
			sVel = sVel - sNeighbor.pressure + pressure;
		}
	}

	public void updatePresure() {
		int random = (int)(Math.random() * 50 + 1);
		sinInput = random;
		if (type == 0)
			pressure = pressure - 0.5f * (nVel + eVel + sVel + wVel);
		if (type == 2) {
			double radians = Math.toRadians(sinInput);
			pressure = (float)(Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}