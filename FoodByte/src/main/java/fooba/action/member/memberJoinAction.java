package fooba.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		if (session.getAttribute("login_message_reset")==null) {
			MemberDao mdao=MemberDao.getInstance();
			MemberVO mvo=new MemberVO();
			
			mvo.setId(request.getParameter("userid"));
			mvo.setPwd(request.getParameter("userpwd"));
			mvo.setName(request.getParameter("username"));
			mvo.setEmail(request.getParameter("useremail"));
			mvo.setZip_num(request.getParameter("userzip_num"));
			mvo.setAddress1(request.getParameter("useraddress1"));
			mvo.setAddress2(request.getParameter("useraddress2"));
			mvo.setPhone(request.getParameter("userphone"));
			if(request.getParameter("usernick")==null || request.getParameter("usernick").equals("")) mvo.setNick(request.getParameter("username"));
			else mvo.setNick(request.getParameter("usernick"));
			
			int result=mdao.insertMember(mvo);
			session.setAttribute("login_message_reset", "1");
			
			if(result==1)session.setAttribute("message","회원가입 완료. 로그인하세요.");
			else session.setAttribute("message","회원가입 실패. 관리자에게 문의하세요.");
		} else {
			session.removeAttribute("message");
		}
		request.getRequestDispatcher("fooba.do?command=loginForm").forward(request, response);

	}

}
