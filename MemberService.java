package day13;

import java.util.Scanner;

public class MemberService {
	/* 기능 정의 클래스 */

	Scanner scan = new Scanner(System.in);
	// 회원 목록(회원정보 DB)
	Member[] memberList = new Member[5]; // 필드

	// 메뉴 출력 기능 메소드
	public void showMenu() {
		System.out.println("------------------------");
		System.out.println("[1]회원가입 [2]로그인 [3]종료");
		System.out.println("------------------------");
		System.out.print("메뉴선택>>");
	}

	// 회원가입 기능 메소드
	public void memberJoin() {
		// memberList 배열의 비어있는 인덱스 검색
		int idx = -1;
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] == null) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("더이상 회원가입 할 수 없습니다.");
			return; // 비어있는 자리가 없는 중지
		}
		System.out.println("[회원가입]");
		// 회원가입 처리
		// 1. 가입정보 입력받고
		System.out.print("가입할 아이디>>");
		String inputMid = scan.next();
		// 아이디 중복확인 기능 메소드(중복된 아이디가 있는지 확인)
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null) {
				if (inputMid.equals(memberList[i].getMid())) {
					System.out.println("중복된 아이디 입니다.\n다시 가입해주세요!");
					return;
				}
			}
		}

		System.out.print("가입할 비밀번호>>");
		String inputMpw = scan.next();
		System.out.print("가입할 이름>>");
		String inputMname = scan.next();

		// 2. 입려된 정보를 하나로 모으고
		Member mem = new Member();
		mem.setMid(inputMid);
		mem.setMpw(inputMpw);
		mem.setMname(inputMname);

		// 3. 회원 목록에 저장(memberList 배열의 비어있는 인덱스에 저장)
		memberList[idx] = mem;
		System.out.println("가입되었습니다.");

	}

	// 로그인 기능 메소드
	public void memberLogin() {
		System.out.println("[로그인]");
		//1. 로그인할 아이디, 비밀번호 입력
		System.out.print("아이디입력>>");
		String loginMid = scan.next();
		System.out.print("비밀번호입력>>");
		String loginMpw = scan.next();
		
		//2. 입력한 값과 일치하는 회원정보 검색
		int idx = -1;
		for(int i = 0; i < memberList.length; i++) {
			if( memberList[i] != null) {
				if( loginMid.equals(memberList[i].getMid()) && loginMpw.equals(memberList[i].getMpw()) ) {
					//로그인 성공
					idx = i;
					break;
				}
			}
		}
		// 3. 일치하는 회원이 있을 경우 "아이디, 비밀번호, 이름" 출력
		if(idx > -1) {
			System.out.println("로그인 성공");
			System.out.println("아이디 : " + memberList[idx].getMid() );
			System.out.println("비밀번호 : " + memberList[idx].getMpw());
			System.out.println("이름 : " + memberList[idx].getMname());
		}else { // 일치하는 회원이 없을 경우 "아아디/비밀번혹가  일치하지 않습니다." 출력	 
			System.out.println("아아디/비밀번혹가  일치하지 않습니다.");
		}
		
		
		
		//혼자 해본것(로그인)
		/*		for(int i = 0; i < memberList.length; i++) {
			if( memberList[i] != null) {
				if( (loginMid.equals(memberList[i].getMid())) && (loginMpw.equals(memberList[i].getMpw())) ) {
					System.out.println("아이디 : " + memberList[i].getMid() );
					System.out.println("비밀번호 : " + memberList[i].getMpw());
					System.out.println("비밀번호 : " + memberList[i].getMname());
					
				}else {
					System.out.println("아아디/비밀번혹가  일치하지 않습니다.");
					return;
				}
			}
		}
		 */		
		
	}
	
	
	
	
}
