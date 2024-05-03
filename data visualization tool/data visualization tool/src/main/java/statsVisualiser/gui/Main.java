package statsVisualiser.gui;

import java.awt.EventQueue;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final IDandPasswords idandPasswords = new IDandPasswords();
		LoginUI loginui = new LoginUI(idandPasswords.getLoginInfo());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashMap<String, String> loginfo = null;
					LoginUI frame = new LoginUI(idandPasswords.getLoginInfo());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
