package kr.namoosori.opendic.object;

public enum SearchType {
	WORD("�ܾ�"),
	DESC("����");
	
	private String description;
	
	private SearchType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
