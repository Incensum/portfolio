import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyAlarm {

	private AlarmTime delayTime;
	private AlarmTime snoozeAlarm;
	private ArrayList<AlarmTime> alarmList;
	private Calendar cal;
	private ArrayList<AlarmTime> activeAlarms = new ArrayList<AlarmTime>();
	private AlarmRingDesign ring;
	private XmlManager xmanager;
	Timer timer = new Timer(true);
	
	public MyAlarm()
	{
		try {
			xmanager = new XmlManager("Alarm.xml");
			initAlarms();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAlarm(int time, String name){
		//write to XML file(and add to list?  which would mean just using the other method below)
	}
	
	//method used for non-XML testing creating alarm
	public void setAlarm(AlarmTime alarm){
		//write to XML file
		xmanager.write(alarm);
		alarmList.add(alarm);
	}
	
	//method used for non-XML testing delay. FIX problem with having 60+ minutes
	public void setDelay(int delay, String message){
		cal.add(Calendar.MINUTE, delay);
		delayTime = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), message);

		System.out.println(delayTime.getHour());
		System.out.println(delayTime.getMinute());

		alarmList.add(delayTime);
		xmanager.write(delayTime);
	}
	
	//use at startup in main when retrieving alarm times after alarms are brought into program and added to list
	//might play them instead of that's what he wants
	public void deleteOldAlarms(){
		for(int i = 0; i < alarmList.size(); i++){
			AlarmTime current = alarmList.get(i);
			if(current.getYear() == cal.get(Calendar.YEAR) && current.getMonth() == cal.get(Calendar.MONTH)
					&& current.getDay() == cal.get(Calendar.DAY_OF_MONTH) && current.getHour() < cal.get(Calendar.HOUR_OF_DAY)){
				//delete alarm from XML
				xmanager.delete(current.toString());
			}
			else if(current.getYear() == cal.get(Calendar.YEAR) && current.getMonth() == cal.get(Calendar.MONTH)
					&& current.getDay() < cal.get(Calendar.DAY_OF_MONTH)){
				//delete alarm from XML
				xmanager.delete(current.toString());
			}
			else if(current.getYear() == cal.get(Calendar.YEAR) && current.getMonth() < cal.get(Calendar.MONTH)){
				//delete alarm from XML
				xmanager.delete(current.toString());
			}
			else if(current.getYear() < cal.get(Calendar.YEAR)){
				//delete alarm from XML
				xmanager.delete(current.toString());
			}
		}
	}
	
	//delete alarm
	public void deleteAlarm(AlarmTime alarm){
//		alarmList.remove(alarm);
//		activeAlarms.remove(alarm);
		xmanager.delete(alarm.toString());
		initAlarms();
	}
	
	//dismiss alarm
//<<<<<<< HEAD
//	public void dismissAlarm(AlarmTime alarmChoice){
//		alarmList.remove(alarmChoice);
//		activeAlarms.remove(alarmChoice);
//	}
//	
//	//snooze alarm
//	public void snoozeAlarm(AlarmTime alarmChoice){
//		activeAlarms.remove(alarmChoice);
//		if(cal.get(Calendar.HOUR_OF_DAY) == 23 && cal.get(Calendar.MINUTE) == 59){
//			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
//					0, 0, alarmChoice.message);
//		}
//		else if(cal.get(Calendar.MINUTE)== 59){
//			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
//				cal.get(Calendar.HOUR_OF_DAY) + 1, 0, alarmChoice.message);
//		}
//		else{
//			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
//					cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE) + 1, alarmChoice.message);
//		}
//		alarmList.remove(alarmChoice);
//		//snoozeAlarm.setInactive();
//		alarmList.add(snoozeAlarm);
//=======
	public void dismissAlarm(AlarmTime alarmChoice){
		AlarmTime a = alarmChoice;
		xmanager.delete(a.toString());
		initAlarms();
//		alarmList.remove(alarmChoice);
//		activeAlarms.remove(alarmChoice);
	}
	
	//snooze alarm
	public void snoozeAlarm(AlarmTime alarmChoice){
		AlarmTime selected = alarmChoice;
		//activeAlarms.remove(alarmChoice);
		if(cal.get(Calendar.HOUR_OF_DAY) == 23 && cal.get(Calendar.MINUTE) == 59){
			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
					0, 0, selected.getMessage());
		}
		else if(cal.get(Calendar.MINUTE)== 59){
			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
				cal.get(Calendar.HOUR_OF_DAY) + 1, 0, selected.getMessage());
		}
		else{
			snoozeAlarm = new AlarmTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 
					cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE) + 1, selected.getMessage());
		}
		xmanager.delete(selected.toString());
		xmanager.write(snoozeAlarm);
		initAlarms();
//		alarmList.remove(alarmChoice);
//		alarmList.add(snoozeAlarm);
//>>>>>>> a99f7d51c0440b02106dc3bed022add2ca306b75
	}
	
	//displays the active alarms(alarms that have popped up) method probably only good for command line testing
	public void displayActiveAlarms(){
		for(int i = 0; i < activeAlarms.size(); i++){
			System.out.println(i + ": " + activeAlarms.get(i).toString());
		}
	}
	
	//idk what to do with these three or if they're important
	public static void viewAlarms(){
		
	}
	
	public static String getTime(String name){
		return null;
	}
	
	public static String[] alarmList(){
		return null;
		
	}
	
	public void startTimer(){
		timer.scheduleAtFixedRate(new AlarmTimerTask(), 0, 5000);
	}
	
	//check times on alarms to play them
	public void checkTimes(){
		cal = Calendar.getInstance();
		//if(alarmList.size() != 0){
		for(int i = 0; i < alarmList.size(); i++){
			AlarmTime current = alarmList.get(i);
			if(current.getYear() == cal.get(Calendar.YEAR) && current.getMonth() == cal.get(Calendar.MONTH)
					&& current.getDay() == cal.get(Calendar.DAY_OF_MONTH) && current.getHour() == cal.get(Calendar.HOUR_OF_DAY)
					&& current.getMinute() <= cal.get(Calendar.MINUTE)){
				//display alarm / play sound
					//alarmList.get(i).setActive(true);
					current.setActive(true);
				//if(!alarmList.get(i).isActive){					//this can be removed if it needs to repeatedly go off

//					if(!(activeAlarms.contains(alarmList.get(i)))){
//						activeAlarms.add(alarmList.get(i));
//					}
					if(!(activeAlarms.contains(current))){
						activeAlarms.add(current);
					}
					
					//System.out.println(alarmList.get(i).getMinute());
					//System.out.println(current.getMinute());
					ring = new AlarmRingDesign(alarmList.get(i).getMessage(), this, alarmList.get(i));
					ring.init();
				
			}
			else{
				//do nothing
			}
		}
	//}
	}
	
	private void initAlarms()
	{
		alarmList = xmanager.read().getAlarms();
		for(AlarmTime a : alarmList)
		{
			if(a.isActive) activeAlarms.add(a);
		}
	}
	
	//needed class to make the timer for the alarm
	class AlarmTimerTask extends TimerTask{

		@Override
		public void run() {
			checkTimes();
		}
	}
}

