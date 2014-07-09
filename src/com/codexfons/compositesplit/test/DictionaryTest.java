package com.codexfons.compositesplit.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codexfons.compositesplit.dictionary.Dictionary;
import com.codexfons.compositesplit.dictionary.LetterNode;

public class DictionaryTest {
	
	private Dictionary dict;
	
	@Before
	public void setUp() {
		dict = Dictionary.getInstance("data/nomen-sg-filt.txt");
	}

	@Test
	public void testInsert() {
		assertTrue(dict.contains("test"));
	}
	
	@Test
	public void testTrieStructure() {
		LetterNode node = dict.lookup("radix");
		assertTrue(node.isWord);
		assertTrue(node.isLeaf);
		node = dict.lookup("rad");
		assertTrue(node.isWord);
		assertFalse(node.isLeaf);
	}
	
	@Test
	public void testGetSubWords() {
		List<String> subWords = dict.getSubWords("hausarzt");
		assertEquals(1, subWords.size());
		assertEquals("haus", subWords.get(0));
	}
	
	@Test
	public void testGetSubWordsExactMatch() {
		List<String> subWords = dict.getSubWords("zwirnerei");
		assertEquals(2, subWords.size());
		assertEquals("zwirn", subWords.get(0));
		assertEquals("zwirnerei", subWords.get(1));
	}

}
