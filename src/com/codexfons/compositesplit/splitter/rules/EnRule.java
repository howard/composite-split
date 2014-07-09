package com.codexfons.compositesplit.splitter.rules;

import com.codexfons.compositesplit.dictionary.Dictionary;

public class EnRule implements Rule {

	@Override
	public int apply(String compoundWordRest, Dictionary dict) {
		if (!compoundWordRest.startsWith("en")) return 0;
		if (!compoundWordRest.startsWith("ent")) return 0;
		return 1;
	}

}
