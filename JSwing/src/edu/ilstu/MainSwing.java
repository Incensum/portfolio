package edu.ilstu;


/*
 * @author Matthew Caparoon
 */

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
@SuppressWarnings("serial")
public class MainSwing extends JPanel implements ActionListener{
	
	//Text Field setup
	JTextField meters = new JTextField("0"), cm = new JTextField("0"), km = new JTextField("0"),
			feet = new JTextField("0"), inch = new JTextField("0"), mile = new JTextField("0"),
			gram = new JTextField("0"), kgram = new JTextField("0"), oz = new JTextField("0"),
			lb = new JTextField("0"), iTon = new JTextField("0"), mTon = new JTextField("0");
	
	double massTemp = 0;
	double disTemp = 0;
	
	Calculation calc = new Calculation();
	
    public MainSwing() {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
         
        JComponent panel1 = makeMetricPanel();
        tabbedPane.addTab("Distance", panel1);
         
        JComponent panel2 = makeMassPanel();
        tabbedPane.add("Mass", panel2);

        add(tabbedPane);
         
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeMassPanel(){
    	JPanel panel = new JPanel(false);
        JLabel filler = new JLabel();
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(6, 2));
  	  	panel.add(new JLabel("Gram"));
	  	panel.add(new JLabel("Kilogram"));
	 	panel.add(gram);
	 	panel.add(kgram);
	 	panel.add(new JLabel("Ounces"));
		panel.add(new JLabel("Pounds"));
		panel.add(oz);
		panel.add(lb);
		panel.add(new JLabel("Imperial Ton"));
	 	panel.add(new JLabel("Metric Ton"));
	  	panel.add(iTon);
	  	panel.add(mTon);
	  	
        gram.addActionListener(this);
        kgram.addActionListener(this);
        oz.addActionListener(this);
        lb.addActionListener(this);
        iTon.addActionListener(this);
        mTon.addActionListener(this);
		return panel;
    }
     
    protected JComponent makeMetricPanel(){
    	JPanel panel = new JPanel(false);
        JLabel filler = new JLabel();
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Meters"));
        panel.add(new JLabel("Centimeters"));
        panel.add(meters);
        panel.add(cm);
        panel.add(new JLabel("Kilometers"));
        panel.add(new JLabel("Feet"));
        panel.add(km);
        panel.add(feet);
        panel.add(new JLabel("Inches"));
        panel.add(new JLabel("Miles"));
        panel.add(inch);
        panel.add(mile);
        
        meters.addActionListener(this);
        cm.addActionListener(this);
        km.addActionListener(this);
        feet.addActionListener(this);
        inch.addActionListener(this);
        mile.addActionListener(this);
		return panel;
    }
    
