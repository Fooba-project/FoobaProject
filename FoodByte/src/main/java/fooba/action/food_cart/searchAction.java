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

public class searchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="search";
		HttpSession session=request.getSession();
			
		String key="";
		if(request.getParameter("key")!=null) {
			key=request.getParameter("key");
			session.setAttribute("key", key);
		}else if(session.getAttribute("key")!=null) {
			key=(String)session.getAttribute("key");
		}else {
			session.removeAttribute("key");
		}
		CartDao cdao=CartDao.getInstance();
		ArrayList<RestaurantVO>searchList=cdao.searchKey(key);
		
		request.setAttribute("RList", searchList);
		request.setAttribute("key", key);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
