
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class BreakRoom implements ActionListener {
	public static final int DELAY = 10;
	private static JLabel statusbar;
	
	public static void Create() {
		JFrame frame = new JFrame(); // Creates Main Screen JFrame
		// frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);; //
		// Alows JFrame to
		JPanel panel = new JPanel();
		frame.setSize(1000, 1000); // Sets size of JFrame
		frame.setVisible(true); // Makes it visible
		panel.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Allows JFrame
											// to																	// be exited
		panel.setLayout(null); // Allows the JButtons and JLabels to be moved

		JLabel text = new JLabel("Break Room"); // Displays text Maze
												// Runner
		text.setBounds(410, 120, 450, 29); // Sets boundaries of the Text
		text.setFont(new Font("Serif", Font.PLAIN, 30));
		text.setForeground(Color.blue);
		// frame.add(text);
		frame.getContentPane().add(text);

		// panel.add(text);
		text.setVisible(true);

		JButton BShip = new JButton(" Battleship "); // New Button for Random
		BShip.setVisible(true); // Play
		BShip.setBounds(490, 200, 450, 90); // Sets boundaries of the Buttons
		BShip.setForeground(Color.BLACK);
		BShip.addActionListener(new ActionListener() { // Allows Button Rando to
														// be pressed

			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
				BattleShip r = new BattleShip();
				if (e.getActionCommand().equals(" Battleship ")) {
					r.doThis();
					r.setup();
					r.draw();

				}
			}
		});
		panel.add(BShip);

		JButton HighwayRacer = new JButton(" Highway Racer "); // New Button for
																// Random
		HighwayRacer.setVisible(true); // Play
		HighwayRacer.setBounds(40, 200, 450, 90); // Sets boundaries of the
													// Buttons
		HighwayRacer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) // Checks Rando to see if
														// it is pressed
			{
					Highway_Racer_pde s = new Highway_Racer_pde();
					System.out.println("========");
					if(e.getActionCommand().equals(" Highway Racer ")){
					s.start(true);
					s.setup();
					s.draw();
					}
			}
		});
		panel.add(HighwayRacer);

		JMenuBar menubar = new JMenuBar(); //Menubar
		 JMenu Open = new JMenu("Open");
		 Open.setMnemonic(KeyEvent.VK_F);
		 JMenu view = new JMenu("View");
		 view.setMnemonic(KeyEvent.VK_V);
		 JCheckBoxMenuItem sbar = new JCheckBoxMenuItem("Show StatuBar");
		 sbar.setState(true);
		 sbar.addActionListener(new ActionListener() {
		 @Override
		public void actionPerformed(ActionEvent event) {
			 if (statusbar.isVisible()) {
		 statusbar.setVisible(false);
		 } else {
		 statusbar.setVisible(true);
		 }
		 }
		 });

		 
		 
		 
		 JMenuItem CalendarButton = new JMenuItem("Calendar");
		 CalendarButton.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println("hi");
	       	  SwingCalendar g = new SwingCalendar();
	       	  g.updateMonth();
	       	  //g.main(args);
			 }
			 });
		 Open.add(CalendarButton);
		 
		 JMenuItem AlarmButton = new JMenuItem("Alarm");
		 AlarmButton.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				  	AlarmClock zBo = new AlarmClock();
				  	zBo.init();
			 }
			 });
		 Open.add(AlarmButton);
		 
		 JMenuItem NotePadButton = new JMenuItem("Note Pad");
		 NotePadButton.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			       NotePad yo = new NotePad();
			        yo.setVisible(true);
			 }
			 });
		 Open.add(NotePadButton);

	     
		 JMenuItem CalculatorButton = new JMenuItem("Calculator");
		 CalculatorButton.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				    Calculator hi = new Calculator();
				    hi.pack();
				    System.out.println("hi");
			 }
			 });
		 Open.add(CalculatorButton);
		 
		 view.add(sbar);
		 menubar.add(Open);
		 menubar.add(view);
		 menubar.setSize(100, 20);
		 frame.setJMenuBar(menubar);
		 statusbar = new JLabel(" Statusbar");
		 statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		 panel.add(statusbar, BorderLayout.SOUTH);
		 
		 menubar.setVisible(true);
		
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub

	}
}
