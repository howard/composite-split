package com.codexfons.compositesplit.splitter;

public class LookaheadAntiGapSplitter extends AgressiveAntiGapSplitter {
	
	@Override
	protected int getSkipDistance(String compoundWordRest) {
		for (String gapWord : gapWords) {
			if (compoundWordRest.startsWith(gapWord)) {
				if (getLongestWord(compoundWordRest.substring(gapWord.length())) != null) {
					return gapWord.length();
				}
			}
		}
		return 0;
	}

}
