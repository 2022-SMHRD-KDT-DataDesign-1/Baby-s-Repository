package TamagochPrj;

import java.util.ArrayList;

public class Controller {

	JoinDAO dao = new JoinDAO();

	public void join(JoinDTO dto) {
		int row = dao.join(dto);
		if (row > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}

	}

	public void delete(JoinDTO dto) {
		int row = dao.delete(dto);

		if (row > 0) {
			System.out.println("회원삭제 성공");
		} else {
			System.out.println("회원삭제 실패");
		}
	}

	public void select() {
		ArrayList<JoinDTO> list = dao.select();// list

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getId() + "         ");
			System.out.print(list.get(i).getPw() + "         ");
			System.out.println(list.get(i).getName());
		}

	}

	public void selectOne(JoinDTO dto) {
		JoinDTO dto2 = null;

		dto2 = dao.selectOne(dto);
		if (dto2.getId() == null) {
			System.out.println("검색 결과 회원이 없습니다.");
		} else {
			System.out.println(dto2.getName() + "님의 ID는 " + dto2.getId() + "입니다." + "PW는 " + dto2.getPw() + "입니다.");

		}
	}

	public void login(JoinDTO dto) {
		boolean result = dao.login(dto); 
		if (result) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

	}
}
