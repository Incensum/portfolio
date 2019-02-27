import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Ben Roussin

public class timerClass implements ActionListener
{
	
   // private JFrame frame;
   // private JPanel panel;

    private JLabel timeP1 = new JLabel();
    private JLabel timeP2 = new JLabel();
    private JLabel timeDelay = new JLabel();

    private JButton startBtn = new JButton("Run");
    private JButton pauseBtn = new JButton("Pause");
    private JButton resetBtn = new JButton("Reset");

    private CountTimer timer;
    
    private int gameLength = 3600;
    private int delayTime = 5;
    
    
    public timerClass()
    {
        GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0,3));
        timeP1.setBorder(BorderFactory.createRaisedBevelBorder());
        timeP2.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(timeP1);
        panel.add(timeDelay);
        panel.add(timeP2);

        startBtn.addActionListener(this);
        pauseBtn.addActionListener(this);
        resetBtn.addActionListener(this);


        panel.add(pauseBtn);
        panel.add(startBtn);
        panel.add(resetBtn);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/6-frame.getSize().width/6, dim.height/2-frame.getSize().height/2);
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        timer = new CountTimer();

    }

    private void setTimerText(int sTimeP1, int sTimeP2)
    {
        timeP1.setText(TimeFormat(sTimeP1));
        timeP2.setText(TimeFormat(sTimeP2));
    }
    
    private void setDelayText(int delayTime, String turn)
    {
        timeDelay.setText(turn + " " + delayTime);
    }

    private void setDelayText(String turn)
    {
        timeDelay.setText(turn);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton) e.getSource();

        if (btn.equals(startBtn))   { timer.start(); }
        else if (btn.equals(pauseBtn))   { timer.pause(); }
        else if (btn.equals(resetBtn))   { timer.reset(); }
    }


    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
             public void run()
             {
               new timerClass();
             }
          });

    }

    private class CountTimer implements ActionListener
    {
        private static final int ONE_SECOND = 1000;
        private int countP1 = 0;
        private int countP2 = 0;
        private int delay = delayTime;
        private String turn = "p1";
        private String isTimerActive = "none";
        private Timer tmrP1 = new Timer(ONE_SECOND, this);
        private Timer tmrP2 = new Timer(ONE_SECOND, this);
        private Timer tmrDelay = new Timer(ONE_SECOND, this);
        

        public CountTimer()
        {
            countP1 = 0;
            countP2 = 0;
            setTimerText(countP1, countP2);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (isTimerActive.equals("p1") && turn.equals("p1"))
            {
                countP1++;
                setTimerText(countP1, countP2);
            }
            else if (isTimerActive.equals("p2") && turn.equals("p2"))
            {
                countP2++;
                setTimerText(countP1, countP2);
            }
            else if (isTimerActive.equals("delay") && turn.equals("p1"))
            {
            	if(delay > 0)
            	{
            		delay--;
            		setDelayText(delay + 1, turn);
            	}
            	else if (delay == 0)
            	{
            		delay = delayTime;
            		isTimerActive ="p1";
            		tmrDelay.stop();
            		setDelayText(turn);
            		tmrP1.start();
            	}
            }
            else if (isTimerActive.equals("delay") && turn.equals("p2"))
            {
            	if(delay > 0)
            	{
            		delay--;
            		setDelayText(delay + 1, turn);
            	}
            	else if (delay == 0)
            	{
            		delay = delayTime;
            		isTimerActive ="p2";
            		tmrDelay.stop();
            		setDelayText(turn);
            		tmrP2.start();
            	}
            }
        }

        public void start()
        {
        	if(isTimerActive.equals("p1") && turn.equals("p1"))
        	{
        		tmrP1.stop();
        		isTimerActive = "delay";
        		turn = "p2";
        		tmrDelay.start();
        	}
        	else if(isTimerActive.equals("p2") && turn.equals("p2"))
        	{
        		tmrP2.stop();
        		isTimerActive = "delay";
        		turn = "p1";
            	tmrDelay.start();
        	}
        	else if(isTimerActive.equals("none") && turn.equals("p1"))
            {
        		delay = delayTime;
                isTimerActive = "delay";
                tmrDelay.start();
            }
        	else if(isTimerActive.equals("none") && turn.equals("p2"))
            {
        		delay = delayTime;
                isTimerActive = "delay";
                tmrDelay.start();
            }
        }

        public void pause()
        {
        	tmrP1.stop();
            tmrP2.stop();
            tmrDelay.stop();
            isTimerActive = "none";
        }

        public void reset()
        {
        	tmrP1.stop();
            tmrP2.stop();
            tmrDelay.stop();
        	countP1 = 0;
            countP2 = 0;
            delay = delayTime;
            turn = "p1";
            isTimerActive = "none";
            setTimerText(countP1, countP2);
            timeDelay.setText("");
        }
    }

    private String TimeFormat(int count)
    {
    	count = gameLength - count;
        int hours = count / 3600;
        int minutes = (count-(hours*3600))/60;
        int seconds = count-((minutes*60) + (hours * 3600));
        
        if((hours == 0 && minutes == 0 && seconds == 0) || seconds < 0)
        {
        	return "Out of Time";
        }
        else
        {
        	return String.format("%01d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
        }
    }
}
