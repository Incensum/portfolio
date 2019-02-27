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

public class settingsListener implements ActionListener{

	ButtonFunctions functions = new ButtonFunctions();
	
	UIdriver ui = new UIdriver();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int counter = 0; 
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		if(name.equalsIgnoreCase("b1")) {
			ui.backgroundImage = 0;
			functions.closeFrame();
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("b2")) {
			ui.backgroundImage = 1;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("b3")) {
			ui.backgroundImage = 2;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("b4")) {
			ui.backgroundImage = 3;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("b5")) {
			ui.backgroundImage = 4;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("b6")) {
			ui.backgroundImage = 5;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t1")) {
			ui.themeImage = 0;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t2")) {
			ui.themeImage = 1;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t3")) {
			ui.themeImage = 2;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t4")) {
			ui.themeImage = 3;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t5")) {
			ui.themeImage = 4;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("t6")) {
			ui.themeImage = 5;
			functions.closeFrame();;
			try {
				ui.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(name.equalsIgnoreCase("okay")) {
			functions.closeFrame();
		}
	}
}

