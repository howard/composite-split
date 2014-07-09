package com.codexfons.compositesplit.splitter;

import java.util.ArrayList;
import java.util.List;

public class AgressiveAntiGapSplitter extends NaiveSplitter {
	
	protected static String[] gapWords = new String[] {
		"s", "en"
	};
	
	protected int getSkipDistance(String compoundWordRest) {
		for (String gapWord : gapWords) {
			if (compoundWordRest.startsWith(gapWord)) {
				return gapWord.length();
			}
		}
		return 0;
	}
	
	@Override
	protected List<String> splitImpl(String compoundWord) {
		List<String> subWords = new ArrayList<String>();
		for (int remainingChars = compoundWord.length(); remainingChars > 0; remainingChars--) {
			int startIndex = compoundWord.length() - remainingChars;
			String longestWord = getLongestWord(compoundWord.substring(startIndex));
			if (longestWord != null) {
				subWords.add(longestWord);
				int skipDistance = getSkipDistance(compoundWord.substring(startIndex + longestWord.length()));
				remainingChars -= longestWord.length() - 1 + skipDistance;
			}
		}
		
		return subWords;
	}

}
