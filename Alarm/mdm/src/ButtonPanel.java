import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * handles both buttons for adding alarms
 */

public class ButtonPanel extends JPanel implements ActionListener{
	
	private JPanel buttons;
	private MyAlarm alarm;
	
	//constructor
	public ButtonPanel(MyAlarm alarm){
		this.alarm = alarm;
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2));
		
		JButton alarmDelay = new JButton("Alarm");
		JButton alarmSet = new JButton("Timer");
		alarmDelay.setActionCommand("create set");
		alarmDelay.addActionListener(this);
		alarmSet.setActionCommand("create delay");
		alarmSet.addActionListener(this);
		
		buttons.add(alarmDelay);
		buttons.add(alarmSet);
		
	}
	
	//opens the "timer" or "Delay" panel
	public void openADD(MyAlarm alarm){
		AlarmDelayDesign add = new AlarmDelayDesign(alarm);
	}
	
	//opens the "set time alarm" panel
	public void openATD(MyAlarm alarm){
		AlarmTimeDesign atd = new AlarmTimeDesign(alarm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("create delay".equals(e.getActionCommand())){
			openADD(this.alarm);
		}
		else if("create set".equals(e.getActionCommand())){
			openATD(this.alarm);
		}
	}
	
	//initializes button
	public JPanel init(){
		return buttons;
	}
}
