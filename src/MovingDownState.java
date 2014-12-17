public class MovingDownState implements IElevatorState {
	@Override
	public void changeFloor(Elevator elevator) {
		// ���������� �� ����
		elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
		System.out.println(elevator.getCurrentFloor());
		Call call = elevator.downQueue.peek();
		if (call.getFloor() == elevator.getCurrentFloor()) {
			// ��� ����� �� ���� �����
			if (call.getDirection() == ElevatorDirection.ELEVATOR_DIRECTION_UP) {
				// �� ���� ������ ������ ������, ������������ ����� �� �������
				// ������� � ���������
				elevator.upQueue.add(elevator.downQueue.poll());
			} else {
				// ���� ������ ������ ������� ��� ����
				// ������� �����, ���������������
				elevator.downQueue.poll();
				elevator.setCurrent(new PauseState(this));

			}
		}
	}

	@Override
	public void goToCurrentFloor(Call call, Elevator elevator) {
		// ������, ���������. ����������� �� ������� ����
		elevator.upQueue.add(call);
	}

}
