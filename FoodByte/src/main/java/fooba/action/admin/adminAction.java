package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class adminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="admin/adminLogin.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
