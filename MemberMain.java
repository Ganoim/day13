package day13;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		/* 만들어진 기능을 호출해서 출력하는 클래스 */
		
		MemberService mensvc = new MemberService();
		
		boolean run = true;
		while(run) {
			//메뉴 출력 기능 메소드 호출
			mensvc.showMenu();
			int selecMenu = mensvc.scan.nextInt(); // menu -> scan -> nextInt 기능을 호출
			
			//메뉴 선택
			switch(selecMenu) {
			case 1: // 회원가입 기능 메소드 출력
				mensvc.memberJoin();
				break;
			case 2: // 로그인 기능 메소드 호출
				mensvc.memberLogin();
				break;
			default: 
				run = false;
			}
			
		}
		System.out.println("종료");
		
		
		
		
		
		
		

	}

}
