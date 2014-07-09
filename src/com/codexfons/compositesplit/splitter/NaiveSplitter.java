package com.codexfons.compositesplit.splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Always uses the longest word.
 */
public class NaiveSplitter extends AbstractSplitter {
	
	protected String getLongestWord(String compoundWord) {
		List<String> subWords = dict.getSubWords(compoundWord);
		if (subWords.size() > 0) {
			return subWords.get(subWords.size() - 1);
		} else {
			return null;
		}
	}

	@Override
	protected List<String> splitImpl(String compoundWord) {
		List<String> subWords = new ArrayList<String>();
		for (int remainingChars = compoundWord.length(); remainingChars > 0; remainingChars--) {
			System.out.println(compoundWord.length() - remainingChars);
			String longestWord = getLongestWord(compoundWord.substring(compoundWord.length() - remainingChars));
			System.out.println(longestWord);
			if (longestWord != null) {
				subWords.add(longestWord);
				remainingChars -= longestWord.length() - 1;
			}
		}
		
		return subWords;
	}

}
