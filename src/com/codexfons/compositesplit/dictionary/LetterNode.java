package com.codexfons.compositesplit.dictionary;

import com.codexfons.compositesplit.Settings;
import com.codexfons.compositesplit.Utils;

/**
 * Letter node; may also be used as Trie root.
 * To reduce load, the use of accessors if avoided.
 */
public class LetterNode {
	
	public char letter;
	public boolean isWord = false;
	public boolean isLeaf = false;
	public LetterNode[] children = new LetterNode[Settings.ALPHABET_SIZE];
	
	public LetterNode(char letter, boolean isWord, boolean isLeaf) {
		this.letter = letter;
		this.isWord = isWord;
		this.isLeaf = isLeaf;
	}
	
	public LetterNode getChild(char letter) {
		try {
			return children[Utils.getCharIndex(letter)];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(letter);
			return null;
		}
	}
	
	public void insertChild(LetterNode child) {
		children[Utils.getCharIndex(child.letter)] = child;
	}

}
