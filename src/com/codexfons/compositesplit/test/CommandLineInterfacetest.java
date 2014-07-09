package com.codexfons.compositesplit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codexfons.compositesplit.CommandLineInterface;
import com.codexfons.compositesplit.CommandLineInterface.Config;

public class CommandLineInterfacetest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testNoArgs() {
		Config config = CommandLineInterface.parseArgs(new String[] { });
		assertNull(config);
	}

	@Test
	public void testDefaultDict() {
		Config config = CommandLineInterface.parseArgs(new String[] { "testwort" });
		assertEquals(config.dictPath, "data/german-common-nouns-extended.txt");
		assertEquals(config.compoundWord, "testwort");
	}

	@Test
	public void testNoCompoundWord() {
		Config config = CommandLineInterface.parseArgs(new String[] { "-d", "data/nomen-sg-filt.txt" });
		assertNull(config);
	}

	@Test
	public void testCustomDict() {
		Config config = CommandLineInterface.parseArgs(new String[] { "-d", "data/custom-dict.txt", "testwort" });
		assertEquals(config.dictPath, "data/custom-dict.txt");
		assertEquals(config.compoundWord, "testwort");
	}

}
