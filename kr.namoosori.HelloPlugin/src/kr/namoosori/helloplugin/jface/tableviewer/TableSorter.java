package kr.namoosori.helloplugin.jface.tableviewer;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class TableSorter extends ViewerSorter {
	/** ������ �ε��� */
	protected int propertyIndex;
	public static final int ASCENDING = 0;
	public static final int DESCENDING = 1;

	protected int direction = DESCENDING;

	/*
	 * ������ ���������� �⺻���� �Ѵ�. ó�� �ε����� 0���� �Ѵ�.
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
	 * ������ �÷��� �ε����� �����ϰ�, �������� �Ǵ� ���� ������ �����Ѵ�.
	 * 
	 * @param column
	 *            ������ �÷� �ε���
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
	 * �ΰ�(e1, e2) ���Ѵ�.
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
		
		// ���������� ���
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
	 * long���� ���� ��
	 * 
	 * @param arg1
	 * @param arg2
	 * @return ������ 0, ũ�� 1, ������ -1
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
	 * int ���� ��
	 * 
	 * @param arg1
	 * @param arg2
	 * @return ������ 0, ũ�� 1, ������ -1
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
	 * boolean���� ���� ��
	 * 
	 * @param arg1
	 * @param arg2
	 * @return ������ 0, �ٸ��� 1
	 */
	protected int compareTo(boolean arg1, boolean arg2) {
		if (arg1 == arg2) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * �̸��� �����Ѵ�. ��ӹ޴´�.
	 * 
	 * @return �̸�
	 */
	public String getName() {
		return null;
	}
}
