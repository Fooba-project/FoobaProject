package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=new MemberVO();
		
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress1(request.getParameter("address1"));
		mvo.setAddress2(request.getParameter("address2"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setNick(request.getParameter("nick"));
		
		int result=mdao.insertMember(mvo);
		
		HttpSession session=request.getSession();
		if(result==1)session.setAttribute("message","회원가입 완료! 로그인하세요.");
		else session.setAttribute("message","회원가입 실패.  계속 실패하면 관리자에게 문의하세요.");
		
		response.sendRedirect("fooba.do?command=loginForm");

	}

}
