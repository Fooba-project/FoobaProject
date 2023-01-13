package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class res_FindPwFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="restaurant/res_FindPw.jsp";
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
