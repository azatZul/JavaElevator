public class PauseState implements IElevatorState {
	private IElevatorState previousState;

	public PauseState(IElevatorState prevState) {
		previousState = prevState;
	}

	@Override
	public void changeFloor(Elevator elevator) {
		if (previousState instanceof MovingDownState) {
			// ��������� ����
			if (elevator.downQueue.isEmpty()) {
				// ���� ��� �� ����
				if (elevator.upQueue.isEmpty()) {
					// � ����� ��� �� ����, ������ �����
					elevator.setCurrent(new StayingState());
				} else {
					elevator.setCurrent(new MovingUpState());
				}
			} else {
				// ���� ����, ���������� ��������� ���� ��
				elevator.setCurrent(new MovingDownState());
			}
		} else {
			if (previousState instanceof MovingUpState) {
				// ��������� �����
				if (elevator.upQueue.isEmpty()) {
					// ����� �� ����
					if (elevator.downQueue.isEmpty()) {
						// � ���� �� ����
						elevator.setCurrent(new StayingState());
					} else {
						// ��� ���� �����
						elevator.setCurrent(new MovingDownState());
					}
				} else {
					elevator.setCurrent(new MovingUpState());
				}
			} else {
				if (previousState instanceof MovingUpState) {
					// ������, ����� ������ �� �����
					previousState.changeFloor(elevator);
				} else {
					// ������� �� �������
					if (!elevator.upQueue.isEmpty()) {
						elevator.setCurrent(new MovingUpState());
					} else {
						if (!elevator.downQueue.isEmpty()) {
							elevator.setCurrent(new MovingDownState());
						} else {
							elevator.setCurrent(new StayingState());
						}
					}
				}
			}
		}
	}

	public void setPreviousState(IElevatorState previousState) {
		this.previousState = previousState;
	}

	@Override
	public void goToCurrentFloor(Call call, Elevator elevator) {
		// ������ ������ ������
		if (call.getDirection() == ElevatorDirection.ELEVATOR_DIRECTION_UNDEFINED) {
			elevator.setCurrent(new PauseState(this));
		}
	}
}
