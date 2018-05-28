package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.model.Screen;

/**
 * This is the utility class which will provide the utility to read and write
 * data from json.
 * 
 * @author lenovo
 *
 */
public class JSONUtil {

	/**
	 * This is the list of screens
	 */
	List<Screen> screenList = null;

	public JSONUtil() {
		screenList = new ArrayList<Screen>();
	}

	/**
	 * This method will write the screen list to the json file.
	 * 
	 * @param screen
	 * @return size of the screen's list
	 */
	public int writeScreenToList(Screen screen) {
		screenList.add(screen);
		Gson gson = new GsonBuilder().create();
		try {
			String jsonInString = gson.toJson(screenList);
			FileWriter jsonFileWriter = new FileWriter("src/main/resources/Json/Screen.json");
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}

		return screenList.size();
	}

	/**
	 * This method will read the data from json and store it into the screenlist
	 * object
	 * 
	 * @return list of screens
	 */
	public List<Screen> readListOfScreen() {

		Gson gson = new GsonBuilder().create();
		FileReader jsonFileReader;
		try {
			jsonFileReader = new FileReader("src/main/resources/Json/Screen.json");
			BufferedReader bufferedReader = new BufferedReader(jsonFileReader);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				screenList = gson.fromJson(jsonfromString, new TypeToken<List<Screen>>() {
				}.getType());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenList;

	}

	/**
	 * This method will update the list of screen
	 * 
	 * @param screenList
	 *            - updated list of screen
	 * @return true/false as list updated
	 */
	public boolean updateListOfScreens(List<Screen> screenList) {
		Gson gson = new GsonBuilder().create();
		try {
			String jsonInString = gson.toJson(screenList);
			FileWriter jsonFileWriter = new FileWriter("src/main/resources/Json/Screen.json");
			jsonFileWriter.write(jsonInString);
			jsonFileWriter.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * This method will return the screen object by using the screen name.
	 * 
	 * @param screenName
	 * @return
	 */
	public Screen getScreenObject(String screenName) {
		screenList = readListOfScreen();
		Screen requiredScreen = null;
		for (Screen screen : screenList) {
			if (screen.getName().equalsIgnoreCase(screenName)) {
				requiredScreen = screen;
			}
		}
		return requiredScreen;
	}
}
