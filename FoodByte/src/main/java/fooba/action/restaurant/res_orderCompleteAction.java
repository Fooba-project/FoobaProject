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
		
		System.out.println(request.getParameter("oseq"));
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		
		HttpSession session = request.getSession();
		RestaurantVO loginUser = (RestaurantVO) session.getAttribute("loginUser");
		
		System.out.println("oseq :"+oseq);
		
		String url="fooba.do?command=res_order&page=1&search=&key=";
		if(loginUser==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			OrderDao odao=OrderDao.getInstance();
			odao.nextOrderStatement(oseq);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		}

	}


