import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElement; 

public class AlarmBackup {
	private int id;
	private String message;
	private String time;
	
	public AlarmBackup(String time)
	{
		this.time = time;
	}
	
	@XmlElement
	public String getTime()
	{
		return time;
	}
	
	@XmlAttribute
	public int getId()
	{
		return id;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String m)
	{
		message = m;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
}
