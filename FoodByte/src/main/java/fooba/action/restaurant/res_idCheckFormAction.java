package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_idCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid= request.getParameter("rid");
		ResDao rdao=ResDao.getInstance();
		RestaurantVO rvo=rdao.getRes(rid);
		
		if(rvo==null)request.setAttribute("result",-1);
		else request.setAttribute("result", 1);
		
		request.setAttribute("rid", rid);
		
		RequestDispatcher dp=request.getRequestDispatcher("member/idcheck.jsp");
		dp.forward(request, response);

	}

}
