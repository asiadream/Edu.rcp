package kr.namoosori.opendic.object;

import java.util.ArrayList;
import java.util.List;

public class Word {
	//
	private String key;
	private String name;
	private String description;
	
	public Word(String key, String name, String description) {
		//
		this.key = key;
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		//
		if (this == obj) return true;
		if (!(obj instanceof Word)) return false;

		Word other = (Word) obj;
		return this.name == null ? false : this.name.equals(other.name);
	}

	public static List<Word> wordList = new ArrayList<Word>();
	static {
		wordList.add(new Word("hello", "hello", "����, �̺�, ��, �ȳ��ϼ���"));
		wordList.add(new Word("hello", "golden hello", "�Ի� �����"));
		wordList.add(new Word("hello", "harlot's hello", "�������� �ʴ� ��"));
		wordList.add(new Word("hello", "hello girl", "���� ��ȭ ��ȯ��"));
		wordList.add(new Word("hello", "bonjour", "�ȳ��ϼ���"));
	}
	
	public static List<Word> findWordList(String keyword) {
		//
		List<Word> list = new ArrayList<Word>();
		for (Word word : wordList) {
			if (word.getKey().equals(keyword)) {
				list.add(word);
			}
		}
		return list;
	}
	
	public static Word findWordByName(String name) {
		for (Word word : wordList) {
			if (word.getName().equals(name)) {
				return word;
			}
		}
		return null;
	}
}
