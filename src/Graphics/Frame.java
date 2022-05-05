package Graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import GestionEvenement.Evenement;
import crud.EventCrud;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public Frame() {
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		openMainMenu();

		setResizable(false);

		//

	}

	public void openMainMenu() {
		panel.removeAll();
		JLabel title = new JLabel("Events manager");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);

		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setForeground(Color.WHITE);
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(345, 45, 110, 15);
		panel.add(lblMainMenu);
		setLocationRelativeTo(null);

		JButton btnEvents = new JButton("Events");
		btnEvents.setBackground(Color.ORANGE);
		btnEvents.setBounds(300, 150, 200, 25);
		panel.add(btnEvents);
		btnEvents.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}
		});

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setBackground(Color.ORANGE);
		btnTickets.setBounds(300, 200, 200, 25);
		panel.add(btnTickets);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.ORANGE);
		btnQuit.setBounds(300, 250, 200, 25);
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

		JLabel lblEvents = new JLabel("Events Menu");
		lblEvents.setForeground(Color.WHITE);
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(345, 45, 110, 15);
		panel.add(lblEvents);
		setLocationRelativeTo(null);

		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.setBackground(Color.ORANGE);
		btnCreateEvent.setBounds(300, 150, 200, 25);
		btnCreateEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openCreateEvent();
			}
		});
		panel.add(btnCreateEvent);

		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.setBackground(Color.ORANGE);
		btnEditEvent.setBounds(300, 200, 200, 25);
		btnEditEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEditEvent(0);
			}
		});
		panel.add(btnCreateEvent);
		panel.add(btnEditEvent);

		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setBounds(300, 300, 200, 25);
		btnReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openMainMenu();
			}
		});
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
		lblEvents.setBounds(345, 45, 110, 15);
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

		final JLabel lblCreateEvent = new JLabel("Create Event");
		lblCreateEvent.setForeground(Color.WHITE);
		lblCreateEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateEvent.setBounds(345, 45, 110, 15);
		panel.add(lblCreateEvent);

		final JLabel lblEventName = new JLabel("Name");
		lblEventName.setBounds(200, 150, 90, 15);
		panel.add(lblEventName);

		final JTextField textFieldEventName = new JTextField();
		;
		textFieldEventName.setBounds(310, 150, 300, 15);
		panel.add(textFieldEventName);
		textFieldEventName.setColumns(10);

		final JLabel lblType = new JLabel("Type");
		lblType.setBounds(200, 180, 90, 15);
		panel.add(lblType);

		final JTextField textFieldType = new JTextField();
		;
		textFieldType.setBounds(310, 180, 300, 15);
		panel.add(textFieldType);
		textFieldType.setColumns(10);

		final JLabel lblEventDate = new JLabel("Date");
		lblEventDate.setBounds(200, 210, 90, 15);
		panel.add(lblEventDate);

		final JTextField textFieldEventDate = new JTextField();
		textFieldEventDate.setColumns(10);
		textFieldEventDate.setBounds(310, 210, 300, 15);
		panel.add(textFieldEventDate);

		final JLabel lblroom = new JLabel("room");
		lblroom.setBounds(200, 240, 90, 15);
		panel.add(lblroom);

		final JTextField textFieldroom = new JTextField();
		;
		textFieldroom.setBounds(310, 240, 300, 15);
		panel.add(textFieldroom);
		textFieldroom.setColumns(10);

		final JLabel lblEventDescription = new JLabel("Description");
		lblEventDescription.setBounds(200, 270, 90, 15);
		panel.add(lblEventDescription);

		final JEditorPane editorPaneEventDescription = new JEditorPane();
		editorPaneEventDescription.setBounds(310, 270, 300, 100);
		panel.add(editorPaneEventDescription);

		final JButton btnConfirmCreateEvent = new JButton("Create Event");
		btnConfirmCreateEvent.setBackground(Color.ORANGE);
		btnConfirmCreateEvent.setForeground(Color.BLACK);
		btnConfirmCreateEvent.setBounds(450, 490, 150, 25);
		panel.add(btnConfirmCreateEvent);

		btnConfirmCreateEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(panel, "Are you sure ?", "CREATE",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					EventCrud ev = new EventCrud();
					ev.insertEvent(textFieldEventName.getText(), Integer.parseInt(textFieldroom.getText()),
							textFieldType.getText(), textFieldEventDate.getText(),
							editorPaneEventDescription.getText());
					textFieldEventName.setText("");
					textFieldroom.setText("");
					textFieldType.setText("");
					textFieldEventDate.setText("");
					editorPaneEventDescription.setText("");
				}
				
				
			}

		});

		JButton btnCancelCreateEvent = new JButton("Cancel");
		btnCancelCreateEvent.setForeground(Color.BLACK);
		btnCancelCreateEvent.setBackground(Color.ORANGE);
		btnCancelCreateEvent.setBounds(200, 490, 150, 25);
		btnCancelCreateEvent.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openEvents();
			}

		});
		panel.add(btnCancelCreateEvent);

		panel.repaint();
	}

	public void openEditEvent(int index) {
		panel.removeAll();

		EventCrud ev = new EventCrud();
		ArrayList<Evenement> events = ev.listEvent();

		JLabel lblEdit = new JLabel("Edit events");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setBounds(345, 45, 110, 15);
		panel.add(lblEdit);

		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setBounds(345, 520, 110, 25);
		btnReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openEvents();
			}

		});
		panel.add(btnReturn);

		JButton previous = new JButton("<--");
		previous.setBackground(Color.GREEN);
		previous.setForeground(Color.BLACK);
		previous.setBounds(200, 520, 100, 25);
		previous.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openEditEvent(index - 1);
			}

		});
		panel.add(previous);
		if (index < 1)
			previous.setEnabled(false);

		JButton next = new JButton("-->");
		next.setBackground(Color.GREEN);
		next.setForeground(Color.BLACK);
		next.setBounds(500, 520, 100, 25);
		next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openEditEvent(index + 1);
			}

		});
		panel.add(next);
		if ((index + 1) * 10 >= events.size())
			next.setEnabled(false);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBounds(5, 100, 790, 400);

		JPanel list = new JPanel();
		list.setLayout(new GridLayout(0, 8));

		int k = index * 10;
		while (k < events.size() && k < (index + 1) * 10) {

			Evenement i = events.get(k);
			JLabel lableID = new JLabel();
			lableID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			list.add(lableID);
			lableID.setText(i.getId() + "");

			JTextField textFieldEventName = new JTextField();
			textFieldEventName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			list.add(textFieldEventName);
			textFieldEventName.setText(i.getNom());

			JTextField textFieldType = new JTextField();
			textFieldType.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			list.add(textFieldType);
			textFieldType.setText(i.getType());

			JTextField textFieldSalle = new JTextField();
			textFieldSalle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			list.add(textFieldSalle);
			textFieldSalle.setText(i.getSalle() + "");

			JTextField textFieldDate = new JTextField();
			textFieldDate.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			list.add(textFieldDate);
			textFieldDate.setText(i.getDate());

			JEditorPane editorPaneEventDescription = new JEditorPane();
			editorPaneEventDescription.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
			editorPaneEventDescription.setText(i.getDescription());
			JScrollPane scrollPane = new JScrollPane(editorPaneEventDescription,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			list.add(scrollPane);

			JButton delete = new JButton("Delete");
			delete.setBackground(Color.RED);
			JButton update = new JButton("Update");
			update.setBackground(Color.BLUE);
			update.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(p, "Are you sure ?", "UPDATE",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ev.UpdateEvent(i.getId(), textFieldEventName.getText(), editorPaneEventDescription.getText(),
								Integer.parseInt(textFieldSalle.getText()), textFieldType.getText(),
								textFieldDate.getText());
						openEditEvent(index);
					}
				}

			});

			list.add(delete);
			delete.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(p, "Are you sure ?", "DELETE",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ev.deleteEvent(i.getId());
						openEditEvent(index);
					}
				}

			});

			list.add(update);
			k++;

		}

		JScrollPane jsp = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		p.add(jsp);
		panel.add(p);

		panel.repaint();
		setVisible(true);

	}

}
