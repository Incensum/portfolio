import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class digitalClock extends JLabel implements ActionListener{
	JLabel clock = new JLabel();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Timer timer;
	public digitalClock() {
		super();
		clock.setText((sdf.format(new Date(System.currentTimeMillis()))));
		clock.setFont(new Font("Dialog", Font.PLAIN, 24));
		timer = new Timer(500, this);
		timer.setRepeats(true);
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(timer)) {
			clock.setText(sdf.format(new Date(System.currentTimeMillis())));
		}
	}
}
