package Strategy;

/*
 * 2 options to display will be there 
 * DisplayOnScreen or NoDisplay
 */
public interface IDisplay {
	/*
	 * this method sends to the jfree charts whether 
	 * or not the the chart should be displayed on screen 
	 * so 2 pie charts can't come onto the screen (maybe we can accomodate singleton pattern)
	 */
	void displayOrNot();
	
	//iterate through all the 5 graphs and see if they are selected. 
	//if selected call the displayonscreen class 
	//if not selected call the notdisplay class 
}
