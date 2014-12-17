public class ExternalButton {
	private final ElevatorDirection direction;
	private final int floorNumber;
	private CallListener callListerner;

	ExternalButton(int floorNumber, ElevatorDirection direction,
			CallListener listener) {
		this.floorNumber = floorNumber;
		this.direction = direction;
		this.callListerner = listener;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void onPress() {
		if (callListerner != null) {
			callListerner.acceptCall(new Call(floorNumber, direction));
		} else {
			System.out.println("Null listener!");
		}
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

	public void addCallListener(CallListener listener) {
		this.callListerner = listener;
	}

	public void removeCallListener(CallListener listener) {
		callListerner = null;
	}
}
