package com.codexfons.compositesplit.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codexfons.compositesplit.Utils;

public class Dictionary {
	
	protected static Map<String, Dictionary> dictionaries = new HashMap<String, Dictionary>();
	public static Dictionary getInstance(String dictPath) {
		if (!dictionaries.containsKey(dictPath)) {
			dictionaries.put(dictPath, new Dictionary(dictPath));
		}
		return dictionaries.get(dictPath);
	}
	

	protected LetterNode root = new LetterNode(Character.MIN_VALUE, false, true);
	
	protected Dictionary(String dictPath) {
		try {
			process(dictPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected boolean isValidWord(String word) {
		return word.length() > 0;
	}
	
	protected void process(String dictPath) throws IOException {
		Utils.startStopwatch("dict generation");
		File f = new File(dictPath);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
		while (line != null) {
			if (isValidWord(line)) {
				insert(line.toLowerCase());
			}
			line = reader.readLine();
		}
		reader.close();
		Utils.stopStopwatch("dict generation");
	}
	
	protected void insertHelper(LetterNode node, String letters, int currIndex) {
		// Possible situations:
		// * Complete prefix path not available yet
		// * Word is substring of other word
		// * Duplicate word
		
		boolean isWord = currIndex + 1 >= letters.length();
		LetterNode childNode = node.getChild(letters.charAt(currIndex));
		if (childNode == null) {
			// No child for this portion of the path yet. Create and insert one.
			// If this is the last character, consider this a word as well as a leaf.
			childNode = new LetterNode(letters.charAt(currIndex), isWord, isWord);
			node.isLeaf = false;
			node.insertChild(childNode);
		}
		
		if (!isWord) {
			// Recur with next character with child node.
			insertHelper(childNode, letters, currIndex + 1);
		} else {
			// Done. If this was a duplicate, insertion did not change the Trie.
			childNode.isWord = true;
		}
	}
	
	public void insert(String word) {
		insertHelper(root, word, 0);
	}
	
	public boolean contains(String word) {
		LetterNode finalNode = lookup(word);
		return finalNode != null && finalNode.isWord;
	}
	
	public boolean containsPrefix(String prefix) {
		LetterNode finalNode = lookup(prefix);
		return finalNode != null;
	}
	
	protected LetterNode lookupHelper(LetterNode node, String letters, int currIndex) {
		LetterNode childNode = node.getChild(letters.charAt(currIndex));
		if (currIndex + 1 >= letters.length()) {
			// Lookup complete. Returning null is okay, since that means the prefix doesn't exist.
			return childNode;
		} else if (childNode == null) {
			// Abort if letters not fully matched yet, but there are no more leafes available.
			return null;
		} else {
			return lookupHelper(childNode, letters, currIndex + 1);
		}
	}
	
	public LetterNode lookup(String word) {
		Utils.startStopwatch("dict lookup");
		LetterNode node = lookupHelper(root, word, 0);
		Utils.stopStopwatch("dict lookup");
		return node;
	}
	
	protected void longestWordHelper(LetterNode node, String letters, int currIndex, List<String> subWords) {
		LetterNode childNode = node.getChild(letters.charAt(currIndex));

		if (node.isWord) {
			subWords.add(letters.substring(0, currIndex));
		}
		
		if (currIndex + 1 >= letters.length()) {
			if (childNode != null && childNode.isWord) {
				subWords.add(letters.substring(0, currIndex + 1));
			}
			return;
		} else if (childNode == null) {
			return;
		} else {
			longestWordHelper(childNode, letters, currIndex + 1, subWords);
		}
	}

	public List<String> getSubWords(String compoundWord) {
		List<String> subWords = new ArrayList<String>();
		longestWordHelper(root, compoundWord, 0, subWords);
		return subWords;
	}
}
