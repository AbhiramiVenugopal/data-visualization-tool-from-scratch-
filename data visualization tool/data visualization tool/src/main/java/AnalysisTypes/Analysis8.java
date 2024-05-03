package AnalysisTypes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Analysis8 {
	public void analyze(String country, String code, Object fromYear, Object toYear) {
		// TODO Auto-generated method stub
		String infant = "SP.DYN.IMRT.IN";
		String Maternal = "SH.STA.MMRT";
		String urlString1 = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/"+infant+"?date="+fromYear+":"+toYear+"&format=json", code);
		String urlString2 = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/"+Maternal+"?date="+fromYear+":"+toYear+"&format=json", code);
		System.out.println(urlString1);
		System.out.println(urlString2);
		float MortalityrateInfant = 0;
		float MortalityrateMaternal=0;
		float i=(float) 0.0;
		ArrayList<Float> a = new ArrayList<Float>();
		ArrayList<Float> b = new ArrayList<Float>();
		
		try {
			URL url1 = new URL(urlString1);
			URL url2 = new URL(urlString2);
			HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
			conn1.setRequestMethod("GET");
			conn1.connect();
			
			HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
			conn2.setRequestMethod("GET");
			conn2.connect();
			
			int responsecode1 = conn1.getResponseCode();
			if (responsecode1 == 200) {
				String inline1 = "";
				Scanner scann1 = new Scanner(url1.openStream());
				while (scann1.hasNext()) {
					inline1 += scann1.nextLine();
				}
				scann1.close();
				JsonArray jsonArray1 = new JsonParser().parse(inline1).getAsJsonArray();
				
				int responsecode2 = conn2.getResponseCode();
				if (responsecode2 == 200) {
					String inline2 = "";
					Scanner scann2 = new Scanner(url2.openStream());
					while (scann2.hasNext()) {
						inline2 += scann2.nextLine();
					}
					scann2.close();
					JsonArray jsonArray2 = new JsonParser().parse(inline2).getAsJsonArray();
					
				int size = jsonArray1.size();
				int sizeOfResults = jsonArray1.get(1).getAsJsonArray().size();
				int year;
				int year2;
				for (int i1 = 0; i1 < sizeOfResults; i1++) {
				
					year = jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("date").getAsInt();
					if (jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").isJsonNull())
						MortalityrateInfant = 0;
					else {
						MortalityrateInfant = jsonArray1.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").getAsFloat();
					
					}
					year2 = jsonArray2.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("date").getAsInt();
					if (jsonArray2.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").isJsonNull())
						MortalityrateMaternal = 0;
					else {
						MortalityrateMaternal = jsonArray2.get(1).getAsJsonArray().get(i1).getAsJsonObject().get("value").getAsFloat();
					
					}
					a.add(MortalityrateInfant);
					b.add(MortalityrateMaternal);
					System.out.println("Infant Mortality Rate of " + country + " in " + year + " is " + MortalityrateInfant);
					System.out.println("Maternal Mortality Rate of " + country + " in " + year2 + " is " + MortalityrateMaternal);
					
				}if(Collections.frequency(a, i) == a.size()||Collections.frequency(b, i) == b.size() ) {
					
					popupMessages p = new popupMessages();
					p.noData();
				}
	}
			}
		
	}catch (NumberFormatException nfe) {
        System.out.println("NumberFormat Exception: invalid input string");
    }
		catch (IOException e) {
		
		e.printStackTrace();
	}
	}
}
