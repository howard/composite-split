package com.codexfons.compositesplit.splitter;

import java.util.List;

public class NonGreedyRuleAntiGapSplitter extends RuleAntiGapSplitter {
	
	@Override
	protected String getLongestWord(String compoundWord) {
		// This version of getLongestWord is a bit self-critical and picks the
		// next shorted word if that allows a new word to be formed.
		// Note: Currently, this doesn't work at all.
		List<String> subWords = dict.getSubWords(compoundWord);
		if (subWords.size() > 0) {
			String longestSubWord = subWords.get(subWords.size() - 1);
			if (subWords.size() > 1) {
				// Give the second longest word a chance
				try {
					String secondLongestSubWord = subWords.get(subWords.size() - 2);
					String regularNextWord = super.getLongestWord(compoundWord.substring(longestSubWord.length()));
					String possibleNextWord = super.getLongestWord(compoundWord.substring(secondLongestSubWord.length()));
					return regularNextWord.equals(possibleNextWord) ? longestSubWord : secondLongestSubWord;
				} catch (StringIndexOutOfBoundsException | NullPointerException e) {
					// In case we run out of characters
					return longestSubWord;
				}
			} else {
				return longestSubWord;
			}
		} else {
			return null;
		}
	}
}
