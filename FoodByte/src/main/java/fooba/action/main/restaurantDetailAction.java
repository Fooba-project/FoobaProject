package fooba.action.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class restaurantDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rseq=Integer.parseInt(request.getParameter("rseq"));
		
		ResDao rdao=ResDao.getInstance();
		
		RestaurantVO rvo=rdao.getResInfo(rseq);
		ArrayList<FoodmenuVO>foodmenuList=rdao.foodList(rseq);
		ArrayList<ReviewVO>reviewList=rdao.reviewList(rseq);
		
		request.setAttribute("RestaurantVO", rvo);
		request.setAttribute("FoodmenuList", foodmenuList);
		request.setAttribute("ReviewList",reviewList);
		
		request.getRequestDispatcher("/main/menuDetail.jsp").forward(request, response);
	}

}
