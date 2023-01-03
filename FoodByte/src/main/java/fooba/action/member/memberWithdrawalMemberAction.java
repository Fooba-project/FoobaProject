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
			request.setAttribute("message","로그인이 필요한 서비스입니다.");
		}else {

			MemberDao mdao=MemberDao.getInstance();
			mdao.deleteMember(mvo.getId());
			request.setAttribute("message",
					"탈퇴되었습니다. 탈퇴회원의 정보는 3개월간 보관되며 그 기간안에 별도의 가입없이 계정 복구가 가능합니다.");
			session.removeAttribute("loginUser");
		}
		
		request.getRequestDispatcher(url).forward(request,response); 


	}

}
