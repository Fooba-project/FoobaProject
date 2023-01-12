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

public class memberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//전달된 파라미터들로 VO 객체를 채우고 updateMember 메서드로 회원정보를 수정한후 세션값을 수정
			//최종 목적지는 main.jsp
			
			MemberDao mdao=MemberDao.getInstance();
			MemberVO mvo = new MemberVO();
			
			String id = request.getParameter("userid").replace("id : ", "").replace(" (수정 불가)","");
			mvo = mdao.getMember(id);
			
			String pwd = request.getParameter("userpwd");
			if (pwd == null || pwd=="") {
			} else mvo.setPwd(pwd);
			
			String email = request.getParameter("useremail");
			if (email==null || email=="") {
			} else mvo.setEmail(email);

			String zip_num = request.getParameter("userzip_num");
			if(zip_num==null || zip_num=="") {
			}else mvo.setZip_num(zip_num);
			
			String address1 = request.getParameter("useraddress1");
			if(address1==null || address1=="") {
			}else mvo.setAddress1(address1);
			
			String address2 = request.getParameter("useraddress2");
			if(address2==null || address2=="") {
			}else mvo.setAddress2(address2);
			
			String phone = request.getParameter("userphone");
			if(phone==null || phone=="") {
			}else mvo.setPhone(phone);
			
			String nick = request.getParameter("usernick");
			if(nick==null || nick=="") {
			}else mvo.setNick(nick);
			
			System.out.println("mvo " + mvo.getId() + mvo.getPwd() +  mvo.getEmail() );
			int result=mdao.updateMember(mvo);
			
			if(result==1) {
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", mvo); //세션 로그인 정보를 수정된 내용으로 교체
			}
			
			request.getRequestDispatcher("fooba.do?command=memberUpdateForm").forward(request, response);
			

	}

}
