package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;
import fooba.dao.AdminDao;

public class admin_loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminid=request.getParameter("adminid");
		String adminpw=request.getParameter("adminpw");
		
		String url="fooba.do?command=admin_loginForm"; //관리자 로그인창
		
		AdminDao adao =AdminDao.getInstance();
		String adminUserPwd=adao.AdminCheck(adminid);
		
		if(adminUserPwd==null)
			request.setAttribute("message", "아이디가 없습니다.");
		else if(!adminUserPwd.equals(adminpw))
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		else if(adminUserPwd.equals(adminpw)) {
			HttpSession session=request.getSession();
			session.setAttribute("loginAdmin",adminid);			
			url="fooba.do?command=admin_restaurantList";
			request.removeAttribute("message");
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
