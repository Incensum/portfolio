
public class GUITest {

	public static void main(String[] args) {
		MyAlarm alarm = new MyAlarm();
		alarm.startTimer();
		AlarmSystemDesign asd = new AlarmSystemDesign(alarm);
	}

}
