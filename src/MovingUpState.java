public class MovingUpState implements IElevatorState {

	@Override
	public void changeFloor(Elevator elevator) {
		// ����������� �� ����
		elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
		System.out.println(elevator.getCurrentFloor());
		Call call = elevator.upQueue.peek();
		if (call.getFloor() == elevator.getCurrentFloor()) {
			// ��� ����� �� ���� �����
			if (call.getDirection() == ElevatorDirection.ELEVATOR_DIRECTION_DOWN) {
				// �� ���� ������ ������ ����, ������������ ����� �� ������
				// ������� � ���������
				elevator.downQueue.add(elevator.upQueue.poll());
			} else {
				// ���� ������ ������ ������� ��� ����
				// ������� �����, ���������������
				elevator.upQueue.poll();
				elevator.setCurrent(new PauseState(this));

			}
		}
	}

	@Override
	public void goToCurrentFloor(Call call, Elevator elevator) {
		elevator.downQueue.add(call);
	}

}
