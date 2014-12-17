import java.util.TimerTask;

public class ElevatorTimerTask extends TimerTask {
	private final Elevator elevator;

	ElevatorTimerTask(Elevator elevator) {
		this.elevator = elevator;
	}

	@Override
	public void run() {
		elevator.getCurrent().changeFloor(elevator);
	}

}
