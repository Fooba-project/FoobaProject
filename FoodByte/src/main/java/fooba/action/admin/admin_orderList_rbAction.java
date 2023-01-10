package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;
import fooba.dao.AdminDao;

public class admin_orderList_rbAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		
		HttpSession session = request.getSession();
		String adminId=(String) session.getAttribute("loginAdmin");
				
		String url="fooba.do?command=admin_orderList";
		if(adminId==null) {
			url="fooba.do?command=admin_loginForm";
		}else {
			AdminDao adao=AdminDao.getInstance();
			adao.orderRb(oseq);
			
		}
		response.sendRedirect(url);
	
		}

	}


