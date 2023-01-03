package fooba.action.res_info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_menuDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String url="fooba.do?command=res_menu";
	      HttpSession session=request.getSession();
	      RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginUser");
	      if(rvo==null) {
	         url="fooba.do?command=res_loginFrom";
	      }else {

	         int fseq=(Integer.parseInt(request.getParameter("fseq")));
	         
	         ResDao rdao=ResDao.getInstance();
	         rdao.deleteFoodMenu(fseq);
	         url=url+"&rseq="+rvo.getRseq();

	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
