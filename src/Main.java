import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		// int n = 10;
		// Building b = new Building(n);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		for (;;) {
			try {
				System.out.println("Введите вызов вида e5d или i7");
				String str = reader.readLine();
				if (str.equals("")) {
					break;
				}
				if (str.charAt(0) == 'e' && str.length() == 3) {
					int floor = str.charAt(1) - '0';
					int d = str.charAt(2);
					Call call = new Call(
							floor,
							d == 'd' ? ElevatorDirection.ELEVATOR_DIRECTION_DOWN
									: ElevatorDirection.ELEVATOR_DIRECTION_UP);
					elevator.acceptCall(call);
				} else {
					if (str.charAt(0) == 'i' && str.length() == 2) {
						int floor = str.charAt(1) - '0';
						elevator.getButton().call(floor);
					} else {
						break;
					}
				}

			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}
}
