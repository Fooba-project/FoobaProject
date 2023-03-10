package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.ResDao;
import fooba.util.Paging;

public class res_reviewAction implements Action {
 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginRes");
		String url="restaurant/res_reviewList.jsp";	//레스토랑 리뷰관리로 이동
		
		if(rvo==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			ResDao rdao=ResDao.getInstance();
			
				
			
			int key=Integer.parseInt(request.getParameter("key"));
			ArrayList<ReviewVO>list=rdao.selectReview(rvo.getRseq(),key); 
			
	  		request.setAttribute("RestaurantVO", rvo);
			request.setAttribute("ReviewList",list);
		}
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
