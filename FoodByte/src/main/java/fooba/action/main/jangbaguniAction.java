package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class jangbaguniAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="main/popupMenu.jsp";
		
		
		request.setAttribute("rseq", request.getParameter("rseq"));
		request.setAttribute("jangresult", "1");
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
