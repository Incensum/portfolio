import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * class that directly manages how to deal with the end of an alarm. popup included
 * 
 */

public class AlarmRingDesign {

	JFrame frame = new JFrame();
	MyAlarm alarm = new MyAlarm();
	AlarmTime time;
	//constructor
	public AlarmRingDesign(String message, MyAlarm alarm, AlarmTime time){
		this.alarm = alarm;
		this.time = time;
//		JTextField time = new JTextField(5);
//	    JButton name = new JButton();
//
//	    JPanel myPanel = new JPanel();
//	    myPanel.setSize(200, 480);
//	    myPanel.add(new JLabel("Label:"));
//	    myPanel.add(name);
//	    myPanel.add(Box.createVerticalStrut(15)); // a spacer
//	    myPanel.add(new JLabel("Minutes:"));
//	    myPanel.add(time);
//
//	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
//	    		"Please enter the length of the timer",
//	    		JOptionPane.OK_CANCEL_OPTION);
//	    if (result == JOptionPane.OK_OPTION) {
//	      
//	    }
	    
	    Object[] options = {"Snooze",
                "End"};
	    int result = JOptionPane.showOptionDialog(frame,
	    		message,
				null,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				options,
				options[1]);
	    
	    if (result == JOptionPane.YES_OPTION){
	    	alarm.snoozeAlarm(time);
	    }
	    else if (result == JOptionPane.NO_OPTION){
	    	alarm.dismissAlarm(time);
	    }
	}
	
	//deletes the alarm after use. Should be a button.
	public void deleteAlarm(){
		
	}
	
	//"snoozes" the alarm 1m (makes new one, deletes old one)
	public void snooze(){
		
	}
	
	public JFrame init(){
		return frame;
	}
}
