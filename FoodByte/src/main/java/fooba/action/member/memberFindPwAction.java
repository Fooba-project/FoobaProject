package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberFindPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String name=request.getParameter("username");
		String phone=request.getParameter("userphone");
		String id =request.getParameter("userid");
		MemberDao mdao=MemberDao.getInstance();
		String email = mdao.memberFindPw(name, phone, id);
		String url="fooba.do?command=loginForm";

		request.setAttribute("message","비밀번호 재설정 링크를 귀하의 이메일("+email+")로 보냈습니다.");
		if(email==null || email=="") {request.setAttribute("message","일치하는 정보가 없습니다. 다시 입력하세요.");
			url="fooba.do?command=memberFindPwForm"; }
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
