package com.codexfons.compositesplit.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	protected static Map<String, Dictionary> dictionaries = new HashMap<String, Dictionary>();
	public static Dictionary getInstance(String dictPath) {
		if (!dictionaries.containsKey(dictPath)) {
			dictionaries.put(dictPath, new Dictionary(dictPath));
		}
		return dictionaries.get(dictPath);
	}
	

	protected List<LetterNode> alphabet = new ArrayList<LetterNode>();
	
	protected Dictionary(String dictPath) {
		process(dictPath);
	}
	
	protected void process(String dictPath) {
		
	}

}
