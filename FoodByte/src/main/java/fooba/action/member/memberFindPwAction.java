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
		String id =request.getParameter("id");
		MemberDao mdao=MemberDao.getInstance();
		String email = mdao.memberFindPw(name, phone, id);
		
		String url="fooba.do?command=loginForm";
		request.setAttribute("message","귀하의 아이디는 '"+id+"'입니다.");
		if(id!=null || id=="") {request.setAttribute("message","일치하는 정보가 없습니다. 다시 입력하세요.");
			url="fooba.do?command=memberFindIdForm"; }
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
