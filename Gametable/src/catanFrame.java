
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
public class catanFrame {

	//sets the current frame for disposal
	public static JFrame  currentFrame = new JFrame();

	//button listener class
	static ButtonListener buttonListener = new ButtonListener();

	//functions for each button to work
	static ButtonFunctions buttons = new ButtonFunctions();

	public static void run() throws IOException {
		catan4();
	}

	static Image backImage;
	static String menuPic;
	static String powerPic;
	static String logoPic;

	private static void catan4() throws IOException {

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
		
		Dice monopolyDice = new Dice(2, 6);

		//dice images
		Image d1 = ImageIO.read(new File("Images/one.png"));
		Image d2 = ImageIO.read(new File("Images/two.png"));
		Image d3 = ImageIO.read(new File("Images/three.png"));
		Image d4 = ImageIO.read(new File("Images/four.png"));
		Image d5 = ImageIO.read(new File("Images/five.png"));
		Image d6 = ImageIO.read(new File("Images/six.png"));
		Image die1 = d1.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		Image die2 = d2.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		Image die3 = d3.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		Image die4 = d4.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		Image die5 = d5.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		Image die6 = d6.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
		
		//dice 1 button
		JButton dice1 = new JButton();
		dice1.setPreferredSize(new Dimension(50,50));		
		dice1.setIcon(new ImageIcon(die1));
		dice1.setBorderPainted(false);
		dice1.setContentAreaFilled(false);
		dice1.setFocusPainted(false);
		dice1.setFocusable(false);
		//dice 2 button
		JButton dice2 = new JButton();
		dice2.setPreferredSize(new Dimension(50,50));
		dice2.setIcon(new ImageIcon(die1));
		dice2.setBorderPainted(false);
		dice2.setContentAreaFilled(false);
		dice2.setFocusPainted(false);
		dice2.setFocusable(false);
		//roll button
		JButton roll = new JButton();
		roll.setText("Roll Dice");
		roll.setFocusPainted(false);

		//place dice
			
		cons.anchor = GridBagConstraints.CENTER;
		cons.gridy = 1;
		cons.gridx = 1;
		background.add(dice1, cons);	
		
		cons.gridy = 1;
		cons.gridx = 2;
		background.add(dice2, cons);		
		
		cons.gridy = 2;
		cons.gridx = 1;
		cons.gridwidth = 2;
		background.add(roll, cons);
		
		cons.gridwidth = 1;

		//roll dice, add action listener for button		
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int pairDice[] = monopolyDice.rollAll();
				//update dice face
				//update die 1
				if (pairDice[0] == 1) {
					//update JButton
					dice1.setIcon(new ImageIcon(die1));
				} else if (pairDice[0] == 2) {
					dice1.setIcon(new ImageIcon(die2));
				}  else if (pairDice[0] == 3) {
					dice1.setIcon(new ImageIcon(die3));
				}  else if (pairDice[0] == 4) {
					dice1.setIcon(new ImageIcon(die4));
				}  else if (pairDice[0] == 5) {
					dice1.setIcon(new ImageIcon(die5));
				}  else  {
					dice1.setIcon(new ImageIcon(die6));
				}
				//update die 2
				if (pairDice[1] == 1) {
					//update JButton
					dice2.setIcon(new ImageIcon(die1));
				} else if (pairDice[1] == 2) {
					dice2.setIcon(new ImageIcon(die2));
				}  else if (pairDice[1] == 3) {
					dice2.setIcon(new ImageIcon(die3));
				}  else if (pairDice[1] == 4) {
					dice2.setIcon(new ImageIcon(die4));
				}  else if (pairDice[1] == 5) {
					dice2.setIcon(new ImageIcon(die5));
				}  else  {
					dice2.setIcon(new ImageIcon(die6));
				}
			}
		});

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
		cons.gridx = 4;
		cons.gridy = 0;
		cons.anchor = GridBagConstraints.FIRST_LINE_END;
		background.add(menu, cons);

		//chess Image read in
		BufferedImage catanIco = ImageIO.read(new File("Images/catanTemp2.png"));
		Image catanImage = catanIco.getScaledInstance(1200, 1000, Image.SCALE_SMOOTH);
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
		cons.gridx = 3;
		cons.gridy = 1;
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