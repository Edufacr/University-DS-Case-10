package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import model.SensorManager;

public class JsonManager implements IConstants{
	
	public JsonManager() {}
	
	public ArrayList<Sensor> loadJson(String pPath, SensorManager pSensorManager) throws IOException {
		
		ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		
		try {
			JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(pPath));
			JSONObject planta = (JSONObject) json.get("planta");
			
			long intake = (long) planta.get("capacidad");
			
			JSONArray sensores = (JSONArray) json.get("sensores");
			Iterator jsonArrayIterator = sensores.iterator();
			
			while(jsonArrayIterator.hasNext()) {
				JSONObject sensor = (JSONObject) jsonArrayIterator.next();
				long rawIntake = (long) sensor.get("Consumo");
				sensors.add(pSensorManager.GenerateSensor( (int) rawIntake, (String) sensor.get("Cantón"), (String) sensor.get("Distrito"), (String) sensor.get("Barrio")));
			}

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
		
		return sensors;
	}
	
	public int getCapacity(String pPath) {
		int capacity = 0;
		try {
			JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(pPath));
			JSONObject planta = (JSONObject) json.get("planta");
			
			long jCapacity = (long) planta.get("capacidad");
			capacity = (int) jCapacity;
			

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
		return capacity;
	}
}

