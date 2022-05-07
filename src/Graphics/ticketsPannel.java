package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import GestionEvenement.Evenement;
import crud.EventCrud;

public class ticketsPannel extends JPanel {
	public void openEditEvent(int index) {
	}
	public ticketsPannel() {
		int index = 0;
		EventCrud ev = new EventCrud();
		ArrayList<Evenement> events = ev.listEvent();
		
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		
		JLabel lblEdit = new JLabel("Edit events");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setBounds(345, 45, 110, 15);
		header.add(lblEdit,BorderLayout.LINE_START);

		JButton jb = new JButton("add tickets");
		header.add(jb,-1);
		JButton previous = new JButton("<--");
		previous.setBackground(Color.GREEN);
		previous.setForeground(Color.BLACK);
		previous.setBounds(200, 520, 100, 25);
		previous.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				openEditEvent(index - 1);
			}

		});
		add(header);
		
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
						repaint();
					}
				}

			});

			list.add(update);
			k++;

		}
		JScrollPane jsp = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		p.add(jsp);
		add(p);
		add(previous);
		add(next);

		repaint();
	}
}
