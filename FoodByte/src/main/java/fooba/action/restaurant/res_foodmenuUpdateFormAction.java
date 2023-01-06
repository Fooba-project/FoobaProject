package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.FoodDao;
import fooba.dao.ResDao;

public class res_foodmenuUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="restaurant/res_foodmenuUpdateForm.jsp";
	      
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO) session.getAttribute("loginRes");
	      
	         if(rvo==null) 
	            url="fooba.do?command=res_loginForm";
	         else {
	        	 
	        	 int fseq=Integer.parseInt(request.getParameter("fseq"));
	        	 
		        	 
		        	 FoodDao fdao=FoodDao.getInstance();
		        	 FoodmenuVO fvo = fdao.selectFood(fseq);	
		        	 
		 	  		 request.setAttribute("RestaurantVO", rvo);
		 	  		 request.setAttribute("FoodmenuVO", fvo);
		         }
	         
	      
	      request.getRequestDispatcher(url).forward(request, response);


	}

}
