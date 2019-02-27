import java.awt.GridLayout;

import javax.swing.JFrame;

/*
 * The actual base layout. The exterior panel.
 * 
 */

public class AlarmSystemDesign {
	private JFrame frame;
	private MyAlarm alarm;
	
	//constructor
	public AlarmSystemDesign(MyAlarm alarm){
		this.alarm = alarm;
		ButtonPanel button = new ButtonPanel(alarm);
		
		frame = new JFrame("Set an Alarm");
		frame.getContentPane().add(button.init());
		frame.setSize(480, 800);
		frame.setVisible(true);
	}
	
	//initialization method
	public JFrame init(){
		return frame;
	}
}
