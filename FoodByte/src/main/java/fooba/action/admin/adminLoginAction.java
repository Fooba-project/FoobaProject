package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;
import fooba.dao.AdminDao;

public class adminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String workId=request.getParameter("workId");
		String workPwd=request.getParameter("workPwd");
		
		String url="fooba.do?command=admin"; //관리자 로그인창
		
		AdminDao adao =AdminDao.getInstance();
		String adminUserPwd=adao.AdminCheck(workId);
		
		if(adminUserPwd==null)
			request.setAttribute("message", "아이디가 없습니다.");
		else if(!adminUserPwd.equals(workPwd))
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		else if(adminUserPwd.equals(workPwd)) {
			HttpSession session=request.getSession();
			session.setAttribute("loginAdmin", workId);
			url="fooba.do?command=adminProductList";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
