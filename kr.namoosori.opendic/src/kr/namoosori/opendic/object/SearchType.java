package kr.namoosori.opendic.object;

public enum SearchType {
	WORD("단어"),
	DESC("내용");
	
	private String description;
	
	private SearchType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
