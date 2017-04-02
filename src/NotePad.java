
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NotePad extends JFrame implements ActionListener {
	
	private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private MenuBar menuBar = new MenuBar(); 
	private PopupMenu background = new PopupMenu("Menu");
	private Menu menu = new Menu ("Background");
	private Menu Text = new Menu ("Text");
	private Menu file = new Menu();
	private MenuItem openFile = new MenuItem();  
	private MenuItem saveFile = new MenuItem(); 
	private MenuItem close = new MenuItem(); 
	
	
	
	public NotePad() {
	   
		this.setSize(500, 300); 
		this.setTitle("Notepad"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12)); 
		this.getContentPane().setLayout(new BorderLayout()); 
		this.getContentPane().add(textArea);
		this.setMenuBar(this.menuBar);
		this.menuBar.add(this.file); 
		
		background.add(menu);
		background.add(Text);
		
		 textArea.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseReleased(MouseEvent e) {
			 if (e.getButton() == MouseEvent.BUTTON3) {
			 background.show(e.getComponent(), e.getX(), e.getY());
			 }
			 }
		 });
		 
		
		MenuItem Black = new MenuItem("Black");
		Black.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 textArea.setBackground(Color.BLACK);
				 System.out.println("hello");
			}
		});
		
		menu.add(Black);
		
		
		MenuItem Red = new MenuItem("Red");
		Red.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 textArea.setBackground(Color.RED);
			}
		});
		
		menu.add(Red);
		
		MenuItem White = new MenuItem("White");
		White.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				 textArea.setBackground(Color.WHITE);
			}
		});
		
		menu.add(White);
		
		MenuItem WhiteText = new MenuItem("White");
		WhiteText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.setForeground(Color.WHITE);
			}
		});
		
		Text.add(WhiteText);
		
		MenuItem BlackText = new MenuItem("Black");
		BlackText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.setForeground(Color.BLACK);
			}
		});
		
		Text.add(BlackText);
		
		MenuItem HackText = new MenuItem("Hacker");
		HackText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.setForeground(Color.GREEN);
				textArea.setBackground(Color.BLACK);
				textArea.setFont(new Font("Courier", Font.BOLD, 15));
			}
		});
		
		Text.add(HackText);
		
		
		
		textArea.add(background);
		
		this.file.setLabel("File");

		this.openFile.setLabel("Open"); 
		this.openFile.addActionListener(this); 
		this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false)); 
		this.file.add(this.openFile); 
		
		this.saveFile.setLabel("Save");
		this.saveFile.addActionListener(this);
		this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		this.file.add(this.saveFile);
		
		this.close.setLabel("Close");
		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		this.close.addActionListener(this);
		this.file.add(this.close); 
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == this.close)
			this.dispose(); 
		
		else if (e.getSource() == this.openFile) {
			JFileChooser open = new JFileChooser(); 
			int option = open.showOpenDialog(this); 

			if (option == JFileChooser.APPROVE_OPTION) {
				this.textArea.setText(""); 
				try {
					Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					while (scan.hasNext()) 
						this.textArea.append(scan.nextLine() + "\n"); 
				} catch (Exception ex) { 
					System.out.println(ex.getMessage());
				}
			}
		}
		
		else if (e.getSource() == this.saveFile) {
			JFileChooser save = new JFileChooser(); 
			int option = save.showSaveDialog(this); 
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
				
					BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
					out.write(this.textArea.getText()); 
					out.close(); 
				} catch (Exception ex) { 
					System.out.println(ex.getMessage());
				}
			}
		}
	}

    public static void main(String args[]) {
        NotePad app = new NotePad();
        app.setVisible(true);
}
}