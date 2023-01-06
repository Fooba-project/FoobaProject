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

public class searchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String url="main/resList.jsp";
		HttpSession session=request.getSession();

		String hash=request.getParameter("hash");
		String search = request.getParameter("searchtext");
		System.out.println("search : "+search);
		if (search==null) {
			search = hash;
		}
			
		ResDao rdao=ResDao.getInstance();
		ArrayList<RestaurantVO>searchList=rdao.searchKey(search);
		
		for (RestaurantVO rvo : searchList) {
			rvo.setFimage( rdao.FimagebyRseq( rvo.getRseq() ) );
		}
		
		if (hash==null) {
			request.setAttribute("search", search);
		}
		
		request.setAttribute("RList", searchList);
		request.getRequestDispatcher(url).forward(request, response);

	}

}