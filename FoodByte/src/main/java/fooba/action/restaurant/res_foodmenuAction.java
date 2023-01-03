package fooba.action.res_info;

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

public class res_menuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="restaurant/resMenu.jsp";
	      
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO) session.getAttribute("loginUser");
	      
	         if(rvo==null) {
	            url="fooba.do?command=res_loginForm";
	         }else {
	            
	            int rseq=Integer.parseInt(request.getParameter("rseq"));
	            
	            ResDao rdao=ResDao.getInstance();
	            
	            ArrayList<FoodmenuVO>FoodList=rdao.foodList(rseq);
	            
	            request.setAttribute("FoodList", FoodList);
	         }
	      request.getRequestDispatcher(url).forward(request, response);
	}

}
