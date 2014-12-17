import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Timer;

enum ElevatorDirection {
	ELEVATOR_DIRECTION_UP, ELEVATOR_DIRECTION_DOWN, ELEVATOR_DIRECTION_UNDEFINED
}

public class Elevator implements CallListener {
	private IElevatorState current;
	private int currentFloor;
	private final InternalButton button = new InternalButton(this);
	private final Timer timer = new Timer();
	protected PriorityQueue<Call> upQueue = new PriorityQueue<>(3,
			new Comparator<Call>() {

				@Override
				public int compare(Call o1, Call o2) {
					if (o1.getFloor() > o2.getFloor()) {
						return 1;
					}
					if (o1.getFloor() < o2.getFloor()) {
						return -1;
					}
					return 0;
				}
			});
	protected PriorityQueue<Call> downQueue = new PriorityQueue<>(3,
			new Comparator<Call>() {

				@Override
				public int compare(Call o1, Call o2) {
					if (o1.getFloor() > o2.getFloor()) {
						return -1;
					}
					if (o2.getFloor() < o2.getFloor()) {
						return 1;
					}

					return 0;
				}
			});

	public Elevator() {
		current = new StayingState();
		setCurrentFloor(1);
		System.out.println(1);
		timer.schedule(new ElevatorTimerTask(this), 2000, 2000);
	}

	public void goToFloor(Call call) {
		if (call.getFloor() > currentFloor) {
			if (!upQueue.contains(call)) {
				upQueue.add(call);
			}
		} else {
			if (call.getFloor() < currentFloor) {
				if (!downQueue.contains(call)) {
					downQueue.add(call);
				}
			} else {
				current.goToCurrentFloor(call, this);
			}
		}
	}

	@Override
	public void acceptCall(Call call) {
		goToFloor(call);
	}

	public IElevatorState getCurrent() {
		return current;
	}

	public void setCurrent(IElevatorState current) {
		System.out.println(current.getClass());
		this.current = current;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public InternalButton getButton() {
		return button;
	}
}
