package com.codexfons.compositesplit.splitter;

import java.util.List;

import com.codexfons.compositesplit.Utils;
import com.codexfons.compositesplit.dictionary.Dictionary;

public abstract class AbstractSplitter {
	
	protected Dictionary dict;

	public Dictionary getDict() {
		return dict;
	}

	public void setDict(Dictionary dict) {
		this.dict = dict;
	}
	
	protected abstract List<String> splitImpl(String compoundWord);
	
	public List<String> split(String compoundWord) {
		if (dict == null) {
			throw new IllegalStateException("The splitter must be supplied with a dictionary before use!");
		}
		Utils.startStopwatch(getClass().getSimpleName());
		List<String> subWords = splitImpl(compoundWord);
		Utils.stopStopwatch(getClass().getSimpleName());
		return subWords;
	}

}
