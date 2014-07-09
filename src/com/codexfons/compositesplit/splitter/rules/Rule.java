package com.codexfons.compositesplit.splitter.rules;

import com.codexfons.compositesplit.dictionary.Dictionary;

public interface Rule {
	
	public int apply(String compoundWordRest, Dictionary dict);

}
