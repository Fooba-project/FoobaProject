package fooba.action.res_info;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;

public class res_menuUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="restaurant/resMenuAdd.jsp";
	      
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO) session.getAttribute("loginUser");
	      
	         if(rvo==null) 
	            url="fooba.do?command=res_loginForm";
	      
	      RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);


	}

}
