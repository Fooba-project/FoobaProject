package fooba.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.OrderViewVO;
import fooba.action.Action;
import fooba.dao.AdminDao;
import fooba.util.Paging;

public class admin_orderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="admin/admin_orderlist.jsp";
		
		HttpSession session=request.getSession();
		String adminId=(String) session.getAttribute("loginAdmin");
		if(adminId==null)
			url="fooba.do?command=admin_loginForm";
		
		else {
			AdminDao adao=AdminDao.getInstance();
			
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
			
			int count = adao.getOrderCount("order_view","id","rname",key); 
			paging.setTotalCount(count);
			
			
			ArrayList<OrderViewVO>orderList=adao.selectOrder(paging,key);
			
			request.setAttribute("orderList", orderList);
			request.setAttribute("paging", paging); 
			request.setAttribute("key", key);
			
			
			
		}
		request.getRequestDispatcher(url).forward(request, response);

	}


}
