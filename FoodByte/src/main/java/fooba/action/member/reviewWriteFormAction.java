package fooba.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;

public class reviewWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="review/reviewwrite.jsp";
		HttpSession session=request.getSession();
		String loginUser=(String)session.getAttribute("loginUser");
		if(loginUser==null) {
			url="fooba.do?command=loginForm";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
