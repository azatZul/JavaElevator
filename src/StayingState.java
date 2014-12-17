public class StayingState implements IElevatorState {

	@Override
	public void goToCurrentFloor(Call call, Elevator elevator) {
		elevator.setCurrent(new PauseState(this));
	}

	@Override
	public void changeFloor(Elevator elevator) {
		if (!elevator.upQueue.isEmpty() || !elevator.downQueue.isEmpty()) {
			elevator.setCurrent(new PauseState(this));
		}
	}
}
