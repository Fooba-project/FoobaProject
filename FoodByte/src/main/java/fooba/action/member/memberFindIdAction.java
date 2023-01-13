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
		String id = mdao.memberFindId(name, phone);
		String url="fooba.do?command=loginForm";
		System.out.println("id : "+id);
		request.setAttribute("message","귀하의 아이디는 '"+id+"'입니다.");
		
		if(id==null || id=="") {request.setAttribute("message","일치하는 정보가 없습니다. 다시 입력하세요.");
			url="fooba.do?command=memberFindIdForm"; }
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
