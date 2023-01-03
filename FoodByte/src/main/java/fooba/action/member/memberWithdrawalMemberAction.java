package fooba.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class withdrawalMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=loginForm";
		
		
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		

		if(mvo==null) {
			url="fooba.do?command=loginForm";
			request.setAttribute("message","�α����� �ʿ��� �����Դϴ�.");
		}else {

			MemberDao mdao=MemberDao.getInstance();
			mdao.deleteMember(mvo.getId());
			request.setAttribute("message",
					"Ż��Ǿ����ϴ�. Ż��ȸ���� ������ 3������ �����Ǹ� �� �Ⱓ�ȿ� ������ ���Ծ��� ���� ������ �����մϴ�.");
			session.removeAttribute("loginUser");
		}
		
		request.getRequestDispatcher(url).forward(request,response); 


	}

}
