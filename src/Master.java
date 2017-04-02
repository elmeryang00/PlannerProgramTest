

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class Master {
	static int a = 0;
	public static JMenu background;
	private static JLabel statusbar;
	
	//Timer timer = new Timer(this, 1000/60);
    //public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
	
	
	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame(); 
	
		// Creates Main Screen JFrame
		JPanel panel = new JPanel();
		frame.setSize(1000, 1000); // Sets size of JFrame
		Random c = new Random();
		panel.setBackground(Color.WHITE);
		
		
																// be exited
		panel.setLayout(null); // Allows the JButtons and JLabels to be moved
		//panel.setBackground(Color.black);

		JLabel text = new JLabel("All in 1 Planner"); // Displays text Maze
														// Runner
		text.setTransferHandler(new TransferHandler("text"));
		text.setBounds(410, 120, 500, 70); // Sets boundaries of the Text
		text.setFont(new Font("Serif", Font.PLAIN, 30));

		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(text);
		frame.getContentPane().add(text);

//		panel.add(text);
		text.setVisible(true);

		
		JButton Alarm = new JButton(" Alarm "); // New Button for Random
		Alarm.setTransferHandler(new TransferHandler("text"));
		Alarm.setVisible(true);									// Play
		Alarm.setBounds(490, 200, 450, 90); // Sets boundaries of the Buttons
		Alarm.setForeground(Color.BLACK);
		Alarm.addActionListener(new ActionListener() { //Allows Button Rando to be pressed
	    	  
	          @Override
			public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
	          {
	  	AlarmClock s = new AlarmClock();
	  	s.init();
	          }
	          });
		panel.add(Alarm);
		
		
		JButton breakRoom = new JButton(" Break Room "); // New Button for Random
		breakRoom.setTransferHandler(new TransferHandler("text"));
		breakRoom.setVisible(true);									// Play
		breakRoom.setBounds(40, 200, 450, 90); // Sets boundaries of the Buttons
		breakRoom.addActionListener(new ActionListener() { //Allows Button Rando to be pressed
	    	  
	          @Override
			public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
	          {
	        	  BreakRoom.Create();

	          }
	          
	      });
		panel.add(breakRoom);
		
		JButton Calendar = new JButton(" Calendar "); // New Button for Random
		Calendar.setTransferHandler(new TransferHandler("text"));
		Calendar.setVisible(true);									// Play
		Calendar.setBounds(40, 340, 450, 90); // Sets boundaries of the Buttons
		Calendar.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
         {
       	  SwingCalendar s = new SwingCalendar();
       	  s.updateMonth();
       	  SwingCalendar.main(args);

         }
		});
     
		panel.add(Calendar);

		JButton notePad = new JButton(" NotePad "); // New Button for Random
		notePad.setTransferHandler(new TransferHandler("text"));
		notePad.setVisible(true);									// Play
		notePad.setBounds(490, 340, 450, 90); // Sets boundaries of the Buttons
		notePad.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
         {
		       NotePad app = new NotePad();
		        app.setVisible(true);

         }
		});
     
		panel.add(notePad);
		
		JButton Calculator = new JButton( " Calculator ");
		Calculator.setTransferHandler(new TransferHandler("text"));
		Calculator.setVisible(true);
		Calculator.setBounds(40, 480, 450, 90);
		Calculator.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
			    Calculator calc = new Calculator();
			    calc.pack();
			}
		});
		
		panel.add(Calculator);		
		frame.add(panel);
		frame.setVisible(true); // Makes it visible	
		
		JButton ToDo = new JButton(" To-Do List "); // New Button for Random
		ToDo.setTransferHandler(new TransferHandler("text"));
		ToDo.setVisible(true);									// Play
		ToDo.setBounds(490, 480, 450, 90); // Sets boundaries of the Buttons
		ToDo.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
         {
		       ToDoList list = new ToDoList();
		        list.setVisible(true);

         }
		});
     
		panel.add(ToDo);
		
		
		
		
		
		JPopupMenu  menu = new JPopupMenu(); //Pop-Up Menu
		
		 frame.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseReleased(MouseEvent e) {
			 if (e.getButton() == MouseEvent.BUTTON3) {
			 menu.show(e.getComponent(), e.getX(), e.getY());
			 }
			 }
		 });
		JMenu misc = new JMenu("Misc.");
		menu.add(misc);
		
		JMenuItem TitleEdit = new JMenuItem("Custom Edit");
		TitleEdit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				TitleEdit.setToolTipText("Custom your Program by changing the Text");
				JFrame f = new JFrame();
				f.setSize(600,100);
				f.setVisible(true);
			
		        JTextField Field = new JTextField("Insert New Title");
		        Field.setToolTipText("Insert Text and Drop onto the Main Text");
		        f.add(Field);
		        
		        Field.setBounds(30, 50, 150, 25);
		        Field.setDragEnabled(true);
		        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				frame.add(f);
				System.out.println("hello");
			}
		});
		misc.add(TitleEdit); 
		
		JMenu textMenu = new JMenu("Text");
		menu.add(textMenu);
		
		JMenuItem Black = new JMenuItem("Black");
		Black.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 text.setForeground(Color.BLACK);
				 System.out.println("hello");
			}
		});
				 			
			
				 
		 textMenu.add(Black);
		 
		 background = new JMenu("Background");
		 
		 menu.add(background);
		 
		 JMenuItem blue = new JMenuItem("Blue");
		 blue.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			 panel.setBackground(Color.BLUE);
			 }
			 });
		 background.add(blue);
		 
		 JMenuItem black = new JMenuItem("Black");
		 black.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			 panel.setBackground(Color.BLACK);
			 }
			 });
		 background.add(black);
		
		 JMenuItem green = new JMenuItem("Green");
		 green.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			 panel.setBackground(Color.GREEN);
			 }
			 });
		 background.add(green);
		 
		 JMenuItem red = new JMenuItem("Red");
		 red.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
			 panel.setBackground(Color.RED);
			 }
			 });
		 background.add(red);
		 
		 JMenuItem gray = new JMenuItem("Gray");
		 gray.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
		 panel.setBackground(Color.GRAY);
			 }
			 });
		 background.add(gray);
		 
		 JMenuItem white = new JMenuItem("White");
		 white.addActionListener(new ActionListener(){
			 @Override
			public void actionPerformed(ActionEvent e){
				 panel.setBackground(Color.WHITE);
			 }
		 });
		 background.add(white);

		JMenuItem custom = new JMenuItem("Custom");				
		
		custom.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CustomSlider d = new CustomSlider();
				frame.add(d);
			}
		});
		background.add(custom);
		 
		 
		 
		 JMenuItem tipOfDay = new JMenuItem("Tip of the Day");
		 tipOfDay.addActionListener(new ActionListener(){
			 @Override
			public void actionPerformed(ActionEvent e) {
			TipOfDay f = new TipOfDay();
			frame.add(f);
		 }
	});
		menu.add(tipOfDay);
		
		
		 JMenuItem menuItemClose = new JMenuItem("Close", KeyEvent.VK_W);
		 menuItemClose.setMnemonic(KeyEvent.VK_W);
		 menuItemClose.addActionListener(new ActionListener() {
		 @Override
		public void actionPerformed(ActionEvent e) {
		 System.exit(0);
		 }
		 });
		 menu.add(menuItemClose);
		 
		 panel.add(menu);
		 
		 
		 
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
	       	  SwingCalendar.main(args);
			 }
			 });
		 Open.add(CalendarButton);
		 
		 JMenuItem BreakRoomButton = new JMenuItem("Break Room");
		 BreakRoomButton.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
	        	  BreakRoom.Create();
			 }
			 });
		 Open.add(BreakRoomButton);
		 
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
		 
		 Random randy = new Random();
		 while(true){
			 Thread.sleep(250);
				text.setForeground(new Color(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255), 250));
		 }
		 

		 }
		 
		 
		 
		 }


			
	
	
	
	
			
		
		
		

		 /**
		int Timer = 90000; //Changes color of the JText All in One PLanner
		while(Timer >0)
		{
		Timer--;
		if(Timer<=0)
		{

		for(int r = 0; r<250; r++)
		{
		//Random rand = new Random();	
			for (int g = 0; g<250; g++)
			{
				for(int b = 0; b<250; b++)
				{
					text.setForeground(new Color(r,g,b, 250));
					Timer = 90000;
				}
			}
			//text.setForeground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
			//text.setBackground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));	
		}
		}
	
	}
**/
	

	
	
