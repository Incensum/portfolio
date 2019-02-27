import javax.swing.JFrame;

/*
 * Created By: Ben Abrams
 * Date Created: 9/21/18
 * 
 * Last Edited By: Ben Abrams
 * Date Edited: 9/24/18
 */

public class ButtonFunctions {
	
	public static JFrame currentFrame = new JFrame();
	
	public static JFrame settingsFrame = new JFrame();
			
	//will exit frame when new frames open
	public static void closeFrame() {
		JFrame frame = getFrame();
		frame.dispose();
	}
	
	//sets the current frame, so it can be disposed of later
	public static void setFrame(JFrame frame){
		currentFrame = frame;
	}
	
	//gets the frame name for closeFrame()
	public static JFrame getFrame(){
		return currentFrame;
	}
	
	public static void closeSettingsFrame() {
		JFrame frame = getSettingsFrame();
		frame.dispose();
	}
	
	public static void setSettingsFrame(JFrame frame) {
		settingsFrame = frame;
	}
	
	public static JFrame getSettingsFrame() {
		return settingsFrame;
	}
	
}
