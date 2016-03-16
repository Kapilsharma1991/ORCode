package com.png.sample;

public class TextEditor {

	private SpellChecker spellChecker ;

	
	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}



	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}



	public void spellCheck () {
		getSpellChecker().checkSpelling();
	}
}
