package Graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class exec {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel jp = new JPanel();
		ticketsPannel tp =  new ticketsPannel();
		JButton tickets = new JButton("tickets");
		JButton events = new JButton("events");
		
		//jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		Dimension maxSize = new Dimension(50, 50);
		tickets.setSize(maxSize);
		events.setSize(maxSize);

		jp.setLayout(new GridLayout(2,1));
		
		jp.add(tickets);
		//jp.add(jl);
		jp.add(events);
		frame.add(jp);
		
		frame.setSize(1000, 700);
		frame.setVisible(true);
		
		tickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked");
				frame.remove(jp);
				frame.add(tp);
				frame.revalidate();
				frame.repaint();
				
			}
		});
		/*events.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jl.setText(""+(Integer.parseInt(jl.getText())+1));
			}
		});*/
	}

}
