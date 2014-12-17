import java.util.ArrayList;

public class Building {
	private final Elevator elevator;
	private final int floorsColunt;
	private final ArrayList<ExternalButton> callButtons;

	public Building(int floorsCount) {
		elevator = new Elevator();
		this.floorsColunt = floorsCount;
		callButtons = new ArrayList<>();
		for (int i = 0; i < floorsCount; i = i + 2) {
			callButtons.set(i, new ExternalButton(i,
					ElevatorDirection.ELEVATOR_DIRECTION_UP, elevator));
			callButtons.set(i, new ExternalButton(i,
					ElevatorDirection.ELEVATOR_DIRECTION_DOWN, elevator));
		}
	}
}
