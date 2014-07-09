package com.codexfons.compositesplit.splitter.rules;

import com.codexfons.compositesplit.dictionary.Dictionary;

public class SRule implements Rule {

	@Override
	public int apply(String compoundWordRest, Dictionary dict) {
		if (!compoundWordRest.startsWith("s")) return 0;
		if (compoundWordRest.startsWith("sch")) return 0;
		if (compoundWordRest.startsWith("st")) return 0;
		return 1;
	}

}
