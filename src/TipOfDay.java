
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

public class TipOfDay extends JDialog {
	public TipOfDay() {
		setTitle("Tip of the Day");
		JPanel basic = new JPanel();
		
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
		add(basic);

		
		JPanel topPanel = new JPanel(new BorderLayout(0, 0));
		topPanel.setMaximumSize(new Dimension(450, 0));
		 
		JLabel hint = new JLabel("JDeveloper Productivity Hints");
		hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		topPanel.add(hint);
		
		ImageIcon icon = new ImageIcon("jdev.png");
		JLabel label = new JLabel(icon);
		label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		topPanel.add(label, BorderLayout.EAST);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.gray);
		topPanel.add(separator, BorderLayout.SOUTH);
		basic.add(topPanel);
		
		JPanel textPanel = new JPanel(new BorderLayout());
		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15,25));
		
		JTextPane pane = new JTextPane();
		pane.setContentType("text/html");
		String closeTip = "<p><b>Closing windows using the mouse</b></p>" + "<p>Clicking with the mouse wheel on the x on the home screen closes the program" + " while clicking on the x on any other screen just closes that screen." + "This method works also with dockable windows or Log window tabs.</p>";
		String backgroundTip = "<p><b>Customizing your background</b></p>" + "<p>In order to customize your program, right click anywhere on the home screen and select any color under background</p>";
		String layoutTip = "<p><b>Using the Planner Layout<b></p>" + "<p>To make using the program more efficient, pull up multiple applications side by side for maximum efficiency";
		
		 ArrayList <String> tips = new ArrayList<String>();
		 tips.add(closeTip);
		 tips.add(backgroundTip);
		 tips.add(layoutTip);
		
		 int random = (int )(Math.random() * 3);
		
		pane.setText(tips.get(random));
		pane.setEditable(false);
		textPanel.add(pane);
		basic.add(textPanel);
		 
		JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
		 
		JCheckBox box = new JCheckBox("Show Tips at startup");
		box.setMnemonic(KeyEvent.VK_S);
		boxPanel.add(box);
		basic.add(boxPanel);
		
		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ntip = new JButton("Next Tip");
		ntip.setMnemonic(KeyEvent.VK_N);
		
		
		 bottom.add(ntip);
		 basic.add(bottom);
		 bottom.setMaximumSize(new Dimension(450, 0));
		 setSize(new Dimension(450, 350));
		 setResizable(false);
		 setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 setVisible(true);
		 
		 JButton close = new JButton("Close");
		 close.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) //Checks Rando to see if it is pressed
		         {
					//basic.setVisible(false);
					basic.hide();
					setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		         }
				});  
		 		close.setMnemonic(KeyEvent.VK_C);
				 bottom.add(close);
		 		
		 }
	 public static void main(String[] args) {
		 new TipOfDay();
		 }
		}
		 
		 