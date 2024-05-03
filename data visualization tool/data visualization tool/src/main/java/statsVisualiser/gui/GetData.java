package statsVisualiser.gui;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import AnalysisTypes.Analysis1;
import AnalysisTypes.Analysis2;
import AnalysisTypes.Analysis3;
import AnalysisTypes.Analysis4;
import AnalysisTypes.Analysis5;
import AnalysisTypes.Analysis6;
import AnalysisTypes.Analysis7;
import AnalysisTypes.Analysis8;
public class GetData {
	public static void main(String[] args) throws Exception {
		
        
	}
	public void fetchData(String country,Object fromYear, Object toYear,Object analysis) throws Exception {
		Restrictions proxy = new RestrictedCountriesYears();
		proxy.checkCountry(country);//calling to check if selected country is on the restricted list or not
		if(RestrictedCountriesYears.isbanned==true) {
			System.out.println("Please follow messages");
		}
		else {
	
		if(Integer.valueOf((String) fromYear)>=Integer.valueOf((String) toYear)) {
			popupMessages p = new popupMessages();
			p.yearNotAvailable();
			System.out.println("Can't fetch data as the start year is after the end year.");
		}
		else {
	
			proxy.checkYears(fromYear, toYear);//calling to check if selected years is on the restricted list or not
			System.out.println(RestrictedCountriesYears.isbanned);
			if(RestrictedCountriesYears.isbanned==true) {
				System.out.println("Please follow messages");
			}
			else {
		

            Object yearFrom = fromYear; //the user will choose this value from the drop down menu
    		Object yearTo = toYear; //the user will choose this value from the drop down menu
          	String aCountry = country; //this would be our selected country the user chooses from the drop down menu 
    	
    			String c ;
    			String code;
    			File fXmlFile = new File("countries.xml");
    	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	        Document doc = dBuilder.parse(fXmlFile);
    	        NodeList nodes = doc.getElementsByTagName("countries");
    	        Element element = (Element) nodes.item(0);
    	        NodeList countryList = element.getElementsByTagName("country");
    	        for (int i = 0; i < countryList.getLength(); i++) {
    	            Element countryElement = (Element) countryList.item(i);
    	            NodeList countryName = countryElement.getElementsByTagName("Name");
    	            NodeList countrycode = countryElement.getElementsByTagName("Code");
    	            //System.out.println(countryName.item(0).getFirstChild().getTextContent().toString());
    	            c= countryName.item(0).getFirstChild().getTextContent();
    	            code =countrycode.item(0).getFirstChild().getTextContent();
    	            boolean doesContain = c.contains(aCountry.toString());	            
    	            if(doesContain==true) {
    	            	
    	            	if(analysis=="Energy use vs PM2.5 air pollution") {
    	            		Analysis1 a = new Analysis1();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Forest area vs PM2.5 air pollution") {
    	            		Analysis2 a = new Analysis2();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Current health expenditure per capita (current US$) - average") {
    	            		Analysis3 a = new Analysis3();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="CO2 emissions vs GDP per capita - ratio") {
    	            		Analysis4 a = new Analysis4();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Mortality rate,infant  vs Hospital beds - ratio") {
    	            		Analysis5 a = new Analysis5();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Forest area - average") {
    	            		Analysis6 a = new Analysis6();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Government expenditure on education - average") {
    	            		Analysis7 a = new Analysis7();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	            	if(analysis=="Maternal mortality ratio vs Mortality rate, infant") {
    	            		Analysis8 a = new Analysis8();
    	            		a.analyze(aCountry,code, fromYear, toYear);
    	            	}
    	              } 
    	            }
    	          }
		        }
		      }
    			return;
  }

}

