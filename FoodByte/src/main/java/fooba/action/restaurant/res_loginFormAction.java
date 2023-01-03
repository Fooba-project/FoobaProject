package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;

public class res_loginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="restaurant/res_login.jsp";
		HttpSession session=request.getSession();
		RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
		
		if(rvo!=null) url="fooba.do?command=res_show";

		request.getRequestDispatcher(url).forward(request, response);
	}

}
