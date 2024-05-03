package AnalysisTypes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Analysis7 {
	public void analyze(String country, String code, Object fromYear, Object toYear) {
		// TODO Auto-generated method stub
		String gov_exp_edu_gdp = "SE.XPD.TOTL.GD.ZS";
		
		String urlString1 = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/"+gov_exp_edu_gdp+"?date="+fromYear+":"+toYear+"&format=json", code);
		
		System.out.println(urlString1);
		
		float gdp = 0;
		float gdpAvg = 0;
		
		float i=(float) 0.0;
		ArrayList<Float> g = new ArrayList<Float>();
		try {
			URL url1 = new URL(urlString1);
			
			HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
			conn1.setRequestMethod("GET");
			conn1.connect();
			
		
			int responsecode1 = conn1.getResponseCode();
			if (responsecode1 == 200) {
				String inline1 = "";
				Scanner scann1 = new Scanner(url1.openStream());
				while (scann1.hasNext()) {
					inline1 += scann1.nextLine();
				}
				scann1.close();
				JsonArray jsonArray1 = new JsonParser().parse(inline1).getAsJsonArray();
				
				
				int size = jsonArray1.size();
				int sizeOfResults = jsonArray1.get(1).getAsJsonArray().size();
				int year;
			
				for (int i1 = 0; i1 < sizeOfResults; i1++) {
				
					year = jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("date").getAsInt();
					if (jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").isJsonNull())
						gdp = 0;
					else {
						gdp = jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").getAsFloat();
					
					}
					g.add(gdp);
					System.out.println("Government expenditure on education of " + country + " in " + year + " is " + gdp);
					if(gdp!=0) {
					gdpAvg = gdpAvg + gdp;
					}					
					
				}if(Collections.frequency(g, i) == g.size() ) {
					
					popupMessages p = new popupMessages();
					p.noData();
				}
				System.out.println(
						"The average Government expenditure on education over the selected years is " + gdpAvg / sizeOfResults);
			
	}
			
		
	}catch (NumberFormatException nfe) {
        System.out.println("NumberFormat Exception: invalid input string");
    }
		catch (IOException e) {
		
		e.printStackTrace();
	}
	}
}
