package fooba.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberIdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid= request.getParameter("userid");
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=mdao.getMember(userid);
		
		if(mvo==null)request.setAttribute("result",-1);
		else request.setAttribute("result", 1);
		
		request.setAttribute("userid", userid);
		
		RequestDispatcher dp=request.getRequestDispatcher("member/memberIdCheck.jsp");
		dp.forward(request, response);

	}

}
