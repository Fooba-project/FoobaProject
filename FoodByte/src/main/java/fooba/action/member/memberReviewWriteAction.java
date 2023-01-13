package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fooba.VO.MemberVO;
import fooba.VO.OrderVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.MemberDao;
import fooba.dao.OrderDao;

public class memberReviewWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url="fooba.do?command=memberOrderDetail&oseq="+oseq;
		OrderDao odao=OrderDao.getInstance();
		OrderVO ovo = odao.getOrderbyOseq(oseq);
		
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else if( !mvo.getId().equals(ovo.getId()) ) {
			session.removeAttribute("loginUser");
			session.setAttribute("message", "잘못된 접근입니다. 다시 로그인하세요.");
			url="fooba.do?command=loginForm";
		}else {
			ServletContext context=session.getServletContext();
	        String path=context.getRealPath("images/review");
	        MultipartRequest multi = new MultipartRequest(
	                 request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
	        );
	        MemberDao mdao = MemberDao.getInstance();
			ReviewVO rvvo=new ReviewVO();
			rvvo.setId(mvo.getId());
			rvvo.setNick(mvo.getNick());
			rvvo.setContent(multi.getParameter("reviewContent"));
			rvvo.setImage(multi.getFilesystemName("reviewImage"));
			rvvo.setOseq(Integer.parseInt(multi.getParameter("oseq")));
			rvvo.setRseq(Integer.parseInt(multi.getParameter("rseq")));
			rvvo.setStar(Integer.parseInt(multi.getParameter("reviewStar")));
	
			mdao.writeReview(rvvo);
			odao.reviewComplete(oseq);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
