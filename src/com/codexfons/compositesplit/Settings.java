package com.codexfons.compositesplit;

import java.util.ArrayList;
import java.util.List;

import com.codexfons.compositesplit.splitter.*;

public class Settings {
	
	public static final boolean PROFILE;
	public static final boolean PURGE_UMLAUT;
	public static final int ALPHABET_SIZE;
	public static final List<Character> SPECIAL_CHARS = new ArrayList<Character>();
	public static final Class<? extends AbstractSplitter> SPLITTER = RuleAntiGapSplitter.class;
	
	static {
		SPECIAL_CHARS.add('ä');
		SPECIAL_CHARS.add('ö');
		SPECIAL_CHARS.add('ü');
		SPECIAL_CHARS.add('é');
		SPECIAL_CHARS.add('è');
		for (int i = 0; i < 9; i++) {
			SPECIAL_CHARS.add(Integer.toString(i).charAt(0));
		}
		ALPHABET_SIZE = 26 + SPECIAL_CHARS.size();
		
		String profilingEnv = System.getenv("PROFILE");
		PROFILE = profilingEnv != null && (profilingEnv.equals("1") || profilingEnv.equals("true"));
		
		String purgeUmlautEnv = System.getenv("PURGE_UMLAUT");
		PURGE_UMLAUT = purgeUmlautEnv != null && (profilingEnv.equals("1") || profilingEnv.equals("true"));
	}

}
