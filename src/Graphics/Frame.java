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
import Ticket.Ticket;
import crud.EventCrud;
import crud.TicketCrud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
		btnTickets.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openTickets();

			}

		});
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

		JLabel lblTickets = new JLabel("Tickets Menu");
		lblTickets.setForeground(Color.WHITE);
		lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTickets.setBounds(345, 45, 110, 15);
		panel.add(lblTickets);
		setLocationRelativeTo(null);

		JButton btnCreateTicket = new JButton("Create Ticket");
		btnCreateTicket.setBackground(Color.ORANGE);
		btnCreateTicket.setBounds(300, 150, 200, 25);
		btnCreateTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openCreateTicket();
			}
		});
		panel.add(btnCreateTicket);

		JButton btnValidateTicket = new JButton("Check Ticket");
		btnValidateTicket.setBackground(Color.ORANGE);
		btnValidateTicket.setBounds(300, 250, 200, 25);
		btnValidateTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openCheckTicket();
			}
		});
		panel.add(btnValidateTicket);

		JButton btnEditTicket = new JButton("Show Tickets");
		btnEditTicket.setBackground(Color.ORANGE);
		btnEditTicket.setBounds(300, 200, 200, 25);
		btnEditTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openShowTicket(0);
			}
		});
		panel.add(btnCreateTicket);
		panel.add(btnEditTicket);

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

	public void openCreateTicket() {
		panel.removeAll();

		EventCrud ec = new EventCrud();
		String[] optionsToChoose = ec.getAllEventName().toArray(new String[0]);

		if (optionsToChoose.length < 1) {
			final JLabel lblCreateTicket = new JLabel("There is no Ticket, you need to create an Event first!");
			lblCreateTicket.setForeground(Color.WHITE);
			lblCreateTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateTicket.setBounds(345, 45, 110, 15);
		} else {

			final JLabel lblCreateTicket = new JLabel("Create Ticket");
			lblCreateTicket.setForeground(Color.WHITE);
			lblCreateTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateTicket.setBounds(345, 45, 110, 15);

			final JLabel lblTicketName = new JLabel("Client Name");
			lblTicketName.setBounds(200, 150, 90, 15);

			final JTextField textFieldTicketName = new JTextField();
			textFieldTicketName.setBounds(310, 150, 300, 15);
			textFieldTicketName.setColumns(10);

			final JLabel lblType = new JLabel("Event");
			lblType.setBounds(200, 180, 90, 15);

			JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);

			final JTextField textFieldType = new JTextField();

			jComboBox.setBounds(310, 180, 300, 20);
			panel.add(lblCreateTicket);
			panel.add(lblTicketName);
			panel.add(textFieldTicketName);
			panel.add(lblType);
			panel.add(jComboBox);

			textFieldType.setBounds(310, 180, 300, 15);
			textFieldType.setColumns(10);

			final JLabel lblTicketPrice = new JLabel("Price");
			lblTicketPrice.setBounds(200, 210, 90, 15);
			panel.add(lblTicketPrice);

			final JTextField textFieldTicketPrice = new JTextField();
			textFieldTicketPrice.setColumns(10);
			textFieldTicketPrice.setBounds(310, 210, 300, 15);
			panel.add(textFieldTicketPrice);

			final JButton btnConfirmCreateTicket = new JButton("Create Ticket");
			btnConfirmCreateTicket.setBackground(Color.ORANGE);
			btnConfirmCreateTicket.setForeground(Color.BLACK);
			btnConfirmCreateTicket.setBounds(450, 490, 150, 25);
			panel.add(btnConfirmCreateTicket);

			btnConfirmCreateTicket.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					{
						TicketCrud tc = new TicketCrud();

						// ev.insertTicket(textFieldTicketName.getText(),
						// textFieldType.getText(), textFieldTicketDate.getText(),
						// );

						EventCrud ec = new EventCrud();
						int idEvent = ec.getEventIdWithName(jComboBox.getSelectedItem().toString());

						System.out.println("----------------------------");

						tc.insertTicket(textFieldTicketName.getText(), idEvent,
								Float.parseFloat(textFieldTicketPrice.getText()));
						textFieldTicketName.setText("");

						textFieldType.setText("");
						textFieldTicketPrice.setText("");

						System.out.println("Ticket inserted");

					}

				}

			});
		}

		JButton btnCancelCreateTicket = new JButton("Return");
		btnCancelCreateTicket.setForeground(Color.BLACK);
		btnCancelCreateTicket.setBackground(Color.ORANGE);
		btnCancelCreateTicket.setBounds(200, 490, 150, 25);
		btnCancelCreateTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openTickets();
			}

		});
		panel.add(btnCancelCreateTicket);

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

		JButton btnCancelCreateEvent = new JButton("Return");
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

	public void openCheckTicket() {
		panel.removeAll();

		TicketCrud ec = new TicketCrud();
		ArrayList<Ticket> allTickets = ec.getAllTickets();

		if (allTickets.size() < 1) {
			final JLabel lblCreateTicket = new JLabel("There is no Ticket, you need to create at least one ticket!");
			lblCreateTicket.setForeground(Color.WHITE);
			lblCreateTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateTicket.setBounds(345, 45, 110, 15);
			panel.add(lblCreateTicket);
		} else {

			final JLabel lblValidateTicket = new JLabel("Check Ticket");
			lblValidateTicket.setForeground(Color.WHITE);
			lblValidateTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lblValidateTicket.setBounds(345, 45, 110, 15);

			final JLabel lblTicketId = new JLabel("TicketId");
			lblTicketId.setBounds(200, 153, 90, 15);

			final JTextField textFieldTicketId = new JTextField();
			textFieldTicketId.setBounds(260, 150, 300, 25);
			textFieldTicketId.setColumns(10);

			panel.add(lblTicketId);
			panel.add(lblValidateTicket);
			panel.add(textFieldTicketId);

			final JButton btnConfirmValidateTicket = new JButton("Validate");
			btnConfirmValidateTicket.setBackground(Color.ORANGE);
			btnConfirmValidateTicket.setForeground(Color.BLACK);
			btnConfirmValidateTicket.setBounds(330, 200, 150, 25);
			panel.add(btnConfirmValidateTicket);

			final JLabel answer = new JLabel("");
			answer.setForeground(Color.GREEN);
			answer.setHorizontalAlignment(SwingConstants.CENTER);
			answer.setBounds(350, 250, 110, 15);
			panel.add(answer);

			btnConfirmValidateTicket.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					{
						TicketCrud tc = new TicketCrud();
						int result = tc.validateTicketWithId(Integer.parseInt(textFieldTicketId.getText()));
						System.out.println(result);
						switch (result) {
							case -1:
								answer.setText("Uknowed ID");
								answer.setForeground(Color.ORANGE);
								break;
							case 0:
								answer.setText("It is USED!");
								answer.setForeground(Color.RED);
								break;

							case 1:
								answer.setText("Verified!");
								answer.setForeground(Color.GREEN);
								break;
						}

						// ev.insertTicket(textFieldTicketName.getText(),
						// textFieldType.getText(), textFieldTicketDate.getText(),
						// );

						lblTicketId.setText("");

					}

				}

			});
		}

		JButton btnCancelCreateTicket = new JButton("Return");
		btnCancelCreateTicket.setForeground(Color.BLACK);
		btnCancelCreateTicket.setBackground(Color.ORANGE);
		btnCancelCreateTicket.setBounds(330, 490, 150, 25);
		btnCancelCreateTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openTickets();
			}

		});
		panel.add(btnCancelCreateTicket);

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

		/*JPanel list = new JPanel();
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
			k++;*/
			
			
			
			JPanel list = new JPanel();
			GridBagLayout listgbl = new GridBagLayout();
			list.setLayout(listgbl);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx=0;
			gbc.gridy=0;
			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.gridx=1;
			gbc1.gridy=0;
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridx=2;
			gbc2.gridy=0;
			GridBagConstraints gbc3 = new GridBagConstraints();
			gbc3.gridx=3;
			gbc3.gridy=0;
			GridBagConstraints gbc4 = new GridBagConstraints();
			gbc4.gridx=4;
			gbc4.gridy=0;
			GridBagConstraints gbc5 = new GridBagConstraints();
			gbc5.gridx=5;
			gbc5.gridy=0;
			GridBagConstraints gbc6 = new GridBagConstraints();
			gbc5.gridx=6;
			gbc5.gridy=0;
			
			
			
			GridBagConstraints listgbc = new GridBagConstraints();
			listgbc.gridy=1;
			listgbc.gridx=0;
			
			GridBagConstraints listheadergbc = new GridBagConstraints();
			listheadergbc.gridy=0;
			listheadergbc.gridx=0;
			
			JPanel header = new JPanel();
			Dimension hdimension = new Dimension(114, 30);
			Dimension hddimension = new Dimension(132, 30);
			GridBagLayout headergbl = new GridBagLayout();
			header.setLayout(headergbl);
			
			JLabel headerID = new JLabel();
			headerID.setPreferredSize(hdimension);
			headerID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(headerID, gbc);
			headerID.setText("Ticket ID");

			JLabel labelClientName = new JLabel();
			labelClientName.setPreferredSize(hdimension);
			labelClientName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelClientName,gbc1);
			labelClientName.setText("event");
			
			JLabel labelEventName = new JLabel();
			labelEventName.setPreferredSize(hdimension);
			labelEventName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelEventName,gbc2);
			labelEventName.setText("showroom");

			JLabel labelPrice = new JLabel();
			labelPrice.setPreferredSize(hdimension);
			labelPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelPrice,gbc3);
			labelPrice.setText("Date");
			
			JLabel labelStatus = new JLabel();
			labelStatus.setPreferredSize(hddimension);
			labelStatus.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelStatus,gbc4);
			labelStatus.setText("description");
			
			JLabel labelDelete = new JLabel();
			labelDelete.setPreferredSize(hdimension);
			labelDelete.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelDelete,gbc5);
			labelDelete.setText("Delete");
			
			JLabel labelUpdate = new JLabel();
			labelUpdate.setPreferredSize(hdimension);
			labelUpdate.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			header.add(labelUpdate,gbc6);
			labelUpdate.setText("update");
			
			list.add(header,listheadergbc);
			
			int k = index * 10;
			Boolean a = false;
			while (k < events.size() && k < (index + 1) * 10) {
				JPanel line = new JPanel();
				Dimension dimension = new Dimension(114, 30);
				GridBagLayout gbl = new GridBagLayout();
				line.setLayout(gbl);
				
				Evenement i = events.get(k);
				JLabel lableID = new JLabel();
				lableID.setPreferredSize(dimension);
				lableID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				line.add(lableID,gbc);
				lableID.setText(i.getId() + "");
	
				JTextField textFieldEventName = new JTextField();
				textFieldEventName.setPreferredSize(dimension);
				textFieldEventName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				line.add(textFieldEventName);
				textFieldEventName.setText(i.getNom());
	
				JTextField textFieldType = new JTextField();
				textFieldType.setPreferredSize(dimension);
				textFieldType.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				line.add(textFieldType,gbc1);
				textFieldType.setText(i.getType());
	
				JTextField textFieldSalle = new JTextField();
				textFieldSalle.setPreferredSize(dimension);
				textFieldSalle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				line.add(textFieldSalle,gbc2);
				textFieldSalle.setText(i.getSalle() + "");
	
				JTextField textFieldDate = new JTextField();
				textFieldDate.setPreferredSize(dimension);
				textFieldDate.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				line.add(textFieldDate,gbc3);
				textFieldDate.setText(i.getDate());
	
				JEditorPane editorPaneEventDescription = new JEditorPane();
				editorPaneEventDescription.setPreferredSize(dimension);
				editorPaneEventDescription.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
				editorPaneEventDescription.setText(i.getDescription());
				JScrollPane scrollPane = new JScrollPane(editorPaneEventDescription,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setPreferredSize(dimension);
				line.add(scrollPane,gbc4);
	
				JButton delete = new JButton("Delete");
				delete.setPreferredSize(dimension);
				delete.setBackground(Color.RED);
				delete.addActionListener(new ActionListener() {
	
					public void actionPerformed(ActionEvent arg0) {
						if (JOptionPane.showConfirmDialog(p, "Are you sure ?", "DELETE",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							ev.deleteEvent(i.getId());
							openEditEvent(index);
						}
					}
	
				});
				line.add(delete,gbc5);
				
				JButton update = new JButton("Update");
				update.setPreferredSize(dimension);
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
				line.add(update,gbc6);
				
				
				System.out.println("ouside if"+listgbc.gridy);
				list.add(line,listgbc);
				listgbc.gridy+=1;
				System.out.println("outside if after"+listgbc.gridy);
				k++;

		}

		JScrollPane jsp = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		p.add(jsp);
		panel.add(p);

		panel.repaint();
		setVisible(true);

	}
	public void openShowTicket(int index) {
		panel.removeAll();

		TicketCrud tc = new TicketCrud();
		ArrayList<Ticket> tickets = tc.getAllTickets();

		JLabel lblEdit = new JLabel("Ticket List");
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
				openTickets();
			}

		});
		panel.add(btnReturn);

		JButton previous = new JButton("<--");
		previous.setBackground(Color.GREEN);
		previous.setForeground(Color.BLACK);
		previous.setBounds(200, 520, 100, 25);
		previous.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openShowTicket(index - 1);
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
				openShowTicket(index + 1);
			}

		});
		panel.add(next);
		if ((index + 1) * 10 >= tickets.size())
			next.setEnabled(false);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBounds(5, 100, 790, 400);

		JPanel list = new JPanel();
		GridBagLayout listgbl = new GridBagLayout();
		list.setLayout(listgbl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx=1;
		gbc1.gridy=0;
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx=2;
		gbc2.gridy=0;
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx=3;
		gbc3.gridy=0;
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx=4;
		gbc4.gridy=0;
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx=5;
		gbc5.gridy=0;
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc5.gridx=6;
		gbc5.gridy=0;
		
		GridBagConstraints listgbc = new GridBagConstraints();
		listgbc.gridy=1;
		listgbc.gridx=0;
		
		GridBagConstraints listheadergbc = new GridBagConstraints();
		listheadergbc.gridy=0;
		listheadergbc.gridx=0;
		
		JPanel header = new JPanel();
		Dimension hdimension = new Dimension(114, 30);
		GridBagLayout headergbl = new GridBagLayout();
		header.setLayout(headergbl);
		
		JLabel headerID = new JLabel();
		headerID.setPreferredSize(hdimension);
		headerID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(headerID, gbc);
		headerID.setText("Ticket ID");

		JLabel labelClientName = new JLabel();
		labelClientName.setPreferredSize(hdimension);
		labelClientName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelClientName,gbc1);
		labelClientName.setText("Guest Name");
		
		JLabel labelEventName = new JLabel();
		labelEventName.setPreferredSize(hdimension);
		labelEventName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelEventName,gbc2);
		labelEventName.setText("event");

		JLabel labelPrice = new JLabel();
		labelPrice.setPreferredSize(hdimension);
		labelPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelPrice,gbc3);
		labelPrice.setText("price");
		
		JLabel labelStatus = new JLabel();
		labelStatus.setPreferredSize(hdimension);
		labelStatus.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelStatus,gbc4);
		labelStatus.setText("Status");
		
		JLabel labelDelete = new JLabel();
		labelDelete.setPreferredSize(hdimension);
		labelDelete.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelDelete,gbc5);
		labelDelete.setText("Delete");
		
		JLabel labelUpdate = new JLabel();
		labelUpdate.setPreferredSize(hdimension);
		labelUpdate.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		header.add(labelUpdate,gbc6);
		labelUpdate.setText("Delete");
		
		list.add(header,listheadergbc);
		
		
		int k = index * 10;
		while (k < tickets.size() && k < (index + 1) * 10) {
			JPanel line = new JPanel();
			Dimension dimension = new Dimension(114, 30);
			GridBagLayout gbl = new GridBagLayout();
			line.setLayout(gbl);
			
			Ticket i = tickets.get(k);
			
			JLabel lableID = new JLabel();
			lableID.setPreferredSize(dimension);
			lableID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			line.add(lableID, gbc);
			lableID.setText(String.valueOf(i.getId()));

			JTextField textFieldClientName = new JTextField();
			textFieldClientName.setPreferredSize(dimension);
			textFieldClientName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			line.add(textFieldClientName,gbc1);
			textFieldClientName.setText(i.getClient());

			EventCrud ec = new EventCrud();
			String[] optionsToChoose = ec.getAllEventName().toArray(new String[0]);
			JComboBox<String> eventscomboBox = new JComboBox<>(optionsToChoose);
			eventscomboBox.setPreferredSize(dimension);
			eventscomboBox.setBackground(Color.WHITE);
			eventscomboBox.setSelectedItem(tc.getEventNamebyId(i.getidEvenement()));
			line.add(eventscomboBox,gbc2);

			JTextField textFieldPrice = new JTextField();
			textFieldPrice.setPreferredSize(dimension);
			textFieldPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			line.add(textFieldPrice,gbc3);
			textFieldPrice.setText(i.getPrix() + " DT");
			
			JTextField textFieldStatus = new JTextField();
			textFieldStatus.setEditable(false);;
			textFieldStatus.setForeground(Color.BLACK);
			textFieldStatus.setBackground(Color.WHITE);
			textFieldStatus.setPreferredSize(dimension);
			textFieldStatus.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			line.add(textFieldStatus,gbc4);
			textFieldStatus.setText((i.getEtat())? "checked":"not checked");

			
			JButton delete = new JButton("Delete");
			delete.setBackground(Color.RED);
			delete.setForeground(Color.WHITE);
			delete.setPreferredSize(dimension);
			delete.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(p, "Are you sure ?", "DELETE",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						tc.deleteTicket(i.getId());
						openShowTicket(index);
					}
				}

			});
			line.add(delete,gbc5);
			
			JButton update = new JButton("Update");
			update.setBackground(Color.BLUE);
			update.setForeground(Color.WHITE);
			update.setPreferredSize(dimension);
			update.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(p, "Are you sure ?", "UPDATE",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						tc.UpdateTicket(i.getId(), textFieldClientName.getText(), ec.getEventIdWithName(eventscomboBox.getSelectedItem().toString()),Float.parseFloat(textFieldPrice.getText().replace(" DT", "")));
						openShowTicket(index);
					}
				}

			});
			line.add(update,gbc6);
			
			
			System.out.println("ouside if"+listgbc.gridy);
			list.add(line,listgbc);
			listgbc.gridy+=1;
			System.out.println("outside if after"+listgbc.gridy);
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
