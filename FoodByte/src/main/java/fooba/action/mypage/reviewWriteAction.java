package fooba.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class reviewWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="review/reviewList.jsp";
		
		HttpSession session=request.getSession();
		String loginUser=(String)session.getAttribute("loginUser");
		if(loginUser==null) {
			url="fooba.do?command=loginForm";
		}
		MemberDao mdao=MemberDao.getInstance();
		ReviewVO rvvo=new ReviewVO();
		
		rvvo.setId(request.getParameter("id"));
		
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
