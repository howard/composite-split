package com.codexfons.compositesplit;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	
	public static int getCharIndex(char character) {
		int value = character - 97;
		if (value < 0 || value > 25) {
			value = 25 + Settings.SPECIAL_CHARS.indexOf(character);
		}
		return value;
	}
	
	private static Map<String, Long> stopwatchTimes = new HashMap<String, Long>();
	
	
	public static void startStopwatch(String purpose) {
		if (!Settings.PROFILE) return;
		stopwatchTimes.put(purpose, System.currentTimeMillis());
	}

	public static void stopStopwatch(String purpose) {
		if (!Settings.PROFILE) return;
		System.err.printf("### %s took %dms\n", purpose, System.currentTimeMillis() - stopwatchTimes.get(purpose));
	}

}
