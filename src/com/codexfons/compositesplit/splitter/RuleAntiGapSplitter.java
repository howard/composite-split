package com.codexfons.compositesplit.splitter;

import java.util.ArrayList;
import java.util.List;

import com.codexfons.compositesplit.splitter.rules.EnRule;
import com.codexfons.compositesplit.splitter.rules.Rule;
import com.codexfons.compositesplit.splitter.rules.SRule;

public class RuleAntiGapSplitter extends AgressiveAntiGapSplitter {
	
	protected static List<Rule> rules = new ArrayList<Rule>();
	
	static {
		rules.add(new SRule());
		rules.add(new EnRule());
	}

	@Override
	protected int getSkipDistance(String compoundWordRest) {
		for (Rule rule : rules) {
			int skipDistance = rule.apply(compoundWordRest, dict);
			if (skipDistance > 0) {
				return skipDistance;
			}
		}
		return 0;
	}
}
