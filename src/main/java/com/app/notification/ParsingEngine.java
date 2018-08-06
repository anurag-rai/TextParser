package com.app.notification;

import org.json.*;

public class ParsingEngine {
	public static String parseInputString(String input) {
		JSONObject json = new JSONObject(input);
		return json.toString(4);
	}
}
