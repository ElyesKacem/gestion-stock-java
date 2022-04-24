package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JPanel panel;
	private JTextField textFieldEventName;
	private JTextField textFieldEventDate;
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Events manager");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblDeleteEvent = new JLabel("Delete Event");
		lblDeleteEvent.setForeground(Color.WHITE);
		lblDeleteEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEvent.setBounds(247, 47, 113, 15);
		panel.add(lblDeleteEvent);
		
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setBounds(419, 489, 144, 25);
		panel.add(btnReturn);
		
		JScrollPane eventsContainer = new JScrollPane();
		eventsContainer.setBounds(434, 110, -253, 166);
		panel.add(eventsContainer);

		
			}
}
