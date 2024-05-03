package statsVisualiser.gui;

import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	IDandPasswords(){
		logininfo.put("hermoine", "timeturner");
		logininfo.put("sirius", "blackdog22");
		logininfo.put("remus", "messrs_moony");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}

}
