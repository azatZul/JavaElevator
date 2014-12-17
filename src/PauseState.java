public class PauseState implements IElevatorState {
	private IElevatorState previousState;

	public PauseState(IElevatorState prevState) {
		previousState = prevState;
	}

	@Override
	public void changeFloor(Elevator elevator) {
		if (previousState instanceof MovingDownState) {
			// двигались вниз
			if (elevator.downQueue.isEmpty()) {
				// вниз нам не надо
				if (elevator.upQueue.isEmpty()) {
					// и вверх нам не надо, значит стоим
					elevator.setCurrent(new StayingState());
				} else {
					elevator.setCurrent(new MovingUpState());
				}
			} else {
				// надо вниз, продолжаем двигаться туда же
				elevator.setCurrent(new MovingDownState());
			}
		} else {
			if (previousState instanceof MovingUpState) {
				// двигались вверх
				if (elevator.upQueue.isEmpty()) {
					// вверх не надо
					if (elevator.downQueue.isEmpty()) {
						// и вниз не надо
						elevator.setCurrent(new StayingState());
					} else {
						// нас ждут внизу
						elevator.setCurrent(new MovingDownState());
					}
				} else {
					elevator.setCurrent(new MovingUpState());
				}
			} else {
				if (previousState instanceof MovingUpState) {
					// нажали, когда стояли на паузе
					previousState.changeFloor(elevator);
				} else {
					// перешли со стоянки
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
		// нажата кнопка внутри
		if (call.getDirection() == ElevatorDirection.ELEVATOR_DIRECTION_UNDEFINED) {
			elevator.setCurrent(new PauseState(this));
		}
	}
}
