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
		
		if(rvo==null) request.setAttribute("message","존재하지 않는 아이디입니다.");
		else if(rvo.getRpwd()==null)request.setAttribute("message","시스템 오류. 관리자에게 문의하세요");
		else if(!rvo.getRpwd().equals(rpwd))request.setAttribute("message","비밀번호가 틀립니다.");
		else if(rvo.getRpwd().equals(rpwd)) {
			url="fooba.do?command=res_info";
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",rvo);
			
		}else request.setAttribute("message","로그인 실패, 관리자에게 문의하세요.");
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
