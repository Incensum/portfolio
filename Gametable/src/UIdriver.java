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
 * Created By: Ben Abrams
 * Date Created: 8/28/18
 * 
 * Last Edited By: Ben Abrams
 * Date Edited: 9/21/18
 */

/*
 * This is the driver class for the UI and the entire application
 * This will be the place where all functions and UI work comes together
 */
public class UIdriver {

	//sets current Jframe
	public static JFrame currentFrame = new JFrame();

	//button listener class
	static ButtonListener buttonListener = new ButtonListener();

	//functions for each button to work
	static ButtonFunctions buttons = new ButtonFunctions();

	public static void main(String[] args) throws IOException {
		mainFrame();
	}

	static Image backImage;
	static String settingPic;
	static String powerPic;
	static String logoPic;
	static String creditsPic;

	public static int backgroundImage = 0;

	public static int themeImage = 0;

	static JPanel background = null;

	public static void updateTable() {
		background = new TableBackground();
	}

	public static void mainFrame() throws IOException {

		//layout system to add button and clock
		GridBagConstraints cons = new GridBagConstraints();

		//background Image choice for table
		if(backgroundImage == 0) {
			backImage = new ImageIcon("Images/TableBackground.jpg").getImage();
		}
		if(backgroundImage == 1) {
			backImage = new ImageIcon("Images/TableBackground2.jpg").getImage();
		}
		if(backgroundImage == 2) {
			backImage = new ImageIcon("Images/TableBackground3.jpg").getImage();
		}
		if(backgroundImage == 3) {
			backImage = new ImageIcon("Images/TableBackground4.jpg").getImage();
		}
		if(backgroundImage == 4) {
			backImage = new ImageIcon("Images/TableBackground5.jpg").getImage();
		}
		if(backgroundImage == 5) {
			backImage = new ImageIcon("Images/TableBackground6.jpg").getImage();
		}


		//theme image choice for table
		if(themeImage == 0) {
			settingPic = "Images/settingslogo.png";
			powerPic = "Images/power.png";
			logoPic = "Images/TableTop_clear.png";
			creditsPic = "Images/creditsWhite.png";
		}
		if(themeImage == 1) {
			settingPic = "Images/settingslogoBlack.png";
			powerPic = "Images/powerBlack.png";
			logoPic = "Images/TableTop_clearBlack.png";
			creditsPic = "Images/creditsBlack.png";
		}
		if(themeImage == 2) {
			settingPic = "Images/settingslogoBlue.png";
			powerPic = "Images/powerBlue.png";
			logoPic = "Images/TableTop_clearBlue.png";
			creditsPic = "Images/creditsBlue.png";
		}
		if(themeImage == 3) {
			settingPic = "Images/settingslogoGold.png";
			powerPic = "Images/powerGold.png";
			logoPic = "Images/TableTop_clearGold.png";
			creditsPic = "Images/creditsGold.png";
		}
		if(themeImage == 4) {
			settingPic = "Images/settingslogoGreen.png";
			powerPic = "Images/powerGreen.png";
			logoPic = "Images/TableTop_clearGreen.png";
			creditsPic = "Images/creditsGreen.png";
		}
		if(themeImage == 5) {
			settingPic = "Images/settingslogoRed.png";
			powerPic = "Images/powerRed.png";
			logoPic = "Images/TableTop_clearRed.png";
			creditsPic = "Images/creditsRed.png";
		}


		updateTable();

		//mainUI frame
		JFrame main = new JFrame("Game Table");

		//for closing panels
		buttons.setFrame(main);

		//paints background
		background.setLayout(new GridBagLayout());

		//read in setting logo
		BufferedImage settingsIcon = ImageIO.read(new File(settingPic));
		Image settingsImage = settingsIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon settingIcon = new ImageIcon(settingsImage);

		//creates settings button
		JButton settings = new JButton(settingIcon);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setFocusPainted(false);
		settings.setName("settings");
		settings.addActionListener(buttonListener);

		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.FIRST_LINE_START;
		background.add(settings, cons);

		//read in Credits logo
		BufferedImage creditsIcon = ImageIO.read(new File(creditsPic));
		Image creditsImage = creditsIcon.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon iconCredits = new ImageIcon(creditsImage);

		//creates settings button
		JButton credits = new JButton(iconCredits);
		credits.setOpaque(false);
		credits.setContentAreaFilled(false);
		credits.setBorderPainted(false);
		credits.setFocusPainted(false);
		credits.setName("credits");
		credits.addActionListener(buttonListener);

		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 4;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.FIRST_LINE_END;
		background.add(credits, cons);


		//read in checkers logo
		BufferedImage checkersIcon = ImageIO.read(new File("Images/checkersboxp.png"));
		Image iconCheck = checkersIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon check = new ImageIcon(iconCheck);

		//creates checkers button
		JButton checkers = new JButton(check);
		checkers.setOpaque(false);
		checkers.setContentAreaFilled(false);
		checkers.setBorderPainted(false);
		checkers.setFocusPainted(false);
		checkers.setName("checkers");
		checkers.addActionListener(buttonListener);

		//put the checkers button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 0;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(checkers, cons);

		//read in texas holdem logo
		BufferedImage pokerIcon = ImageIO.read(new File("Images/holdem.png"));
		Image iconPoker = pokerIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon pokerimg = new ImageIcon(iconPoker);

		//creates the poker button
		JButton poker = new JButton(pokerimg);
		poker.setOpaque(false);
		poker.setContentAreaFilled(false);
		poker.setBorderPainted(false);
		poker.setFocusPainted(false);
		poker.setName("poker");
		poker.addActionListener(buttonListener);

		//puts poker button in the middle
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 0;
		cons.gridy = 2;		
		cons.anchor = GridBagConstraints.CENTER;
		background.add(poker,cons);

		//reads in the solitaire logo
		BufferedImage solIcon = ImageIO.read(new File("Images/solitairebox.png"));
		Image iconsol = solIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon sol = new ImageIcon(iconsol);

		//creates solitaire button
		JButton solitaire = new JButton(sol);
		solitaire.setOpaque(false);
		solitaire.setContentAreaFilled(false);
		solitaire.setBorderPainted(false);
		solitaire.setFocusPainted(false);
		solitaire.setName("solitaire");
		solitaire.addActionListener(buttonListener);

		//put the solitaire button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 3;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(solitaire, cons);

		//reads in the monopoly logo
		BufferedImage monoIcon = ImageIO.read(new File("Images/monopolyLogo.png"));
		Image iconMono = monoIcon.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
		ImageIcon monoLogo = new ImageIcon(iconMono);

		//creates chess button
		JButton monopoly = new JButton(monoLogo);
		monopoly.setOpaque(false);
		monopoly.setContentAreaFilled(false);
		monopoly.setBorderPainted(false);
		monopoly.setFocusPainted(false);
		monopoly.setName("monopoly");
		monopoly.addActionListener(buttonListener);

		//put the monopoly button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 1;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(monopoly, cons);

		//readis in the catan Logo
		BufferedImage CatanIcon = ImageIO.read(new File("Images/catanLogo.png"));
		Image iconCatan = CatanIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon catanLogo = new ImageIcon(iconCatan);

		//creats catan button
		JButton catan = new JButton(catanLogo);
		catan.setOpaque(false);
		catan.setContentAreaFilled(false);
		catan.setBorderPainted(false);
		catan.setFocusPainted(false);
		catan.setName("catan");
		catan.addActionListener(buttonListener);

		//puts catan button in the middle
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 1;
		cons.gridy = 2;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(catan, cons);

		//reads in the chess logo
		BufferedImage chessIcon = ImageIO.read(new File("Images/chessLogo.png"));
		Image iconChess = chessIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon chessLogo = new ImageIcon(iconChess);

		//creates chess button
		JButton chess = new JButton(chessLogo);
		chess.setOpaque(false);
		chess.setContentAreaFilled(false);
		chess.setBorderPainted(false);
		chess.setFocusPainted(false);
		chess.setName("chess");
		chess.addActionListener(buttonListener);

		//put the chess button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 3;
		cons.gridy = 2;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(chess, cons);

		//reads in the yugioh logo
		BufferedImage yugiIcon = ImageIO.read(new File("Images/YugiohLogo.png"));
		Image yugiohIcon = yugiIcon.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon yugiLogo = new ImageIcon(yugiohIcon);

		//creates yugioh button
		JButton yugioh = new JButton(yugiLogo);
		yugioh.setOpaque(false);
		yugioh.setContentAreaFilled(false);
		yugioh.setBorderPainted(false);
		yugioh.setFocusPainted(false);
		yugioh.setName("yugioh");
		yugioh.addActionListener(buttonListener);

		//put the yugioh button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 2;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(yugioh, cons);

		//reads in the magic logo
		BufferedImage magicIcon = ImageIO.read(new File("Images/magicLogo.png"));
		Image magictheIcon = magicIcon.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon magicLogo = new ImageIcon(magictheIcon);

		//creates magic button
		JButton magic = new JButton(magicLogo);
		magic.setOpaque(false);
		magic.setContentAreaFilled(false);
		magic.setBorderPainted(false);
		magic.setFocusPainted(false);
		magic.setName("magic");
		magic.addActionListener(buttonListener);

		//put the magic button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 2;
		cons.gridy = 2;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(magic, cons);

		//reads in the farkle logo
		BufferedImage farkleIcon = ImageIO.read(new File("Images/farkle.png"));
		Image farkletheIcon = farkleIcon.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon farkleLogo = new ImageIcon(farkletheIcon);
		/*
		//creates farkle button
		JButton farkle = new JButton(farkleLogo);
		farkle.setOpaque(false);
		farkle.setContentAreaFilled(false);
		farkle.setBorderPainted(false);
		farkle.setFocusPainted(false);
		farkle.setName("farkle");
		farkle.addActionListener(buttonListener);

		//put the farkle button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 4;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(farkle, cons);
		 */
		//reads in the yahtzee logo
		BufferedImage yahtzeeIcon = ImageIO.read(new File("Images/yahtzee.png"));
		Image yahtzeetheIcon = yahtzeeIcon.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon yahtzeeLogo = new ImageIcon(yahtzeetheIcon);
		/*
		//creates yahtzee button
		JButton yahtzee = new JButton(yahtzeeLogo);
		yahtzee.setOpaque(false);
		yahtzee.setContentAreaFilled(false);
		yahtzee.setBorderPainted(false);
		yahtzee.setFocusPainted(false);
		yahtzee.setName("yahtzee");
		yahtzee.addActionListener(buttonListener);

		//put the yahtzee button in the middle 
		cons.weightx = 15;
		cons.weighty = 15;
		cons.gridx = 4;
		cons.gridy = 2;
		cons.anchor = GridBagConstraints.CENTER;
		background.add(yahtzee, cons);
		 */
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
		cons.gridy = 2;
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
		cons.gridx = 4;
		cons.gridy = 2;
		cons.anchor = GridBagConstraints.LAST_LINE_END;
		background.add(exit, cons);

		//adds all components together
		main.add(background);
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setUndecorated(true);
		main.setVisible(true);
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
