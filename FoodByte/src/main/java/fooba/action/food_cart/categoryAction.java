package fooba.action.food_cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.CartDao;

public class categoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		HttpSession session=request.getSession();
		String kind= request.getParameter("kind");
		
		CartDao cdao=CartDao.getInstance();
		ArrayList<RestaurantVO>KindList=cdao.searchKind(kind);
		
		request.setAttribute("RList", KindList);

		
		request.getRequestDispatcher(url).forward(request, response);

		

	}

}
