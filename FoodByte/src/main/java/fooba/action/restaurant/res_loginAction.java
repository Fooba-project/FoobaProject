package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.MemberDao;
import fooba.dao.ResDao;

public class res_loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid=request.getParameter("rid");
		String rpwd=request.getParameter("rpwd");
		
		ResDao rdao=ResDao.getInstance();
		RestaurantVO rvo=rdao.getRes(rid);
				
		String url="restaurant/login.jsp";
		
		if(rvo==null) request.setAttribute("message","�������� �ʴ� ���̵��Դϴ�.");
		else if(rvo.getRpwd()==null)request.setAttribute("message","�ý��� ����. �����ڿ��� �����ϼ���");
		else if(!rvo.getRpwd().equals(rpwd))request.setAttribute("message","��й�ȣ�� Ʋ���ϴ�.");
		else if(rvo.getRpwd().equals(rpwd)) {
			url="fooba.do?command=res_info";
			HttpSession session=request.getSession();
			session.setAttribute("loginRes",rvo);
			
		}else request.setAttribute("message","�α��� ����, �����ڿ��� �����ϼ���.");
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
