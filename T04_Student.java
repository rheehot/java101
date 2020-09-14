package kr.or.ddit.basic;
/**
 * 문제)
 * 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는  Student 클래스를 만든다.
 * 생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개 변수를 받아서 처리한다.
 * 
 * 이 Student객체들은 List에 저장하여 관리한다.
 * List에 저장한 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
 * 총점의 역순으로 정렬하는 부분을 프로그램 하시오.
 * (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
 * (학번 정렬 기준은 Student클래스 자체에서 제공하도록 하고, 총점 정렬 기준은 외부클래스에서 제공하도록 한다.)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04_Student {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("102", "이운주", 70, 85, 90));
		studentList.add(new Student("104", "김근호", 60, 80, 90));
		studentList.add(new Student("103", "김지현", 90, 95, 60));
		studentList.add(new Student("101", "이경륜", 40, 70, 60));
		
		// 0. 등수 정해주기
//		if(studentList.get(0).getTotal() < studentList.get(1).getTotal()) {
//			studentList.get(0).setRank(studentList.get(0).getRank()+1);
//		}
		//위에꺼를 studentList.size() 만큼 반복
		
		for (int i = 0 ; i < studentList.size() ; i++) {
			studentList.get(i).setRank(1);
			for (int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getTotal() < studentList.get(j).getTotal()) {
					studentList.get(i).setRank(studentList.get(i).getRank()+1);
				}
			}
		}
		

		// 1. 정렬전
		System.out.println("정렬 전 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("-----------------------------------------------------------------");
		
		//2. 학번의 오름차순으로 졍럴 - Student 클래스 자체에서 제공
		Collections.sort(studentList);
		System.out.println("학번의 오름차순으로 정렬 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("-----------------------------------------------------------------");
		
		//3. 총점의 역순으로 정렬 - 외부 클래스에서 제공
		//* 총점이 같으면 학번의 내림차순으로 정렬 되도록 한다.
		Collections.sort(studentList, new SortTotalDesc());
//		for(int i = 0 ; i < studentList.size() ; i++) {
//			for (int j = 0; j < studentList.size() ; j++) {
//				if(studentList.get(i).getRank() == studentList.get(j).getRank()) {
//					Collections.sort(studentList, new SortIdDesc());
//				}
//				
//			}
//		}
		
		
		
		System.out.println("총점의 역순으로 정렬 : ");
		for (Student student : studentList) {
			System.out.println(student);
		}
		System.out.println("-----------------------------------------------------------------");

	}//main
}//class

class Student implements Comparable<Student>{
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;
	
	//필드값 이용한 생성자
	public Student(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = this.kor + this.eng + this.math;
	}
	
	//필드값 이용한 getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	@Override
	public String toString() {
		return "Student [학번=" + id + ", 이름=" + name + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math + ", 총점="
				+ total + ", 등수=" + rank + "]";
	}

	@Override
	public int compareTo(Student student) {
		return getId().compareTo(student.getId());
	}

}

//총점 역순으로 정렬하는 외부 정렬 기준 (단, 총점이 같으면 학번 순으로 내림차순)
class SortTotalDesc implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		//1. 직접 로직 구현
//		if(s1.getTotal() > s2.getTotal()) {
//			return -1;
//		}else if(s1.getTotal() == s2.getTotal()) {
//			return 0;
//		}else {
//			return 1;
//		}
		//2. wrapper 클래스 이용 1번
		return Integer.compare(s1.getTotal(), s2.getTotal()) * -1 ;
		
		//3. wrapper 클래스 이용 2번
//		return new Integer(s1.getTotal()).compareTo(s2.getTotal()) * -1;
	}
}








class SortIdDesc implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getId().compareTo(s2.getId())*-1;
	}
	
}