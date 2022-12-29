package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.action.Action;
import fooba.dao.AdminDao;

public class adminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String workId=request.getParameter("workId");
		String workPwd=request.getParameter("workPwd");
		
		String url="fooba.do?command=admin"; //������ �α���â
		
		AdminDao adao =AdminDao.getInstance();
		String adminUserPwd=adao.AdminCheck(workId);
		
		if(adminUserPwd==null)
			request.setAttribute("message", "���̵� �����ϴ�.");
		else if(!adminUserPwd.equals(workPwd))
			request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
		else if(adminUserPwd.equals(workPwd)) {
			HttpSession session=request.getSession();
			session.setAttribute("loginAdmin", workId);
			url="fooba.do?command=adminProductList";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
