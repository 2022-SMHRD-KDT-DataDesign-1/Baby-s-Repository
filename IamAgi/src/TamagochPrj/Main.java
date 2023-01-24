package TamagochPrj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Controller ct = new Controller();

		// id, pw, name

		while (true) {
			System.out.println("[1]로그인 [2]회원가입 [3]전체조회 [4]회원검색 [5]회원삭제 [6]프로그램종료 >> ");
			int select = sc.nextInt();

			if (select == 1) {
				// 로그인
				System.out.println("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.println("PW를 입력해주세요 >> ");
				String pw = sc.next();

				JoinDTO dto = new JoinDTO(id, pw);
				ct.login(dto);

			} else if (select == 2) {
				// 회원가입
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 >> ");
				String pw = sc.next();
				System.out.print("이름을 입력하세요 >> ");
				String name = sc.next();

				JoinDTO dto = new JoinDTO(id, pw, name);


				ct.join(dto);

			} else if (select == 3) {
				// 전체조회
				// select
				System.out.println("======== 전체 회원 정보 ========");
				System.out.println("ID           PW         NAME"); // 여기는 PW를 지우는게 맞을까요??
				System.out.println("----------------------------");

				ct.select();

			} else if (select == 4) {
				// 회원검색
				System.out.println("검색하고 싶은 이름을 입력하세요 >> ");
				String name = sc.next();
				JoinDTO dto = new JoinDTO(name);
				ct.selectOne(dto);

			} else if (select == 5) {
				// 회원삭제
				System.out.print("삭제할 회원의 이름을 입력하세요 >> ");
				String name = sc.next();

				JoinDTO dto = new JoinDTO(name);

				ct.delete(dto);

			} else if (select == 6) {
				// 프로그램 종료
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} else {
				System.out.println("1-6 숫자를 입력하세요.");
			}
		}

	}

}
