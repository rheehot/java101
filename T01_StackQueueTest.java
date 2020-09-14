package kr.or.ddit.basic;

import java.util.LinkedList;

public class T01_StackQueueTest { // 200914
	/**
	 * Stack => 선입후출(FILO)의 자료구조
	 * Queue => 선입선출(FIFO)의 자료구조
	 * 
	 * Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 */
	public static void main(String[] args) {

		/**
		 * stack의 명령
		 * 1) 자료 입력 : push(저장할 값)
		 * 2) 자료 출력 : pop() => 자료를 꺼내온 후 꺼내온 자료를 stack에서 삭제한다.
		 */
		//LinkedList로 Stack 구현하기
		LinkedList<String> stack = new LinkedList<>();
		stack.push("이갱롱");
		stack.push("이운듀");
		stack.push("김현지");
		stack.push("김호근");
		System.out.println("현재 stack값들 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료 : " + data); //제일 나중에 넣은 값이 먼저 나옴
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 stack값들 : " + stack);
		
		stack.push("담임땜");
		System.out.println("현재 stack값들 : " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		
		System.out.println("=====================================");
		System.out.println();
		
		/**
		 * Queue 명령
		 * 1) 자료 입력 : offer(저장할 값)
		 * 2) 자료 출력 : poll() => 자료를 Queue에서 꺼내온 후 꺼내온 자료는 Queue에서 삭제한다.
		 */
		//LinkedList로 Queue 구현하기
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("이갱롱");
		queue.offer("이운듀");
		queue.offer("김현지");
		queue.offer("김호근");

		System.out.println("현재 queue의 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 자료 :" + temp);
		System.out.println("꺼내온 자료 :" + queue.poll());
		System.out.println("현재 queue의 값 : " + queue);
		
		if(queue.offer("찬중쌤")) {
			System.out.println("신규 등록 자료 : 찬중쌤");
		}
		System.out.println("현재 queue의 값 :" + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
		
	}//main
}//class
