package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_showAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="restaurant/res_show.jsp";
		
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginUser");
	      if(rvo==null) {
	         url="fooba.do?command=res_loginForm";
	      }else {
	    	  
	    	ResDao rdao=ResDao.getInstance();
	  		int rseq=Integer.parseInt(request.getParameter("rseq"));
	  		ArrayList<FoodmenuVO>FoodList=rdao.foodList(rseq);
	  		
	  		request.setAttribute("RestaurantVO", rvo);
	  		request.setAttribute("FoodList", FoodList);
    	  
	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
