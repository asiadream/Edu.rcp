package kr.namoosori.helloplugin.jface.tableviewer;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class TableSorter extends ViewerSorter {
	/** 선택한 인덱스 */
	protected int propertyIndex;
	public static final int ASCENDING = 0;
	public static final int DESCENDING = 1;

	protected int direction = DESCENDING;

	/*
	 * 생성자 내림차순을 기본으로 한다. 처음 인덱스를 0으로 한다.
	 */
	public TableSorter() {
		this.propertyIndex = -1;
		direction = DESCENDING;
	}

	public TableSorter(int propertyIndex) {
		this.propertyIndex = propertyIndex;
		direction = DESCENDING;
	}

	public TableSorter(int propertyIndex, int direction) {
		this.propertyIndex = propertyIndex;
		this.direction = direction;
	}

	/**
	 * 선택한 컬럼의 인덱스를 세팅하고, 내림차순 또는 오름 차순을 선택한다.
	 * 
	 * @param column
	 *            선택한 컬럼 인덱스
	 */
	public void setColumn(int column) {
		if (column == this.propertyIndex) {
			// Same column as last sort; toggle the direction
			direction = 1 - direction;
		} else {
			// New column; do an ascending sort
			this.propertyIndex = column;
			direction = DESCENDING;
		}
	}

	/**
	 * 두값(e1, e2) 비교한다.
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		int rc = 0;
		//----------------------------------------------------------------------
		Person p1 = (Person) e1;
		Person p2 = (Person) e2;
		if (propertyIndex == 0) rc = compareTo(p1.firstName, p2.firstName);
		if (propertyIndex == 1) rc = compareTo(p1.lastName, p2.lastName);
		if (propertyIndex == 2) rc = compareTo(p1.age, p2.age);
		if (propertyIndex == 3) rc = compareTo(p1.children.length, p2.children.length);
		//----------------------------------------------------------------------
		
		// 내림차순일 경우
		if (direction == DESCENDING) {
			rc = -rc;
		}
		return rc;
	}
	
	protected int compareTo(String arg1, String arg2) {
		if (arg1 == null && arg2 == null) {
			return 0;
		}
		if (arg1 == null) {
			return -1;
		}
		if (arg2 == null) {
			return 1;
		}
		return arg1.compareTo(arg2);
	}

	/**
	 * long형에 대한 비교
	 * 
	 * @param arg1
	 * @param arg2
	 * @return 같으면 0, 크면 1, 작으면 -1
	 */
	protected int compareTo(long arg1, long arg2) {
		if (arg1 == arg2) {
			return 0;
		} else if (arg1 > arg2) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * int 대한 비교
	 * 
	 * @param arg1
	 * @param arg2
	 * @return 같으면 0, 크면 1, 작으면 -1
	 */
	protected int compareTo(int arg1, int arg2) {
		if (arg1 == arg2) {
			return 0;
		} else if (arg1 > arg2) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * boolean형에 대한 비교
	 * 
	 * @param arg1
	 * @param arg2
	 * @return 같으면 0, 다르면 1
	 */
	protected int compareTo(boolean arg1, boolean arg2) {
		if (arg1 == arg2) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 이름을 리턴한다. 상속받는다.
	 * 
	 * @return 이름
	 */
	public String getName() {
		return null;
	}
}
