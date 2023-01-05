package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.OrderDao;

public class res_orderCompleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		
		HttpSession session = request.getSession();
		RestaurantVO loginUser = (RestaurantVO) session.getAttribute("loginUser");
		
		String url="";
		if(loginUser==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			
			OrderDao odao=OrderDao.getInstance();
			odao.nextOrderStatement(oseq);
			url="restaurant/orderDetail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		}

	}


