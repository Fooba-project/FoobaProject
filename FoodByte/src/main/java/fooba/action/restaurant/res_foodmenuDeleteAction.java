package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_foodmenuDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String url="fooba.do?command=res_foodmenu";
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
	      if(rvo==null) {
	         url="fooba.do?command=res_loginForm";
	      }else {
	         int fseq=(Integer.parseInt(request.getParameter("fseq")));	  
	         System.out.println(request.getParameter("fseq"));
	         ResDao rdao=ResDao.getInstance();
	         rdao.deleteFoodMenu(fseq);
	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
