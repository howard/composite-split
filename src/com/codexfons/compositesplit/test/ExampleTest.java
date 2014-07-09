package com.codexfons.compositesplit.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codexfons.compositesplit.dictionary.Dictionary;

public class ExampleTest {
	
	protected static Dictionary dict;
	protected static List<String> referenceWords = new ArrayList<String>();

	protected static void setup(String dictPath, String referencePath) throws Exception {
		dict = Dictionary.getInstance(dictPath);
		
		File referenceFile = new File(referencePath);
		BufferedReader reader = new BufferedReader(new FileReader(referenceFile));
		String line = reader.readLine();
		while (line != null) {
			referenceWords.add(line);
			line = reader.readLine();
		}
		reader.close();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setup("data/nomen-sg-filt.txt", "data/compounds.txt");
	}

	@Test
	public void test() {
		
	}

}
