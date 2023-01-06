package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class admin_restaurantDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/admin_resdetail.jsp";
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "fooba.do?command=admin"; 
		} else {
			
			String rseq = request.getParameter("rseq");
			ResDao rdao = ResDao.getInstance();
			RestaurantVO rvo = rdao.getRseq(rseq);
			request.setAttribute("restaurantVO", rvo);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
