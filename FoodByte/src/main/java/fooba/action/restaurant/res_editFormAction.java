package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_editFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   	HttpSession session=request.getSession();
		   	String url="restaurant/res_updateForm.jsp";
		   	
		      RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
		      if(rvo==null) {
		        url="fooba.do?command=res_loginForm";
		      }else {
		    	  
		    	ResDao rdao=ResDao.getInstance();
		  				  		  		
		  		request.setAttribute("RestaurantVO", rvo);
		  			  	  
		      }
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
		

	}

}
