package fooba.action.res_info;

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
import fooba.util.Paging;

public class res_menuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="restaurant/resMenu.jsp";
		
		HttpSession session=request.getSession();
		RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginUser");
		
			if(rvo==null) {
				url="fooba.do?command=res_loginForm";
			}else {
			ResDao rdao=ResDao.getInstance();

			ArrayList<FoodmenuVO> list=rdao.selectMenu(rvo.getRseq()); 
			request.setAttribute("MenuList", list);
		}
	request.getRequestDispatcher(url).forward(request, response);
	}

}
