public class MovingDownState implements IElevatorState {
	@Override
	public void changeFloor(Elevator elevator) {
		// спускаемся на этаж
		elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
		System.out.println(elevator.getCurrentFloor());
		Call call = elevator.downQueue.peek();
		if (call.getFloor() == elevator.getCurrentFloor()) {
			// был вызов на этом этаже
			if (call.getDirection() == ElevatorDirection.ELEVATOR_DIRECTION_UP) {
				// но была нажата кнопка наверх, перекидываем вызов на верхнюю
				// очередь и проезжаем
				elevator.upQueue.add(elevator.downQueue.poll());
			} else {
				// была нажата кнопка изнутри или вниз
				// снимаем вызов, останавливаемся
				elevator.downQueue.poll();
				elevator.setCurrent(new PauseState(this));

			}
		}
	}

	@Override
	public void goToCurrentFloor(Call call, Elevator elevator) {
		// Поздно, проезжаем. Остановимся на обратно пути
		elevator.upQueue.add(call);
	}

}
