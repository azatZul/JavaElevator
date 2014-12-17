import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
	Elevator elevator = new Elevator();
	ActionListener internal = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Frame.this.call((JButton) e.getSource(), true, 0);
		}
	};

	public Frame() {

		getContentPane().setLayout(null);

		JButton button = new JButton("1");
		button.setBounds(10, 11, 57, 47);
		getContentPane().add(button);
		button.addActionListener(internal);

		JButton button_1 = new JButton("2");
		button_1.setBounds(77, 11, 57, 47);
		getContentPane().add(button_1);
		button_1.addActionListener(internal);

		JButton button_2 = new JButton("3");
		button_2.setBounds(10, 69, 57, 47);
		getContentPane().add(button_2);
		button_2.addActionListener(internal);

		JButton button_3 = new JButton("4");
		button_3.setBounds(77, 69, 57, 47);
		getContentPane().add(button_3);
		button_3.addActionListener(internal);

		JButton button_4 = new JButton("5");
		button_4.setBounds(37, 127, 57, 47);
		getContentPane().add(button_4);
		button_4.addActionListener(internal);

		JButton btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 1);
			}
		});
		btnU.setBounds(239, 11, 89, 23);
		getContentPane().add(btnU);

		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 1);
			}
		});
		btnD.setBounds(239, 35, 89, 23);
		getContentPane().add(btnD);

		JButton button_6 = new JButton("U");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 2);
			}
		});
		button_6.setBounds(239, 95, 89, 23);
		getContentPane().add(button_6);

		JButton btnD_1 = new JButton("D");
		btnD_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 2);
			}
		});
		btnD_1.setBounds(239, 115, 89, 23);
		getContentPane().add(btnD_1);

		JButton button_8 = new JButton("U");
		button_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 3);
			}
		});

		button_8.setBounds(239, 171, 89, 23);
		getContentPane().add(button_8);

		JButton btnD_2 = new JButton("D");
		btnD_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 3);
			}
		});
		btnD_2.setBounds(239, 194, 89, 23);
		getContentPane().add(btnD_2);

		JButton button_10 = new JButton("U");
		button_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 4);
			}
		});
		button_10.setBounds(239, 251, 89, 23);
		getContentPane().add(button_10);

		JButton btnD_3 = new JButton("D");
		btnD_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 4);
			}
		});
		btnD_3.setBounds(239, 273, 89, 23);
		getContentPane().add(btnD_3);

		JButton button_12 = new JButton("U");
		button_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 5);
			}
		});
		button_12.setBounds(239, 323, 89, 23);
		getContentPane().add(button_12);

		JButton btnD_4 = new JButton("D");
		btnD_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.this.call((JButton) e.getSource(), false, 5);
			}
		});
		btnD_4.setBounds(239, 347, 89, 23);
		getContentPane().add(btnD_4);
	}

	public void call(JButton sender, boolean internal, int floor) {
		if (internal) {
			elevator.getButton().call(Integer.parseInt(sender.getText()));
		} else {
			Call call = new Call(
					floor,
					sender.getText() == "U" ? ElevatorDirection.ELEVATOR_DIRECTION_UP
							: ElevatorDirection.ELEVATOR_DIRECTION_DOWN);
			elevator.acceptCall(call);
		}
	}

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(0, 0, 352, 420);
		frame.setVisible(true);
	}
}
