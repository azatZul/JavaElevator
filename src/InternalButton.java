public class InternalButton {

	private final Elevator elevator;

	public InternalButton(Elevator elevator) {
		this.elevator = elevator;
	}

	public void call(int floorNumber) {
		elevator.goToFloor(new Call(floorNumber,
				ElevatorDirection.ELEVATOR_DIRECTION_UNDEFINED));
	}

}
