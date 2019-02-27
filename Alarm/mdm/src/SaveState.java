import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;

@XmlRootElement(name="SaveState")
public class SaveState {
	
	
	private ArrayList<AlarmTime> alarms;
	
	public SaveState()
	{
		alarms = new ArrayList<AlarmTime>();
	}
	
	public ArrayList<AlarmTime> getAlarms()
	{
		return alarms;
	}
	
	@XmlElementWrapper(name="alarms")
	@XmlElement(name="alarm")
	public void setAlarms(ArrayList<AlarmTime> alarms)
	{
		this.alarms = alarms;
	}
	
	public void deleteAlarm(String alarmString)
	{
		Iterator<AlarmTime> iter = alarms.iterator();
		while(iter.hasNext())
		{
			AlarmTime a = iter.next();
			if(a.toString().equals(alarmString))
				iter.remove();
		}
	}
	
	public void addAlarm(AlarmTime a)
	{
		alarms.add(a);
	}
}
