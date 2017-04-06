import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class CustomSlider extends JPanel {
	public static int redColor;
	public static int blueColor;
	public static int greenColor;
	public static Color color;
	public JPanel panel;

	public CustomSlider() {
		super(true);
		//this.setLayout(new SpringLayout());
		SpringLayout layout = new SpringLayout();
		JSlider sliderOne = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

		sliderOne.setMinorTickSpacing(50);
		//sliderOne.setMajorTickSpacing(25);
		sliderOne.setPaintTicks(true);
		sliderOne.setPaintLabels(true);
		sliderOne.setToolTipText("Red Value");

		sliderOne.setLabelTable(sliderOne.createStandardLabels(50));

		add(sliderOne, SpringLayout.NORTH);
		
		JLabel red = new JLabel("Red");
		add(red, SpringLayout.SOUTH);
		
		//layout.putConstraint(SpringLayout.WEST, sliderOne, 5, SpringLayout.WEST, );
		
		JSlider sliderTwo = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

		sliderTwo.setMinorTickSpacing(50);
		//sliderTwo.setMajorTickSpacing(50);
		sliderTwo.setPaintTicks(true);
		sliderTwo.setPaintLabels(true);
		sliderTwo.setToolTipText("Green Value");

		sliderTwo.setLabelTable(sliderTwo.createStandardLabels(50));
		
		
		add(sliderTwo, SpringLayout.VERTICAL_CENTER);
		
		JLabel green = new JLabel("Green");
		add(green,SpringLayout.SOUTH);
		
		JSlider sliderThree = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);

		sliderThree.setMinorTickSpacing(50);
		//sliderThree.setMajorTickSpacing(50);
		sliderThree.setPaintTicks(true);
		sliderThree.setPaintLabels(true);
		sliderThree.setToolTipText("Blue Value");

		sliderThree.setLabelTable(sliderThree.createStandardLabels(50));

		add(sliderThree, SpringLayout.SOUTH);
		
		JLabel blue = new JLabel("Blue");
		add(blue, SpringLayout.SOUTH);
		
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			 @Override
			public void actionPerformed(ActionEvent e) {
				 redColor = sliderOne.getValue();
				 greenColor = sliderTwo.getValue();
				 blueColor = sliderThree.getValue();
				 System.out.println(redColor + " " + greenColor + " " + blueColor);
				 Color color = new Color(redColor, greenColor, blueColor);
				 panel = Master.getPanelCustom();
				 panel.setBackground(color);
			 }
			 });
		add(enter, SpringLayout.VERTICAL_CENTER);
		
	}

	public static void main(String[] s) {
		/*System.out.println("Helloooo");
		JFrame frame = new JFrame("RGB Slider");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setContentPane(new CustomSlider());
		frame.setSize(500, 200);
		frame.setVisible(true);  */ 
	}
	public static int getR(){
		return redColor;
	}
	
	public static int getG(){
		return greenColor;
	}
	
	public static int getB(){
		return blueColor;
	}
	
	
}