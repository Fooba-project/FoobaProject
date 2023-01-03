package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.OrderViewVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.OrderDao;
import fooba.dao.ResDao;

public class res_orderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String url = "restaurant/orderList.jsp";
	      HttpSession session = request.getSession();
	      Integer rseq = Integer.parseInt(request.getParameter("rseq"));
	      RestaurantVO mvo = (RestaurantVO) session.getAttribute("loginUser");
	      if(mvo == null) {
	         url = "fooba.do?command=res_loginForm";
	      }else {         
	         ResDao rdao = ResDao.getInstance();
	         ArrayList<OrderViewVO>list = rdao.selectOrdersByRseq(rseq);
	      
	         request.setAttribute("orderList", list);
	         
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      

	}

}