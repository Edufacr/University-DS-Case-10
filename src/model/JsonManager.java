package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;




public class JsonManager {
	
	public JsonManager() {}
	
	public void loadJson(String pPath) throws IOException {
		try {
			JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(pPath));
			JSONObject planta = (JSONObject) json.get("planta");
			JSONArray sensores = (JSONArray) json.get("sensores");
			System.out.println(planta.get("capacidad"));
			System.out.println(((JSONObject) sensores.get(1)).get("Cantón"));
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
				
		JsonManager jm = new JsonManager();
		try {
			jm.loadJson("/Users/gabriel/Documents/GitHub/University-DS-Case-10/Test_info/aya_info.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

