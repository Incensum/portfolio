import javax.xml.bind.annotation.XmlElement;
public class AlarmTime {
	
	public boolean isActive = false;
	
	private int year, month, day, hour, minute;
	private String message;
	
	public AlarmTime()
	{
		
	}
	
	public AlarmTime(int year, int month, int day, int hour, int minute, String message){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.message = message;
	}
	
	public AlarmTime(int year, int month, int day, int hour, int minute){
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.message = "";
	}
	
	@XmlElement(name="year")
	public int getYear() { return year;}
	
	@XmlElement(name="month")
	public int getMonth() { return month;}
	
	@XmlElement(name="day")
	public int getDay() { return day;}
	
	@XmlElement(name="hour")
	public int getHour() { return hour;}
	
	@XmlElement(name="minute")
	public int getMinute() { return minute;}
	
	@XmlElement(name="message")
	public String getMessage(){ return message;}
	
	public void setYear(int y) { year = y;}
	public void setMonth(int m) { month = m;}
	public void setDay(int d) { day = d;}
	public void setHour(int h) { hour = h;}
	public void setMinute(int m) { minute = m;}
	public void setMessage(String m) { message = m;}
	public void setActive(boolean a) { isActive =a;}
	
	public String toString()
	{
		return year + "/" + month + "/" + day + " " + hour + ":" + minute + ": " + message;
	}
	
	public void setInactive(){
		this.isActive = false;
	}

}


