package fooba.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.AdminDao;
import fooba.util.Paging;

public class admin_memberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/admin_memlist.jsp";
		
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
			
			int count = adao.getMemberCount("member","id",key);
			paging.setTotalCount(count);
			
			
			ArrayList<MemberVO>list=adao.selectMember(paging,key);
			
			request.setAttribute("memberList", list);
			request.setAttribute("paging", paging); 
			request.setAttribute("key", key); 
			
			
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
