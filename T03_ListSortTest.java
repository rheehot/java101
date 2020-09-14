package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03_ListSortTest { // 200914
	public static void main(String[] args) {
		
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬 전 : ");
		for(Member mem : memList) { // JS for each와 비슷, iterable 객체만 쓸 수 있음, 인덱스 값을 이용할 수 없는 단점
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		// 1. Member 클래스 이용해 정렬하기
		Collections.sort(memList); 
		
		System.out.println("이름의 오름차순으로 정렬 후 : ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		// 2. 외부 정렬 기준을 이용한 정렬하기
		Collections.sort(memList, new SortNumDesc());

		System.out.println("번호의 내림차순으로 정렬 후 : ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------");
		
		
	}
}


/**
 * 회원의 정보를 저장할 클래스
 * (회원 이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기)
 */
class Member implements Comparable<Member> {
	private int num;		// 번호
	private String name;	// 이름
	private String tel;		// 전화번호

	//필드값을 이용한 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	//필드값을 이용한 Getter, Setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//toString Override
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	/**
	 * 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	 */
	@Override
	public int compareTo(Member mem) {
		return getName().compareTo(mem.getName()); //나 자신의 이름과 변수로 받은 mem의 이름 비교
	}
}// Member


/**
 * 정렬 기준의 외부 선언을 위해서는 Comparator 인터페이스를 구현하면 된다.
 * (Member 객체의 번호(num)의 내림차순으로 정렬하기)
 */
class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		
		// 직접 로직 만들기
//		if(mem1.getNum() > mem2.getNum()) {
//			return -1;
//		}else if (mem1.getNum() == mem2.getNum()) {
//			return 0;
//		}else {
//			return 1; //값은 중요하지 않음. 부호만 잘 선정해 주어 int를 return해주면 최종적으로 잘 정렬되어 나온다.
//		}
		
		// Wrapper클래스에서 제공하는 메서드를 이용하는 방법1
		// Integer의 static method 이용. 
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		// Wrapper클래스에서 제공하는 메서드를 이용하는 방법2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
	}
}






















