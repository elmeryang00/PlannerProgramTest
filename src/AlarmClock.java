
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class AlarmClock  extends Applet implements ActionListener, Runnable {

   // properties of the applet....

   // The current time the alarm is set for
   Date alartTime;   // NOTE: we ignore the year/month/day parts of the date

   // The music file (it's location) to play when the alarm should go off
   String musicFile;

   // GUI related properties...

   // top row
   JLabel currentTime;        // label showing the current time

   // alarm related stuff
   JLabel alarmTime;          // label showing the currently set alarm time
   JSpinner alarmSetter;      // input for selecting a new alarm time
   JButton setAlarm;          // button to click to set a new alarm time

   // file-picker related stuff
   JLabel fileName;           // label showing the file currently set to play
   JFileChooser fileChooser;  // the file-chooser widget
   JButton fileChooserButton; // the button that "activates" the above file-chooser widget
   JButton setMusic;        
   Thread runner;   
   int hours, minutes, seconds;
   
   int alarmMinute, alarmHour;
   
   
   AudioClip alarm;
   File wav;
   JPanel filePanel;

   // applet specific methods

   @Override
public void init() {

	  JFrame Alarm = new JFrame("Alarm");
	  Alarm.setSize(410, 410);
	  Alarm.setVisible(true);
	  Alarm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	  Alarm.setTitle("Alarm"); 
	 
	  //Alarm.setLayout(null);

	  
	   
      Alarm.setLayout(new BorderLayout());
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

      JPanel alarmPanel = new JPanel();
      alarmPanel.setLayout(null);
      alarmPanel.setLayout(new BoxLayout(alarmPanel, BoxLayout.Y_AXIS));

      filePanel = new JPanel();
      filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));

      
      JLabel topLabel = new JLabel("Current Time:");
      topLabel.setHorizontalAlignment(SwingConstants.CENTER);
      topLabel.setFont(topLabel.getFont().deriveFont(20.0f));
      topPanel.add(topLabel);

      
      currentTime = new JLabel();
      currentTime.setHorizontalAlignment(SwingConstants.CENTER);
      currentTime.setFont(currentTime.getFont().deriveFont(50.0f));
      topPanel.add(currentTime);
      System.out.println("Start Initial");


      alarmPanel.add(new JLabel("Alarm Time:"));
      alarmTime = new JLabel("00:00");
      //alarmTime = new JLabel("Hour: " + alarmHour + "  " + "Minute: " + alarmMinute);
      alarmTime.setHorizontalAlignment(SwingConstants.CENTER);
      alarmTime.setFont(alarmTime.getFont().deriveFont(25f));
      alarmPanel.add(alarmTime);
      setAlarm = new JButton("Set Alarm");
      alarmPanel.add(setAlarm);

      Alarm.add(topPanel, BorderLayout.PAGE_START);
      Alarm.add(alarmPanel, BorderLayout.LINE_START);
      Alarm.add(filePanel, BorderLayout.LINE_END);

      setAlarm.addActionListener(this);

      runner = new Thread(this);
      runner.start();
      

      JPanel text = new JPanel();
      text.setLayout(null);
      JLabel hourText = new JLabel();
      JTextField r = new JTextField("Insert Hour", 5) ;
      //r.setBackground(Color.BLUE);
      r.setBounds(10, 0, 100, 50);
      r.setToolTipText("Press Enter to enter value");
      text.add(r);
      
      r.addActionListener(new ActionListener()
      {
    	  @Override
		public void actionPerformed(ActionEvent e)
    	  {
    		  String hourInput = r.getText();
    		 //hourText.setText("Hour: " + hourInput);
    		  hours = Integer.parseInt(hourInput);
    		  alarmHour = hours;    		  
    		  if(alarmHour>23 || alarmHour<0)
    		  {
    			  JOptionPane.showMessageDialog(null,"Please put a number between 0 and 23", "Error", JOptionPane.ERROR_MESSAGE);
    		  }
    			  else{
    		  if(alarmHour<10)
    		  	{
    			  if(alarmMinute<10)
    			  {
    			  alarmTime.setText("0" + alarmHour + ":" + "0" + alarmMinute);
    			  }
    			  else if(alarmMinute>10)
    			  {
    				  alarmTime.setText("0" + alarmHour + ":" + alarmMinute);
    			  }

    		  	}
    		  else
    		  {
    			  if(alarmMinute<10)
    			  {
    			  alarmTime.setText(alarmHour + ":" + "0" + alarmMinute);
    			  }
    			  else if(alarmMinute>10)
    			  {
    				  alarmTime.setText(alarmHour + ":" + alarmMinute);
    			  }
    		  }
    		  //alarmTime.setText("Hour: " + alarmHour + "  " + "Minute: " + alarmMinute);

    		  }
    		  }
    	  
      });
      alarmPanel.add(hourText);
      r.setVisible(true);
      alarmPanel.add(text);
      
      


      
      JPanel minutePanel = new JPanel();
      minutePanel.setLayout(null);
      
      JLabel minutesDisplay = new JLabel();
      minutesDisplay.setBounds(10, 100, 100, 30);
      minutePanel.setLayout(null);
      
      
      
      
      
      JTextField s = new JTextField("Insert Minute", 5);
      
      s.setToolTipText("Press Enter to enter value");
      s.setBounds(10, 0, 100, 50);
      
      s.addActionListener(new ActionListener()
      {
    	  @Override
		public void actionPerformed(ActionEvent e)
    	  {
    		  String minutesTime= s.getText();
    		  minutesDisplay.setText("Minute: " + minutesTime);
    		  minutes = Integer.parseInt(minutesTime);
    		  System.out.println(minutes);
    		  alarmMinute = minutes;    		 
    		  if(alarmMinute>59 || alarmMinute<0)
    		  {
    			  JOptionPane.showMessageDialog(null,"Please put a number between 0 and 59", "Error", JOptionPane.ERROR_MESSAGE);
    		  }
    		  else{
    		  if(alarmHour<10)
  		  	{
  			  if(alarmMinute<10)
  			  {
  			  alarmTime.setText("0" + alarmHour + ":" + "0" + alarmMinute);
  			  }
  			  else if(alarmMinute>10)
  			  {
  				  alarmTime.setText("0" + alarmHour + ":" + alarmMinute);
  			  }

  		  	}
  		  else
  		  {
  			  if(alarmMinute<10)
  			  {
  			  alarmTime.setText(alarmHour + ":" + "0" + alarmMinute);
  			  }
  			  else if(alarmMinute>10)
  			  {
  				  alarmTime.setText(alarmHour + ":" + alarmMinute);
  			  }
  		  }
    		  //alarmTime.setText("Hour: " + alarmHour + "  " + "Minute: " + alarmMinute);

    	  }
    	  }
    	  
      });
    //  minutePanel.add(minutesDisplay);
       
     
     s.setVisible(true);
    minutePanel.add(s);
      
      
      
     alarmPanel.add(minutePanel);
      Alarm.add(alarmPanel);
      s.setVisible(true);
      
   filePanel.setVisible(true);
   JCheckBox active = new JCheckBox("Music Customizer");
   active.setToolTipText("Unchecking the box removes the Alarm Music Settings Panel");
   active.setBounds(160, 30, 140, 25);
   active.setSelected(true);
   active.addItemListener(new ItemListener() 
   {
	   @Override
	public void itemStateChanged(ItemEvent event) 
	   {
		   if (active.isSelected()) 
		   {
		   		filePanel.setVisible(true);
		   }
		   else
		   {
			   filePanel.setVisible(false);
		   }
		   
	   	}
   });
   
   alarmPanel.add(active);

   
   
   
   
   //Selecting Music Code
   filePanel.add(new JLabel("Music File:"));
   fileName = new JLabel("N/A");
   filePanel.add(fileName);
   filePanel.add(new JLabel("Select New File:"));
   fileChooser = new JFileChooser();
   
   fileChooserButton = new JButton("Browse..."); //Creates a new Button to browse library
   fileChooserButton.setToolTipText("File must be .wav"); //Tooltip pop up
   filePanel.add(fileChooserButton);
   
   
   setMusic = new JButton("Set Music");
   //filePanel.add(setMusic);

   setAlarm.addActionListener(this);
   setMusic.addActionListener(this);
   fileChooserButton.addActionListener(this);
   

   
   runner = new Thread(this);
   runner.start();
   }

   
   
   @Override
public void actionPerformed(ActionEvent e) 
   {

	      if (e.getSource() == fileChooserButton) {
	         int option = fileChooser.showOpenDialog(this);
	         wav = fileChooser.getSelectedFile();
	         fileName.setText(wav.getName()); 
	         //Clip r = (Clip) fileChooser.getSelectedFile();
	      }	     
}   
   public void alarmRing() 
   {
	   Date current = new Date();
	   if(minutes == current.getMinutes() && hours == current.getHours() && current.getSeconds() == 0)
	   {
		   try {
			   AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wav.getAbsoluteFile());
			   //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("AlarmW.mp3").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	   }
   }
	   
@Override
public void run() {
	System.out.println("run");
      while (true) {
         Date now = new Date();
         currentTime.setText(now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());

         try {
            Thread.currentThread();
			Thread.sleep(1000);
            alarmRing();
         } catch (Exception e) {
         }
      }
   }

}

