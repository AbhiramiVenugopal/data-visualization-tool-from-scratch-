package statsVisualiser.gui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class popupMessages {
public void countryNotAvailable() {
	 JFrame parent = new JFrame();

	    JOptionPane.showMessageDialog(parent, "Sorry cannot fetch data for this country, Please choose another country");
}
public void yearNotAvailable(Object year) {
	 JFrame parent = new JFrame();

	    JOptionPane.showMessageDialog(parent, "Analysis not available for the selected year "+year+", Please choose another year");
}
public void yearNotAvailable() {
	 JFrame parent = new JFrame();

	    JOptionPane.showMessageDialog(parent, "Can't fetch data as the start year is after the end year. Please choose another year");
}
public void noData() {
	 JFrame parent = new JFrame();

	    JOptionPane.showMessageDialog(parent, "No data is available for this analysis. Please try different country or years or analysis");
}
}
