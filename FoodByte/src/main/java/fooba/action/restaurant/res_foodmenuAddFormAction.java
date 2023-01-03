package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;

public class res_foodmenuAddFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String url="restaurant/resfoodMenuAdd.jsp";
	      
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO) session.getAttribute("loginRes");
	      
	         if(rvo==null) 
	            url="fooba.do?command=res_loginForm";
	      
	      RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	      dispatcher.forward(request, response);

	}

}
