import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * The "set time" alarm.
 */

public class AlarmTimeDesign {

	String name = "";
	int day;
	int month;
	int year;
	int hours;
	int minutes;
	MyAlarm alarm;
	
	
	//constructor
	public AlarmTimeDesign(MyAlarm alarm){
		this.alarm = alarm;
		JTextField day = new JTextField(5);
	    JTextField name = new JTextField(5);
	    JTextField month = new JTextField(5);
	    JTextField year = new JTextField(5);
	    JTextField hours = new JTextField(5);
	    JTextField minutes = new JTextField(5);

	    JPanel myPanel = new JPanel();
	    myPanel.setLayout(new GridLayout(3, 4));
	    myPanel.add(new JLabel("Label:"));
	    myPanel.add(name);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Day: (example: 01)"));
	    myPanel.add(day);
	    
	    myPanel.add(new JLabel("Month: (example: 01)"));
	    myPanel.add(month);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(new JLabel("Year: (example: 2000)"));
	    myPanel.add(year);
	    
	    myPanel.add(new JLabel("Hours:"));
	    myPanel.add(hours);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(new JLabel("Minutes:"));
	    myPanel.add(minutes);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	    		"Please enter year, month, day and time for your alarm",
	    		JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	       this.name = name.getText();
	       this.day = Integer.valueOf(day.getText());
	       this.month = Integer.valueOf(month.getText());
	       this.year = Integer.valueOf(year.getText());
	       this.hours = Integer.valueOf(hours.getText());
	       this.minutes = Integer.valueOf(minutes.getText());
	       
	       
	       createAlarm(this.year, this.month, this.day, this.hours, this.minutes, this.name);
	    }
		
	}
	
	//alarm creation method
	public void createAlarm(int year, int month, int day, int hour, int minute, String label){	
		AlarmTime almt = new AlarmTime(year, month, day, hour, minute, label);
		alarm.setAlarm(almt);
	}

}
