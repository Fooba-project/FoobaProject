package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_restaurantRestAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rseq=Integer.parseInt(request.getParameter("rseq"));
		
		String url = "fooba.do?command=res_foodmenu";
		
		HttpSession session = request.getSession();
		RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginRes");
	      if(rvo == null) {
	    	  url = "fooba.do?command=res_loginForm";
	      }else {
			ResDao rdao=ResDao.getInstance();
			rdao.restRes(rseq);
			rvo.setRyn(3);
			session.setAttribute("loginRes", rvo);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		}

	}