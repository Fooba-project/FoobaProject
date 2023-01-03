package fooba.action.food_cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class foodDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rseq=Integer.parseInt(request.getParameter("rseq"));
		
		ResDao rdao=ResDao.getInstance();
		
		RestaurantVO rvo=rdao.getResInfo(rseq);
		ArrayList<FoodmenuVO>FoodList=rdao.foodList(rseq);
		
		request.setAttribute("RestaurantVO", rvo);
		request.setAttribute("FoodList", FoodList);
		
		request.getRequestDispatcher("").forward(request, response);
	}

}