    //creates the final GUI
    public static void createAndShowGUI() {
        //Create the window.
        JFrame frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new MainSwing(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e){
		
		//Distance values
		
		if(e.getSource()==meters){
			try{
				disTemp = Double.parseDouble(meters.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			meters.setText(String.valueOf(disTemp));
			km.setText(String.valueOf(calc.metersToKm(disTemp)));
			disTemp = calc.metersToKm(disTemp);
			mile.setText(String.valueOf(calc.kmToMiles(disTemp)));
			disTemp = calc.kmToMiles(disTemp);
			feet.setText(String.valueOf(calc.milesToFeet(disTemp)));
			disTemp = calc.milesToFeet(disTemp);
			inch.setText(String.valueOf(calc.feetToInches(disTemp)));
			disTemp = calc.feetToInches(disTemp);
			cm.setText(String.valueOf(calc.inchesToCm(disTemp)));
			disTemp = 0;
		}
			
		else if(e.getSource()==cm){
			try{
				disTemp = Double.parseDouble(cm.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	cm.setText(String.valueOf(disTemp));
        	meters.setText(String.valueOf(calc.cmToMeters(disTemp)));
        	disTemp = calc.cmToMeters(disTemp);
        	km.setText(String.valueOf(calc.metersToKm(disTemp)));
			disTemp = calc.metersToKm(disTemp);
			mile.setText(String.valueOf(calc.kmToMiles(disTemp)));
			disTemp = calc.kmToMiles(disTemp);
			feet.setText(String.valueOf(calc.milesToFeet(disTemp)));
			disTemp = calc.milesToFeet(disTemp);
			inch.setText(String.valueOf(calc.feetToInches(disTemp)));
			disTemp = 0;
		}
        	
		else if(e.getSource()==km){
			try{
				disTemp = Double.parseDouble(km.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			km.setText(String.valueOf(disTemp));
        	mile.setText(String.valueOf(calc.kmToMiles(disTemp)));
			disTemp = calc.kmToMiles(disTemp);
			feet.setText(String.valueOf(calc.milesToFeet(disTemp)));
			disTemp = calc.milesToFeet(disTemp);
			inch.setText(String.valueOf(calc.feetToInches(disTemp)));
			disTemp = calc.feetToInches(disTemp);
			cm.setText(String.valueOf(calc.inchesToCm(disTemp)));
			disTemp = calc.inchesToCm(disTemp);
			meters.setText(String.valueOf(calc.cmToMeters(disTemp)));
			disTemp = 0;
		}
        
		else if(e.getSource()==feet){
			try{
				disTemp = Double.parseDouble(feet.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			feet.setText(String.valueOf(disTemp));
        	inch.setText(String.valueOf(calc.feetToInches(disTemp)));
			disTemp = calc.feetToInches(disTemp);
			cm.setText(String.valueOf(calc.inchesToCm(disTemp)));
			disTemp = calc.inchesToCm(disTemp);
			meters.setText(String.valueOf(calc.cmToMeters(disTemp)));
			disTemp = calc.cmToMeters(disTemp);
        	km.setText(String.valueOf(calc.metersToKm(disTemp)));
			disTemp = calc.metersToKm(disTemp);
			mile.setText(String.valueOf(calc.kmToMiles(disTemp)));
			disTemp = 0;
		}
        
		else if(e.getSource()==inch){
			try{
				disTemp = Double.parseDouble(inch.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	inch.setText(String.valueOf(disTemp));
        	cm.setText(String.valueOf(calc.inchesToCm(disTemp)));
			disTemp = calc.inchesToCm(disTemp);
			meters.setText(String.valueOf(calc.cmToMeters(disTemp)));
			disTemp = calc.cmToMeters(disTemp);
        	km.setText(String.valueOf(calc.metersToKm(disTemp)));
			disTemp = calc.metersToKm(disTemp);
			mile.setText(String.valueOf(calc.kmToMiles(disTemp)));
			disTemp = calc.kmToMiles(disTemp);
			feet.setText(String.valueOf(calc.milesToFeet(disTemp)));
			disTemp = 0;
		}
        
		else if(e.getSource()==mile){
			try{
				disTemp = Double.parseDouble(mile.getText());
			}
			catch(NumberFormatException nfe){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	mile.setText(String.valueOf(disTemp));
        	feet.setText(String.valueOf(calc.milesToFeet(disTemp)));
			disTemp = calc.milesToFeet(disTemp);
			inch.setText(String.valueOf(calc.feetToInches(disTemp)));
			disTemp = calc.feetToInches(disTemp);
			cm.setText(String.valueOf(calc.inchesToCm(disTemp)));
			disTemp = calc.inchesToCm(disTemp);
			meters.setText(String.valueOf(calc.cmToMeters(disTemp)));
			disTemp = calc.cmToMeters(disTemp);
        	km.setText(String.valueOf(calc.metersToKm(disTemp)));
        	disTemp = 0;
		}
        
		//Mass values
		
		else if(e.getSource()==gram){
        	try{
				massTemp = Double.parseDouble(gram.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	gram.setText(String.valueOf(massTemp));
        	kgram.setText(String.valueOf(calc.gramToKg(massTemp)));
        	massTemp = calc.gramToKg(massTemp);
        	oz.setText(String.valueOf(calc.kgToOz(massTemp)));
        	massTemp = calc.kgToOz(massTemp);
        	lb.setText(String.valueOf(calc.ozToLb(massTemp)));
        	massTemp = calc.ozToLb(massTemp);
        	iTon.setText(String.valueOf(calc.lbToITon(massTemp)));
        	massTemp = calc.lbToITon(massTemp);
        	mTon.setText(String.valueOf(calc.iTonToMTon(massTemp)));
        	massTemp = 0;
		}
        
		else if(e.getSource()==kgram){
        	try{
				massTemp = Double.parseDouble(kgram.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	kgram.setText(String.valueOf(massTemp));
        	oz.setText(String.valueOf(calc.kgToOz(massTemp)));
        	massTemp = calc.kgToOz(massTemp);
        	lb.setText(String.valueOf(calc.ozToLb(massTemp)));
        	massTemp = calc.ozToLb(massTemp);
        	iTon.setText(String.valueOf(calc.lbToITon(massTemp)));
        	massTemp = calc.lbToITon(massTemp);
        	mTon.setText(String.valueOf(calc.iTonToMTon(massTemp)));
        	massTemp = calc.iTonToMTon(massTemp);
        	gram.setText(String.valueOf(calc.mTonToGram(massTemp)));
        	massTemp = 0;
		}
        
		else if(e.getSource()==oz){
        	try{
				massTemp = Double.parseDouble(oz.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        	oz.setText(String.valueOf(massTemp));
        	lb.setText(String.valueOf(calc.ozToLb(massTemp)));
        	massTemp = calc.ozToLb(massTemp);
        	iTon.setText(String.valueOf(calc.lbToITon(massTemp)));
        	massTemp = calc.lbToITon(massTemp);
        	mTon.setText(String.valueOf(calc.iTonToMTon(massTemp)));
        	massTemp = calc.iTonToMTon(massTemp);
        	gram.setText(String.valueOf(calc.mTonToGram(massTemp)));
        	massTemp = calc.mTonToGram(massTemp);
        	kgram.setText(String.valueOf(calc.gramToKg(massTemp)));
        	massTemp = 0;
		}
        
		else if(e.getSource()==lb){
			try{
				massTemp = Double.parseDouble(lb.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			lb.setText(String.valueOf(massTemp));
			iTon.setText(String.valueOf(calc.lbToITon(massTemp)));
        	massTemp = calc.lbToITon(massTemp);
        	mTon.setText(String.valueOf(calc.iTonToMTon(massTemp)));
        	massTemp = calc.iTonToMTon(massTemp);
        	gram.setText(String.valueOf(calc.mTonToGram(massTemp)));
        	massTemp = calc.mTonToGram(massTemp);
        	kgram.setText(String.valueOf(calc.gramToKg(massTemp)));
        	massTemp = calc.gramToKg(massTemp);
        	oz.setText(String.valueOf(calc.kgToOz(massTemp)));
        	massTemp = 0;
		}
        
		else if(e.getSource()==iTon){
			try{
				massTemp = Double.parseDouble(iTon.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			iTon.setText(String.valueOf(massTemp));
			mTon.setText(String.valueOf(calc.iTonToMTon(massTemp)));
        	massTemp = calc.iTonToMTon(massTemp);
        	gram.setText(String.valueOf(calc.mTonToGram(massTemp)));
        	massTemp = calc.mTonToGram(massTemp);
        	kgram.setText(String.valueOf(calc.gramToKg(massTemp)));
        	massTemp = calc.gramToKg(massTemp);
        	oz.setText(String.valueOf(calc.kgToOz(massTemp)));
        	massTemp = calc.kgToOz(massTemp);
        	lb.setText(String.valueOf(calc.ozToLb(massTemp)));
        	massTemp = 0;
		}
        
		else if(e.getSource()==mTon){
			try{
				massTemp = Double.parseDouble(mTon.getText());
        	}
			catch(NumberFormatException nfe2){
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "You must input numbers only", "Dialog", JOptionPane.ERROR_MESSAGE);
			}
			mTon.setText(String.valueOf(massTemp));
			gram.setText(String.valueOf(calc.mTonToGram(massTemp)));
        	massTemp = calc.mTonToGram(massTemp);
        	kgram.setText(String.valueOf(calc.gramToKg(massTemp)));
        	massTemp = calc.gramToKg(massTemp);
        	oz.setText(String.valueOf(calc.kgToOz(massTemp)));
        	massTemp = calc.kgToOz(massTemp);
        	lb.setText(String.valueOf(calc.ozToLb(massTemp)));
        	massTemp = calc.ozToLb(massTemp);
        	iTon.setText(String.valueOf(calc.lbToITon(massTemp)));
        	massTemp = 0;
		}
	}
}