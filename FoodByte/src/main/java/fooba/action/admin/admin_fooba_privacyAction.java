package fooba.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class admin_fooba_privacyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/admin_fooba_privacy.jsp";
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
