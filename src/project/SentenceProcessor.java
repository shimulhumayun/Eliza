package project;

import java.util.ArrayList;

public class SentenceProcessor {
	private String longestWord;
	private ArrayList<String> wordList;
	private String[] comments;

	public SentenceProcessor() {
		super();
		this.longestWord = "unknown";
		this.wordList = new ArrayList<String>();
		comments = new String[5];
		loadComments();
	}

	public String getLongestWord() {
		return longestWord;
	}

	public void setLongestWord(String sentence) {
		// sentence=sentence.substring(sentence.lastIndexOf("You:"));
		// split sentence into an array of words
		String[] words = sentence.split(" ");
		this.longestWord = words[0];
		for (String word : words) {
			if (word.length() > this.longestWord.length()) {
				longestWord = word;
			}
		}
	}

	private void loadComments() {
		comments[0] = "Why do you feel longestWord  is important?";
		comments[1] = "OK tell me more about longestWord";
		comments[2] = "How does longestWord affect you?";
		comments[3] = "We seem to be making great progress with longestWord";
		comments[4] = "Is there something else you would like to discuss?";
	}

	public ArrayList<String> getWordList() {
		return wordList;
	}

	public void addWordToList(String word) {
		wordList.add(word);
	}

	public int getLongestWordLength() {
		return longestWord.length();
	}

	// generate a reply to user
	public String replyToUser() {
		/*
		 * If the length of the longest word is 3 characters long your response
		 * should be "Why do you feel longestWord  is important?" If the length
		 * of the longest word is 4 characters long your response should be
		 * "OK tell me more about longestWord"
		 */
		if (getLongestWordLength() == 3) {
			return comments[0].replaceAll("longestWord", longestWord);
		} else if (getLongestWordLength() == 4) {
			return comments[1].replaceAll("longestWord", longestWord);
		} else if (getLongestWordLength() == 5) {
			return comments[2].replaceAll("longestWord", longestWord);
		} else if (getLongestWordLength() > 5) {
			return comments[3].replaceAll("longestWord", longestWord);
		} else {
			return comments[4].replaceAll("longestWord", longestWord);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof SentenceProcessor) {
			SentenceProcessor other = (SentenceProcessor) obj;
			if (other.longestWord.equalsIgnoreCase(this.longestWord)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		for (String w : wordList) {
			w += w + ",";
		}
		return str;
	}

}
