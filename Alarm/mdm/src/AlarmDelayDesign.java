import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * the "timer" alarm
 */

public class AlarmDelayDesign {
	
//	private JFrame frame = new JFrame();
//	private int hours = 0;
	private int minutes = 0;
	private String name = "";
	private MyAlarm alarm;
	
	//constructor
	public AlarmDelayDesign(MyAlarm alarm){
		this.alarm = alarm;
//		JTextField hours = new JTextField(5);
	    JTextField name = new JTextField(5);
	    JTextField minutes = new JTextField(5);

	    JPanel myPanel = new JPanel();
	    myPanel.setSize(200, 480);
	    myPanel.add(new JLabel("Label:"));
	    myPanel.add(name);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Minutes:"));
	    myPanel.add(minutes);


	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	    		"Please enter the length of the timer",
	    		JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	       this.name = name.getText();
	       this.minutes = Integer.valueOf(minutes.getText());
	       
	       createAlarm(this.name, this.minutes, alarm);
	    }
	}
	
	//alarm creation method
	public void createAlarm(String label, int minutes, MyAlarm alarm){	
		alarm.setDelay(minutes, label);
	}
}
