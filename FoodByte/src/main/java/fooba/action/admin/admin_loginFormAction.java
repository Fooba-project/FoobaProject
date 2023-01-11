package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;

public class admin_loginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		HttpSession session=request.getSession();
		String adminId=(String) session.getAttribute("loginAdmin");
		if(adminId!=null) url="fooba.do?command=admin_restaurantList";
		else url="admin/adminLogin.jsp";
			
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}