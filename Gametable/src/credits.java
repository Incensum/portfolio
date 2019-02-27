import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class credits {
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

		JFrame credits = new JFrame("Credits");

		GridBagConstraints cons = new GridBagConstraints();

		buttons.setSettingsFrame(credits);

		JPanel creditPanel = new JPanel();
		creditPanel.setLayout(new GridBagLayout());

		JButton who = new JButton("Who?");
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		who.setBorderPainted(true);
		who.setContentAreaFilled(false);
		who.setName("who");
		who.setFocusPainted(false);
		who.setFocusable(false);
		who.setBorderPainted(false);
		creditPanel.add(who, cons);

		JTextField whoWe = new JTextField();
		cons.gridx = 0;
		cons.gridy = 1;
		whoWe.setText("We are a group of students who attended Illinois State University");
		whoWe.setEditable(false);
		whoWe.setFocusable(false);
		whoWe.setBorder(null);
		whoWe.setName("whoWe");
		creditPanel.add(whoWe, cons);

		JButton blank1 = new JButton();
		cons.gridx = 0;
		cons.gridy = 2;
		blank1.setBorderPainted(false);
		blank1.setContentAreaFilled(false);
		blank1.setFocusPainted(false);
		blank1.setFocusable(false);
		creditPanel.add(blank1, cons);

		JButton what = new JButton("What?");
		cons.gridx = 0;
		cons.gridy = 3;
		what.setBorderPainted(true);
		what.setName("what");
		what.setContentAreaFilled(false);
		what.setFocusPainted(false);
		what.setBorderPainted(false);
		creditPanel.add(what, cons);

		JTextField whatWe = new JTextField();
		cons.gridx = 0;
		cons.gridy = 4;
		whatWe.setText("Design an application to make tear down and clean up of board games easy");
		whatWe.setEditable(false);
		whatWe.setName("whatWe");
		whatWe.setFocusable(false);
		whatWe.setBorder(null);
		creditPanel.add(whatWe, cons);
		
		JButton blank2 = new JButton();
		cons.gridx = 0;
		cons.gridy = 5;
		blank2.setBorderPainted(false);
		blank2.setContentAreaFilled(false);
		blank2.setFocusPainted(false);
		blank2.setFocusable(false);
		creditPanel.add(blank2, cons);
		
		JButton why = new JButton("Why?");
		cons.gridx = 0;
		cons.gridy = 6;
		why.setBorderPainted(true);
		why.setContentAreaFilled(false);
		why.setFocusPainted(false);
		why.setName("why");
		why.setBorderPainted(false);
		creditPanel.add(why, cons);

		JTextField whyWe = new JTextField();
		cons.gridx = 0;
		cons.gridy = 7;
		whyWe.setText("To make board games even easier to play and switch between");
		whyWe.setEditable(false);
		whyWe.setName("whyWe");
		whyWe.setFocusable(false);
		whyWe.setBorder(null);
		creditPanel.add(whyWe, cons);
		
		JButton blank3 = new JButton();
		cons.gridx = 0;
		cons.gridy = 8;
		blank3.setBorderPainted(false);
		blank3.setContentAreaFilled(false);
		blank3.setFocusPainted(false);
		blank3.setFocusable(false);
		creditPanel.add(blank3, cons);
	
		JButton house = new JButton("Housekeeping");
		cons.gridx = 0;
		cons.gridy = 9;
		house.setBorderPainted(true);
		house.setContentAreaFilled(false);
		house.setFocusPainted(false);
		house.setName("house");
		house.setBorderPainted(false);
		creditPanel.add(house, cons);

		JTextField housekeeping = new JTextField();
		cons.gridx = 0;
		cons.gridy = 10;
		housekeeping.setText("This application is a showcase tool for educational use only");
		housekeeping.setEditable(false);
		housekeeping.setName("housekeeping");
		housekeeping.setFocusable(false);
		housekeeping.setBorder(null);
		creditPanel.add(housekeeping, cons);

		credits.add(creditPanel);
		credits.setSize(450, 250);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		credits.setLocation(dim.width/2-credits.getSize().width/2, dim.height/2-credits.getSize().height/2);
		credits.setAlwaysOnTop(true);
		credits.setVisible(true);
	}
	
	JTextField text = new JTextField() {
	    @Override public void setBorder(Border border) {
	        // No!
	    }
	};

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
