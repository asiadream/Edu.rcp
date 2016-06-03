package kr.namoosori.swt.widgetwindow.jface;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private String name;
	private String lectureTitle;
	private List<Student> students = new ArrayList<Student>();
	
	public Teacher(String name, String lectureTitle) {
		this.name = name;
		this.lectureTitle = lectureTitle;
	}
	
	public void addStudent(Student student) {
		student.setTeacher(this);
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		student.setTeacher(null);
		this.students.remove(student);
	}
	
	public int getStudentsSize() {
		return this.students.size();
	}
	
	public boolean hasStudents() {
		return this.students.size() > 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object example() {
		//
		List list = new ArrayList();
		Teacher t1 = new Teacher("김선생", "jQuery 기초");
		t1.addStudent(new Student("이학생", "lee@abc.co.kr", 24));
		t1.addStudent(new Student("박학생", "park@abc.co.kr", 45));
		t1.addStudent(new Student("김학생", "kim@abc.co.kr", 31));
		list.add(t1);
		Teacher t2 = new Teacher("이강사", "RCP 프로그래밍");
		t2.addStudent(new Student("홍석사", "hong@abc.co.kr", 35));
		t2.addStudent(new Student("임박사", "leem@abc.co.kr", 44));
		list.add(t2);
		Teacher t3 = new Teacher("윤선생", "SWT/JFace");
		t3.addStudent(new Student("정교수", "jj@abc.co.kr", 43));
		list.add(t3);
		list.add(new Student("한학생", "han@abc.co.kr", 32));
		
		return list;
	}
}
