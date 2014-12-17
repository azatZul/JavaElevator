public interface IElevatorState {
	public void goToCurrentFloor(Call call, Elevator elevator);

	public void changeFloor(Elevator elevator);
}
