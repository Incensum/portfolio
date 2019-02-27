import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Created By: Ben Abrams
 * Date Created: 9/21/18
 * 
 * Last Edited By: Ben Abrams
 * Date Edited: 9/24/18
 */

public class ButtonListener implements ActionListener{

	ButtonFunctions functions = new ButtonFunctions();
	@Override
	public void actionPerformed(ActionEvent e) {
		int counter = 0; 
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		//exits app and turns off console
		if(name.equalsIgnoreCase("exit")) {

			//Turns off console
			/*Runtime runtime = Runtime.getRuntime();
				try {
					Process proc = runtime.exec("shutdown -s -t 0");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} */

			System.exit(0);
		}
		//will enter developer mode
		if(name.equalsIgnoreCase("devMode")) {
			counter++;
			if(counter == 10) {

			}
		}
		if(name.equalsIgnoreCase("chess")){
			chessFrame chessFrame = new chessFrame();
			try{
				functions.closeFrame();
				chessFrame.run();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("poker")) {
			pokerFrame pokerFrame = new pokerFrame();
			try {
				functions.closeFrame();
				pokerFrame.run();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("checkers")) {
			checkersFrame checkersFrame = new checkersFrame();
			try {
				functions.closeFrame();
				checkersFrame.run();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("solitaire")) {
			SolitaireFrame solitaire = new SolitaireFrame();
			try {
				functions.closeFrame();
				solitaire.run();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}

		if(name.equalsIgnoreCase("monopoly")) {
			monopolyFrame monopoly = new monopolyFrame();
			try {
				functions.closeFrame();
				monopoly.run();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("catan")) {
			catanFrame catan = new catanFrame();
			try {
				functions.closeFrame();
				catan.run();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("yugioh")){
			yugiohFrame yugioh = new yugiohFrame();
			try {
				functions.closeFrame();
				yugioh.run();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("magic")) {
			MagicFrame magic = new MagicFrame();
			try {
				functions.closeFrame();
				magic.run();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("yahtzee")){
			yahtzee yahtzee = new yahtzee();
		}
		if(name.equalsIgnoreCase("farkle")) {

		}
		if(name.equalsIgnoreCase("menu")) {
			UIdriver menu = new UIdriver();
			try {
				if(functions.currentFrame.getName().equals("magic")) {
					MagicUtil.close();
				}
				functions.closeFrame();
				menu.main(null);
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("settings")){
			settingsFrame settings = new settingsFrame();
			try {
				settings.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("credits")) {
			credits cred = new credits();
			try {
				cred.run();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("okay")) {
			functions.closeSettingsFrame();
		}
		if(name.equalsIgnoreCase("timer")) {
			timerClass timer = new timerClass();
		}
	}
}
