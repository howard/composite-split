package com.codexfons.compositesplit;

import java.util.Arrays;
import java.util.List;

import com.codexfons.compositesplit.dictionary.Dictionary;

public class CommandLineInterface {
	
	public static class Config {
		public String dictPath = "data/nomen-sg-filt.txt";
		public String compoundWord;
	}
	

	private static Dictionary dict;
	
	public static Config parseArgs(String[] args) {
		List<String> argList = Arrays.asList(args);
		Config config = new Config();
		int dictArgIndex = argList.indexOf("-d") + 1;
		if (dictArgIndex > 0) {
			if (dictArgIndex >= argList.size()) {
				System.err.println("Dictionary flag was given, but not path to a dictionary was provided.");
				return null;
			} else {
				config.dictPath = argList.get(dictArgIndex);
			}
		}
		
		int compoundWordIndex = dictArgIndex > 0 ? dictArgIndex + 1 : 0;
		if (compoundWordIndex >= argList.size()) {
			System.err.println("A compound noun must be provided as last argument.");
			return null;
		} else {
			config.compoundWord = argList.get(compoundWordIndex);
		}
		
		return config;
	}
	
	public static void main(String[] args) {
		Config config = parseArgs(args);
		if (config == null) {
			return;
		}
		dict = Dictionary.getInstance(config.dictPath);
		//System.out.println(dict.contains(config.compoundWord));
		List<String> subWords = dict.getSubWords(config.compoundWord);
		for (String subWord : subWords) {
			System.out.println(subWord);
		}
	}

}
