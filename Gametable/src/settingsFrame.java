import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class settingsFrame {
	
	static Image backImage =  new ImageIcon("Images/blackbg.jpg").getImage();
	
	//sets the current frame for disposal
	public static JFrame  currentFrame = new JFrame();
	
	//button listener class
	static settingsListener settingsListener = new settingsListener();
	
	static ButtonListener buttonListener = new ButtonListener();
	
	//functions for each button to work
	static ButtonFunctions buttons = new ButtonFunctions();

	public static void run() throws IOException {
		settings();
	}
	
	private static void settings() throws IOException {
		
		JFrame settings = new JFrame("settings");
		
		buttons.setSettingsFrame(settings);
		
		JPanel setPanel = new TableBackground();
		setPanel.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		Insets insets = new Insets(5,5,5,5);
		
		JLabel background = new JLabel();
		background.setForeground(Color.WHITE);
		background.setText("Table Background");
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridwidth = 2;
		setPanel.add(background, cons);		
		
		cons.insets = insets;
		
		JButton background1 = new JButton(" 1  ");
		background1.setSize(50, 50);
		background1.setName("b1");
		background1.addActionListener(settingsListener);
		cons.gridx = 0;
		cons.gridy = 1;
		cons.gridwidth = 1;
		
		setPanel.add(background1, cons);
		
		JButton background2 = new JButton(" 2  ");
		background2.setSize(50, 50);
		background2.setName("b2");
		background2.addActionListener(settingsListener);
		cons.gridx = 1;
		cons.gridy = 1;
		cons.gridwidth = 1;
		
		setPanel.add(background2, cons);
		
		JButton background3 = new JButton(" 3  ");
		background3.setSize(50, 50);
		background3.setName("b3");
		background3.addActionListener(settingsListener);
		cons.gridx = 2;
		cons.gridy = 1;
		cons.gridwidth = 1;
		
		setPanel.add(background3, cons);
		
		JButton background4 = new JButton(" 4  ");
		background4.setSize(50, 50);
		background4.setName("b4");
		background4.addActionListener(settingsListener);
		cons.gridx = 3;
		cons.gridy = 1;
		cons.gridwidth = 1;
		
		setPanel.add(background4, cons);
		
		JButton background5 = new JButton(" 5  ");
		background5.setSize(50, 50);
		background5.setName("b5");
		background5.addActionListener(settingsListener);
		cons.gridx = 4;
		cons.gridy = 1;
		cons.gridwidth = 1;
		
		setPanel.add(background5, cons);
		
		JButton background6 = new JButton(" 6  ");
		background6.setSize(50, 50);
		background6.setName("b6");
		background6.addActionListener(settingsListener);
		cons.gridx = 5;
		cons.gridy = 1;
		cons.gridwidth = 1;
		setPanel.add(background6, cons);
		

		JLabel empty1 = new JLabel();
		cons.gridy = 2;
		empty1.setText(" ");
		setPanel.add(empty1,cons);
		
		JLabel theme = new JLabel();
		theme.setForeground(Color.WHITE);
		theme.setText("Table Theme");
		cons.gridx = 2;
		cons.gridy = 3;
		cons.gridwidth = 2;
		setPanel.add(theme, cons);	
		
		JButton theme1 = new JButton(" 1  ");
		theme1.setSize(50, 50);
		theme1.setName("t1");
		theme1.addActionListener(settingsListener);
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme1, cons);
		
		JButton theme2 = new JButton(" 2  ");
		theme2.setSize(50, 50);
		theme2.setName("t2");
		theme2.addActionListener(settingsListener);
		cons.gridx = 1;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme2, cons);
		
		JButton theme3 = new JButton(" 3  ");
		theme3.setSize(50, 50);
		theme3.setName("t3");
		theme3.addActionListener(settingsListener);
		cons.gridx = 2;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme3, cons);
		
		JButton theme4 = new JButton(" 4  ");
		theme4.setSize(50, 50);
		theme4.setName("t4");
		theme4.addActionListener(settingsListener);
		cons.gridx = 3;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme4, cons);
		
		JButton theme5 = new JButton(" 5  ");
		theme5.setSize(50, 50);
		theme5.setName("t5");
		theme5.addActionListener(settingsListener);
		cons.gridx = 4;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme5, cons);
		
		JButton theme6 = new JButton(" 6  ");
		theme6.setSize(50, 50);
		theme6.setName("t6");
		theme6.addActionListener(settingsListener);
		cons.gridx = 5;
		cons.gridy = 4;
		cons.gridwidth = 1;
		setPanel.add(theme6, cons);
		
		JLabel empty2 = new JLabel();
		cons.gridy = 5;
		empty2.setText(" ");
		setPanel.add(empty2,cons);
		
		JButton okay = new JButton("OK");
		okay.setSize(50, 50);
		okay.setName("okay");
		okay.addActionListener(buttonListener);
		cons.gridx = 2;
		cons.gridy = 6;
		cons.gridwidth = 2;
		setPanel.add(okay, cons);
		settings.add(setPanel);
		settings.setSize(400,225);
		
		settings.setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		settings.setLocation(dim.width/2-settings.getSize().width/2, dim.height/2-settings.getSize().height/2);
		settings.setAlwaysOnTop(true);
		settings.setVisible(true);
	}
	
	static class TableBackground extends JPanel {
		public TableBackground() {
			setBackground(new Color(0, true));
		}
		@Override
		public void paintComponent(Graphics g) {
			//Paint background first
			g.drawImage (backImage, 0, 0, getWidth (), getHeight (), this);
			//Paint the rest of the component. Children and self etc.
			super.paintComponent(g);
		}
	}
		
}
