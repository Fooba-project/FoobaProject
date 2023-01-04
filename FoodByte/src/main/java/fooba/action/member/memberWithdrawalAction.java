package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberWithdrawalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=loginForm";

		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");

		if(mvo!=null) {
			MemberDao mdao=MemberDao.getInstance();
			mdao.deleteMember(mvo.getId());
			request.setAttribute("message", "회원탈퇴가 완료되었습니다.");
			session.removeAttribute("loginUser");
		} else {
			request.removeAttribute("message");
		}
		request.getRequestDispatcher(url).forward(request,response); 


	}

}
