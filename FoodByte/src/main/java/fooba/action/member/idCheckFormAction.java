package fooba.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class idCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=mdao.getMember(id);
		
		if(mvo==null)request.setAttribute("result",-1);
		else request.setAttribute("result", 1);
		
		request.setAttribute("id", id);
		
		RequestDispatcher dp=request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);


	}

}
