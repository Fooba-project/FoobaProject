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
		
		String rid=request.getParameter("resid");
		String rpwd=request.getParameter("respw");
		String url="fooba.do?command=res_loginForm";
		
		ResDao rdao=ResDao.getInstance();
		RestaurantVO rvo=rdao.getRes(rid);
		
		if(rvo==null) request.setAttribute("message","아이디가 존재하지 않습니다.");
		
		else if(rvo.getRpwd()==null)request.setAttribute("message","패스워드 DB 오류. 관리자에게 문의하세요.");
		else if(!rvo.getRpwd().equals(rpwd))request.setAttribute("message","비밀번호가 틀렸습니다.");
		else if(rvo.getRpwd().equals(rpwd)) {
			url="fooba.do?command=res_foodmenu";
			HttpSession session=request.getSession();
			session.setAttribute("loginRes", rvo );
			/*가게 별점*/
			double star=0;
			star=rdao.starAvg(rvo.getRseq());
			int intstar=(int)star;
			double doublestar=(int)(star*10)/(double)10;
			session.setAttribute("intstar",intstar); //별 개수
			session.setAttribute("doublestar",doublestar); //별점(소수점까지)
			/**/
			session.removeAttribute("message");
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}
