/*
 * This is the proxy pattern class. It checks if the selected country and year 
 * is available for data fetching or not
 */
package statsVisualiser.gui;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class RestrictedCountriesYears implements Restrictions {
	
	popupMessages p = new popupMessages();
 
	public static boolean isbanned;
	
		public void checkCountry(String country) {
			try {
				if(!isbanned(country)) {
					System.out.println("country okay");
					isbanned =false;
					
				}
				else {
					
					p.countryNotAvailable();
					System.out.println("Sorry cannot fetch data for this country");
				isbanned=true;}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public boolean isbanned(String country) throws IOException {
			BufferedReader bufReader = new BufferedReader(new FileReader("restricted_countries.txt"));
			ArrayList<String> restrictedCountries = new ArrayList<String>();

		    String line = bufReader.readLine();
		    while (line != null) {
		    	restrictedCountries.add(line);
		      line = bufReader.readLine();
		    }

		    bufReader.close();


			if(restrictedCountries.contains(country)) return true;
			else return false;
		}
		public void checkYears(Object fromYear, Object toYear) {
			if(!(isbannedYear(fromYear,toYear))){
				System.out.println("year okay");
				isbanned=false;
			}
			else {System.out.println("cannot Proceed");
			isbanned = true;
			}
			
		}
		public boolean isbannedYear(Object fromYear, Object toYear) {
			
			ArrayList<Object> restrictedYears = new ArrayList<Object>();
			restrictedYears.add("2020");
			restrictedYears.add("2021");
			restrictedYears.add("2022");
			if(restrictedYears.contains(fromYear)) {
				p.yearNotAvailable(fromYear);
				System.out.println("Analysis not available for the selected year "+fromYear);
				return true;
			}
			 if(restrictedYears.contains(toYear)) {
				 p.yearNotAvailable(toYear);
				System.out.println("Analysis not available for the year "+ toYear);
				return true;
			}
			return false;
			
			
		}
		

}
