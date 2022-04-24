package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class Frame extends JFrame {

	private JPanel panel;

	public Frame() {
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		openMainMenu();
		
		
		//
		
	}
	
	public void openMainMenu() {
		panel.removeAll();
		JLabel title = new JLabel("Events manager");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(247, 47, 112, 15);
		panel.add(lblMainMenu);
		setLocationRelativeTo(null);
		
		JButton btnEvents = new JButton("Events");
		btnEvents.setBackground(Color.ORANGE);
		btnEvents.setBounds(207, 146, 190, 25);
		panel.add(btnEvents);
		btnEvents.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}});
		
		JButton btnTickets = new JButton("Tickets");
		btnTickets.setBackground(Color.ORANGE);
		btnTickets.setBounds(207, 202, 190, 25);
		panel.add(btnTickets);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.ORANGE);
		btnQuit.setBounds(207, 259, 190, 25);
		btnQuit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		panel.add(btnQuit);
		panel.repaint();
	}
	
	public void openEvents() {
		panel.removeAll();
		
		
		JLabel title = new JLabel("Events");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblEvents = new JLabel("Events Menu");
		lblEvents.setForeground(Color.WHITE);
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(247, 47, 112, 15);
		panel.add(lblEvents);
		setLocationRelativeTo(null);
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.setBackground(Color.ORANGE);
		btnCreateEvent.setBounds(207, 146, 190, 25);
		btnCreateEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openCreateEvent();
			}});
		panel.add(btnCreateEvent);
		
		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.setBackground(Color.ORANGE);
		btnEditEvent.setBounds(207, 202, 190, 25);
		btnEditEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openCreateEvent();
			}});
		panel.add(btnCreateEvent);
		panel.add(btnEditEvent);
		
		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setBackground(Color.ORANGE);
		btnDeleteEvent.setBounds(207, 259, 190, 25);
		btnDeleteEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openDeleteEvent();
			}});
		panel.add(btnDeleteEvent);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setBounds(207, 316, 190, 25);
		btnReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openMainMenu();
			}});
		panel.add(btnReturn);
		
		panel.repaint();
		
	}
	
	public void openTickets() {
		panel.removeAll();
		
		JLabel title = new JLabel("Events");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblEvents = new JLabel("Events Menu");
		lblEvents.setForeground(Color.WHITE);
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(247, 47, 112, 15);
		panel.add(lblEvents);
		setLocationRelativeTo(null);
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.setBackground(Color.ORANGE);
		btnCreateEvent.setBounds(207, 146, 190, 25);
		panel.add(btnCreateEvent);
		
		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.setBackground(Color.ORANGE);
		btnEditEvent.setBounds(207, 202, 190, 25);
		panel.add(btnEditEvent);
		
		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setBackground(Color.ORANGE);
		btnDeleteEvent.setBounds(207, 259, 190, 25);
		panel.add(btnDeleteEvent);
		
		panel.repaint();
		
	}
	
	public void openCreateEvent() {
		panel.removeAll();
		
		JLabel title = new JLabel("Events manager");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setForeground(Color.WHITE);
		lblCreateEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateEvent.setBounds(247, 47, 113, 15);
		panel.add(lblCreateEvent);
		
		JLabel lblEventName = new JLabel("Name");
		lblEventName.setBounds(93, 101, 70, 15);
		panel.add(lblEventName);
		
		JTextField textFieldEventName = new JTextField();;
		textFieldEventName = new JTextField();
		textFieldEventName.setBounds(210, 99, 244, 19);
		panel.add(textFieldEventName);
		textFieldEventName.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(93, 127, 70, 15);
		panel.add(lblType);
		
		JTextField textFieldType = new JTextField();;
		textFieldType = new JTextField();
		textFieldType.setBounds(210, 125, 244, 19);
		panel.add(textFieldType);
		textFieldType.setColumns(10);

		JLabel lblEventDate = new JLabel("Date");
		lblEventDate.setBounds(93, 152, 70, 15);
		panel.add(lblEventDate);
		
		JTextField textFieldEventDate = new JTextField();
		textFieldEventDate.setColumns(10);
		textFieldEventDate.setBounds(210, 150, 244, 19);
		panel.add(textFieldEventDate);

		JLabel lblroom = new JLabel("room");
		lblroom.setBounds(93, 182, 70, 15);
		panel.add(lblroom);
		
		JTextField textFieldroom = new JTextField();;
		textFieldroom = new JTextField();
		textFieldroom.setBounds(210, 179, 244, 19);
		panel.add(textFieldroom);
		textFieldroom.setColumns(10);
		
		JLabel lblEventDescription = new JLabel("Description");
		lblEventDescription.setBounds(93, 212, 94, 15);
		panel.add(lblEventDescription);
		
		JEditorPane editorPaneEventDescription = new JEditorPane();
		editorPaneEventDescription.setBounds(210, 208, 244, 124);
		panel.add(editorPaneEventDescription);
		
		JButton btnConfirmCreateEvent = new JButton("Create Event");
		btnConfirmCreateEvent.setBackground(Color.ORANGE);
		btnConfirmCreateEvent.setForeground(Color.BLACK);
		btnConfirmCreateEvent.setBounds(419, 489, 144, 25);
		panel.add(btnConfirmCreateEvent);
		
		
		btnConfirmCreateEvent.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				//String x = textFieldEventName.getText();
				String d=textFieldEventDate.getText();
				String description = editorPaneEventDescription.getText();		//lehn� eli bech ycollecti les donn�es
				//insertTicket(x,x,x,x)
				openEvents();
			}
			
		});
		
		JButton btnCancelCreateEvent = new JButton("Cancel");
		btnCancelCreateEvent.setForeground(Color.BLACK);
		btnCancelCreateEvent.setBackground(Color.ORANGE);
		btnCancelCreateEvent.setBounds(257, 489, 144, 25);
		btnCancelCreateEvent.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}
			
		});
		panel.add(btnCancelCreateEvent);
		
		panel.repaint();
	}
	
	
	
	public void openDeleteEvent() {
		panel.removeAll();
		
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
		btnReturn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}
			
		});
		panel.add(btnReturn);
		
		JList list = new JList();
		list.setBounds(202, 88, 200, 255);
		panel.add(list);
		list.add(new JButton("Hazem"));
		
		panel.repaint();
	}
	
	public void openEditEvent() {
		panel.removeAll();
		
		JLabel title = new JLabel("Events manager");
		title.setBounds(5, 5, 590, 15);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		JLabel lblEDitEvent = new JLabel("Edit Event");
		lblEDitEvent.setForeground(Color.WHITE);
		lblEDitEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEDitEvent.setBounds(247, 47, 113, 15);
		panel.add(lblEDitEvent);
		
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setBounds(419, 489, 144, 25);
		btnReturn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}
			
		});
		panel.add(btnReturn);
		
		JList list = new JList();
		list.setBounds(202, 88, 200, 255);
		panel.add(list);
		list.add(new JButton("Hazem"));
		
		panel.repaint();
	}

}
