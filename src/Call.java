public class Call implements Comparable<Call> {
	private int floor;
	private ElevatorDirection direction;

	public int getFloor() {
		return floor;
	}

	public Call(int floor, ElevatorDirection direction) {
		this.floor = floor;
		this.direction = direction;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public void setDirection(ElevatorDirection direction) {
		this.direction = direction;
	}

	@Override
	public int compareTo(Call o) {
		if (floor > o.getFloor()) {
			return 1;
		}
		if (floor < o.getFloor()) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Call && ((Call) obj).getFloor() == floor) {
			return true;
		}
		return false;
	}
}
