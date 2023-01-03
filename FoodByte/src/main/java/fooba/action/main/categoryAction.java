package fooba.action.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.FoodDao;
import fooba.dao.ResDao;

public class categoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="main/resList.jsp";
		HttpSession session=request.getSession();
		String kind= request.getParameter("kind");
		
		ResDao rdao=ResDao.getInstance();
		ArrayList<RestaurantVO>KindList=rdao.searchKind(kind);
		
		request.setAttribute("RList", KindList);

		FoodDao fdao=FoodDao.getInstance();
		ArrayList<FoodmenuVO> Foodlist =new ArrayList<FoodmenuVO>();
		
		for(RestaurantVO rvo : KindList) {	
			Foodlist.add(fdao.selectFood(rvo.getRseq()));
			
		}
		
		request.setAttribute("FList", Foodlist);
		request.getRequestDispatcher(url).forward(request, response);

		

	}

}
