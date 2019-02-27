
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class SolitaireFrame {

	//sets the current frame for disposal
	public static JFrame  currentFrame = new JFrame();

	//button listener class
	static ButtonListener buttonListener = new ButtonListener();

	//functions for each button to work
	static ButtonFunctions buttons = new ButtonFunctions();

	public static void run() throws IOException {
		solitaire();
	}

	static Image backImage;
	static String menuPic;
	static String powerPic;
	static String logoPic;

	private static void solitaire() throws IOException {

		//layout system to add button and clock
		GridBagConstraints cons = new GridBagConstraints();

		//background Image choice for table
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

		//theme image choice for table
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
		JFrame catan= new JFrame("catan");

		//for closing panels
		buttons.setFrame(catan);	

		//paints background
		JPanel background = new TableBackground();
		background.setLayout(new GridBagLayout());

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
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.FIRST_LINE_END;
		background.add(menu, cons);

		//chess Image read in
		BufferedImage catanIco = ImageIO.read(new File("Images/solitaire.png"));
		Image catanImage = catanIco.getScaledInstance(1750, 1200, Image.SCALE_SMOOTH);
		ImageIcon catanI = new ImageIcon(catanImage);

		//Game mat 
		JButton CatanMat = new JButton(catanI);
		CatanMat.setOpaque(false);
		CatanMat.setContentAreaFilled(false);
		CatanMat.setBorderPainted(false);
		CatanMat.setFocusPainted(false);

		//sets game mat to the center
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(CatanMat, cons); 

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
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.LAST_LINE_END;
		background.add(exit, cons);

		//adds all components together
		catan.add(background);
		catan.setExtendedState(JFrame.MAXIMIZED_BOTH);
		catan.setUndecorated(true);
		catan.setVisible(true);
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