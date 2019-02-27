import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Created By: Ben Roussin
 * Date Created: 10/1/18
 * 
 * Last Edited By: Ben Roussin
 * Date Edited: 10/9/18
 */
public class chessFrame {
	
	//sets the current frame for disposal
	public static JFrame  currentFrame = new JFrame();
	
	//button listener class
	static ButtonListener buttonListener = new ButtonListener();
	
	//functions for each button to work
	static ButtonFunctions buttons = new ButtonFunctions();

	public static void run() throws IOException {
		chess();
	}

	static Image backImage;
	static String menuPic;
	static String powerPic;
	static String logoPic;
	
	private static void chess() throws IOException {
		
		//layout system to add button and clock
		GridBagConstraints cons = new GridBagConstraints();
		
		//background Image for table
		if(UIdriver.backgroundImage == 0) {
			backImage = new ImageIcon("Images/TableBackground.jpg").getImage();
		}
		if(UIdriver.backgroundImage == 1) {
			backImage = new ImageIcon("Images/TableBackground2.jpg").getImage();
		}
		if(UIdriver.backgroundImage == 2) {
			backImage = new ImageIcon("Images/TableBackground3.jpg").getImage();
		}
		if(UIdriver.backgroundImage == 3) {
			backImage = new ImageIcon("Images/TableBackground4.jpg").getImage();
		}
		if(UIdriver.backgroundImage == 4) {
			backImage = new ImageIcon("Images/TableBackground5.jpg").getImage();
		}
		if(UIdriver.backgroundImage == 5) {
			backImage = new ImageIcon("Images/TableBackground6.jpg").getImage();
		}
		
		if(UIdriver.themeImage == 0) {
			menuPic = "Images/menu.png";
			powerPic = "Images/power.png";
			logoPic = "Images/TableTop_clear.png";
		}
		if(UIdriver.themeImage == 1) {
			menuPic = "Images/menuBlack.png";
			powerPic = "Images/powerBlack.png";
			logoPic = "Images/TableTop_clearBlack.png";
		}
		if(UIdriver.themeImage == 2) {
			menuPic = "Images/menuBlue.png";
			powerPic = "Images/powerBlue.png";
			logoPic = "Images/TableTop_clearBlue.png";
		}
		if(UIdriver.themeImage == 3) {
			menuPic = "Images/menuGold.png";
			powerPic = "Images/powerGold.png";
			logoPic = "Images/TableTop_clearGold.png";
		}
		if(UIdriver.themeImage == 4) {
			menuPic = "Images/menuGreen.png";
			powerPic = "Images/powerGreen.png";
			logoPic = "Images/TableTop_clearGreen.png";
		}
		if(UIdriver.themeImage == 5) {
			menuPic = "Images/menuRed.png";
			powerPic = "Images/powerRed.png";
			logoPic = "Images/TableTop_clearRed.png";
		}
		
		//runUI frame
		JFrame chess= new JFrame("chess");
		
		//for closing panels
		buttons.setFrame(chess);	
		
		//paints background
		JPanel background = new TableBackground();
		background.setLayout(new GridBagLayout());
		
		// //place holder for digital clock
		// JButton clock = new JButton("HH:MM");
		// clock.setForeground(Color.WHITE);
		// clock.setOpaque(false);
		// clock.setContentAreaFilled(false);
		// clock.setBorderPainted(false);
		// clock.setFocusPainted(false);
		// clock.setName("time");
		
		// //sets the clock to center
		// cons.anchor = GridBagConstraints.PAGE_START;
		// background.add(clock, cons);
		
		//menu Image read in
        BufferedImage menuIcon = ImageIO.read(new File(menuPic));
        Image menuImage = menuIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon menuLogo = new ImageIcon(menuImage);
        
        //menu button
        JButton menu = new JButton(menuLogo);
        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(false);
        menu.setFocusPainted(false);
        menu.setName("menu");
        menu.addActionListener(buttonListener);
        
        //sets to upper right corner
        cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 1;
		cons.gridy = 0;
        cons.anchor = GridBagConstraints.FIRST_LINE_END;
        background.add(menu, cons);
        
        JButton timer = new JButton("Timer");
        timer.setFocusPainted(false);
        timer.setName("timer");
        timer.addActionListener(buttonListener);
        
        cons.weightx = 15;
        cons.weighty = 15;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.CENTER;
        background.add(timer, cons);
        
        //chess Image read in
        BufferedImage chessIco = ImageIO.read(new File("Images/chess.png"));
        Image chessImage = chessIco.getScaledInstance(1100, 1100, Image.SCALE_SMOOTH);
        ImageIcon chessI = new ImageIcon(chessImage);

        //Game mat 
        JButton checkMat = new JButton(chessI);
        checkMat.setOpaque(false);
        checkMat.setContentAreaFilled(false);
        checkMat.setBorderPainted(false);
		checkMat.setFocusPainted(false);

        //sets checkerboard to the center
        cons.anchor = GridBagConstraints.CENTER;
        cons.gridy = 0;
        cons.gridx = 1;
        background.add(checkMat, cons);

		//TableTop Icon read in
		BufferedImage TIcon = ImageIO.read(new File(logoPic));
		Image iconImage = TIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(iconImage);

		//developer mode button - currently does nothing
		JButton devMode = new JButton(icon);
		devMode.setOpaque(false);
		devMode.setContentAreaFilled(false);
		devMode.setBorderPainted(false);
		devMode.setFocusPainted(false);
		devMode.setName("devMode");
		devMode.addActionListener(buttonListener);
		
		//sets icon to be in lower left corner
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.LAST_LINE_START;
		background.add(devMode, cons);
		
		//exit button image
		BufferedImage pwr = ImageIO.read(new File(powerPic));
		Image pwrImage = pwr.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon power = new ImageIcon(pwrImage);

		//exit Button
		JButton exit = new JButton(power);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setName("exit");
		exit.addActionListener(buttonListener);
		
		//sets button to lower right corner
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 1;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.LAST_LINE_END;
		background.add(exit, cons);
		
		//adds all components together
		chess.add(background);
		chess.setExtendedState(JFrame.MAXIMIZED_BOTH);
		chess.setUndecorated(true);
		chess.setVisible(true);
	}
	
	//paints background so a button and  clock can go over top, can be put in all classes
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