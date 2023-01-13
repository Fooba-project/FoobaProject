package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class miniLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		String pwd=request.getParameter("userpw");
		String fseq=request.getParameter("fseq");
		
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=mdao.getMember(id);
		
		

		String url="fooba.do?command=miniLoginForm";
		
		request.setAttribute("check", "1");
		if(mvo==null) request.setAttribute("message","존재하지 않는 아이디입니다.");
		else if(mvo.getPwd()==null)request.setAttribute("message","시스템 오류. 관리자에게 문의하세요");
		else if(!mvo.getPwd().equals(pwd)) request.setAttribute("message","비밀번호가 틀립니다.");
		else if(mvo.getPwd().equals(pwd)) {
			url="fooba.do?command=menupopup";
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",mvo);
			session.removeAttribute("message");
		}else request.setAttribute("message","로그인 실패, 관리자에게 문의하세요.");
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
