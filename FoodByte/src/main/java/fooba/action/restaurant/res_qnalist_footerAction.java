package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import fooba.VO.QnaVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;
import fooba.util.Paging;

public class res_qnalist_footerAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="restaurant/res_qnalist_footer.jsp";
		
		HttpSession session = request.getSession();
		RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginRes");	
		if(rvo==null)
			url="fooba.do?command=res_loginForm";		
		else {
			ResDao rdao=ResDao.getInstance();
			
			if(request.getParameter("start")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			int page=1;
			if(request.getParameter("page")!=null) { 
				page=Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page")!=null) { 
				page=(Integer)session.getAttribute("page");
			}else { 
				session.removeAttribute("page");
			}
			
			String key="";
			if(request.getParameter("key")!=null) {
				key=request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key")!=null) {
				key=(String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setDisplayRow(10);
			paging.setDisplayPage(10);
			
			int count = rdao.getAllCountForQna(key);
			paging.setTotalCount(count);
			
			
			ArrayList<QnaVO>qnaList=rdao.selectQna(paging,key);
			request.setAttribute("qnaList", qnaList);
			request.setAttribute("paging", paging); 
			request.setAttribute("key", key);
		}
		
		request.getRequestDispatcher(url).forward(request, response);



	}

}
