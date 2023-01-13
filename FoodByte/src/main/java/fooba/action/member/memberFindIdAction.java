package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberFindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String phone=request.getParameter("userphone");
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=mdao.findId(name, phone);
		
		//getMember메서드를 만들고, 리턴 상황에 맞는 if문을 이용해서 로그인을 구현
		//최종 목적지는 main.jsp
		url="fooba.do?command=index";
		String url="fooba.do?command=loginForm";
		
		if(mvo!=null) request.setAttribute("message","일치하는 정보가 없습니다.");
		else if(mvo.getPwd().equals(pwd)) {
			url="fooba.do?command=index";
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",mvo);
			session.removeAttribute("message");
		}else request.setAttribute("message","로그인 실패, 관리자에게 문의하세요.");
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
