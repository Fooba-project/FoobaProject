package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_reviewReplyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=res_review";
		
		HttpSession session=request.getSession();
		RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginUser");
		
		if(rvo==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			ResDao rdao=ResDao.getInstance();
			ReviewVO rvvo=new ReviewVO();
			
			rvvo.setRseq(Integer.parseInt(request.getParameter("rseq")));
			rvvo.setReply(request.getParameter("reply"));
			
			rdao.updateReply(rvvo);
			
			//url=url +"&rseq="+rvvo.getRseq();
		}
		response.sendRedirect(url);

	}

}
