package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_foodmenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="restaurant/res_foodmenu.jsp";
		
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
	      if(rvo==null) {
	         url="fooba.do?command=res_loginForm";
	      }else {
	    	  
	    	ResDao rdao=ResDao.getInstance();
	  		ArrayList<FoodmenuVO>FoodList=rdao.foodList(rvo.getRseq());
	  		ArrayList<ReviewVO>reviewList=rdao.reviewList(rvo.getRseq());
	  		
	  		request.setAttribute("RestaurantVO", rvo);
	  		request.setAttribute("FoodList", FoodList);
	  		request.setAttribute("ReviewList",reviewList);
  	  
	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
