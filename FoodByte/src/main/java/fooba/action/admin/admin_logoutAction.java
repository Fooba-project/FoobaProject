package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;

public class admin_logoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.removeAttribute("loginAdmin");
		session.removeAttribute("message");
		request.getRequestDispatcher("fooba.do?command=admin_loginForm").forward(request, response);
		
	}

}
