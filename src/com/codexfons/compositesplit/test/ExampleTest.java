package com.codexfons.compositesplit.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codexfons.compositesplit.Settings;
import com.codexfons.compositesplit.Utils;
import com.codexfons.compositesplit.dictionary.Dictionary;
import com.codexfons.compositesplit.splitter.AbstractSplitter;

public class ExampleTest {
	
	protected static Dictionary dict;
	protected static AbstractSplitter splitter;
	protected static List<String> referenceWords = new ArrayList<String>();

	protected static void setup(String dictPath, String referencePath) throws Exception {
		dict = Dictionary.getInstance(dictPath);
		splitter = Settings.SPLITTER.newInstance();
		splitter.setDict(dict);
		
		File referenceFile = new File(referencePath);
		BufferedReader reader = new BufferedReader(new FileReader(referenceFile));
		String line = reader.readLine();
		while (line != null) {
			referenceWords.add(Utils.normalizeInput(line));
			line = reader.readLine();
		}
		reader.close();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setup("data/german-common-nouns-extended.txt", "data/compounds.txt");
	}

	@Test
	public void test() {
		for (String word : referenceWords) {
			System.out.println("##############################################");
			System.out.println(word);
			List<String> splitResults = splitter.split(word);
			for (String subWord : splitResults) {
				System.out.println(subWord);
			}
		}
	}

}
