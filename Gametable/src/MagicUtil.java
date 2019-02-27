/*
 * Created By: Ben Roussin
 * Date Created: 11/1/18
 * 
 * Last Edited By: Ben Roussin
 * Date Edited: 11/16/18
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MagicUtil implements ActionListener {
	
	static JFrame f;
	
	private int counterP1 = 20;
	private int counterP2 = 20;

	private JLabel counterLabelP1;
	private JLabel counterLabelP2;
	private JLabel space;

	private JButton countUpButtonP1;
	private JButton countUp5ButtonP1;
	private JButton countUpButtonP2;
	private JButton countUp5ButtonP2;

	private JButton countDownButtonP1;
	private JButton countDown5ButtonP1;
	private JButton countDownButtonP2;
	private JButton countDown5ButtonP2;

	public JPanel createPanel() {
		JPanel magicPanel = new JPanel();
		magicPanel.setBackground(Color.BLACK);

		countUp5ButtonP1 = new JButton("+ 5");
		countUp5ButtonP1.addActionListener(this);
		magicPanel.add(countUp5ButtonP1);

		countUpButtonP1 = new JButton("+ 1");
		countUpButtonP1.addActionListener(this);
		magicPanel.add(countUpButtonP1);

		counterLabelP1 = new JLabel("" + counterP1);
		counterLabelP1.setForeground(Color.WHITE);
		magicPanel.add(counterLabelP1);

		countDownButtonP1 = new JButton("- 1");
		countDownButtonP1.addActionListener(this);
		magicPanel.add(countDownButtonP1);

		countDown5ButtonP1 = new JButton("- 5");
		countDown5ButtonP1.addActionListener(this);
		magicPanel.add(countDown5ButtonP1);

		space = new JLabel("  ");
		magicPanel.add(space);

		countUp5ButtonP2 = new JButton("+ 5");
		countUp5ButtonP2.addActionListener(this);
		magicPanel.add(countUp5ButtonP2);

		countUpButtonP2 = new JButton("+ 1");
		countUpButtonP2.addActionListener(this);
		magicPanel.add(countUpButtonP2);

		counterLabelP2 = new JLabel("" + counterP2);
		counterLabelP2.setForeground(Color.WHITE);
		magicPanel.add(counterLabelP2);

		countDownButtonP2 = new JButton("- 1");
		countDownButtonP2.addActionListener(this);
		magicPanel.add(countDownButtonP2);

		countDown5ButtonP2 = new JButton("- 5");
		countDown5ButtonP2.addActionListener(this);
		magicPanel.add(countDown5ButtonP2);

		return magicPanel;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == countUpButtonP1) {
			counterP1++;
			counterLabelP1.setText("" + counterP1);
		} else if (event.getSource() == countDownButtonP1) {
			counterP1--;
			;
			counterLabelP1.setText("" + counterP1);
		} else if (event.getSource() == countDown5ButtonP1) {
			counterP1 = counterP1 - 5;
			;
			counterLabelP1.setText("" + counterP1);
		} else if (event.getSource() == countUp5ButtonP1) {
			counterP1 = counterP1 + 5;
			;
			counterLabelP1.setText("" + counterP1);
		} else if (event.getSource() == countUpButtonP2) {
			counterP2++;
			counterLabelP2.setText("" + counterP2);
		} else if (event.getSource() == countDownButtonP2) {
			counterP2--;
			;
			counterLabelP2.setText("" + counterP2);
		} else if (event.getSource() == countDown5ButtonP2) {
			counterP2 = counterP2 - 5;
			;
			counterLabelP2.setText("" + counterP2);
		} else if (event.getSource() == countUp5ButtonP2) {
			counterP2 = counterP2 + 5;
			;
			counterLabelP2.setText("" + counterP2);
		}
	}
	
	public static void close() {
		f.dispose();
	}

	public static void main(String[] args) {
		f = new JFrame();
		f.setTitle("Magic Life");
		f.setSize(new Dimension(600, 40));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MagicUtil clickMe = new MagicUtil();
		JPanel magicPanel = clickMe.createPanel();

		Container contentPane = f.getContentPane();
		contentPane.add(magicPanel, BorderLayout.CENTER);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
		f.setUndecorated(true);
		f.setAlwaysOnTop(true);
		f.setVisible(true);
	}

}