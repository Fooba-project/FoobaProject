package fooba.action.mypage;

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
		
		//���޵� �Ķ���͵�� VO ��ü�� ä��� updateMember �޼���� ȸ�������� �������� ���ǰ��� ����
				//���� �������� main.jsp
				MemberDao mdao=MemberDao.getInstance();
				fooba.VO.MemberVO mvo=new MemberVO();
				
				mvo.setId(request.getParameter("id"));
				mvo.setPwd(request.getParameter("pwd"));
				mvo.setName(request.getParameter("name"));
				mvo.setEmail(request.getParameter("email"));
				mvo.setZip_num(request.getParameter("zip_num"));
				mvo.setAddress1(request.getParameter("address1"));
				mvo.setAddress2(request.getParameter("address2"));
				mvo.setPhone(request.getParameter("phone"));
				mvo.setNick(request.getParameter("nick"));
				
				
				
				int result=mdao.updateMember(mvo);
				
				
				if(result==1) {
					HttpSession session=request.getSession();
					session.setAttribute("loginUser", mvo); //���� �α��� ������ ������ �������� ��ü
					
					}
				
				RequestDispatcher dp=request.getRequestDispatcher("fooba.do?command=index");
				dp.forward(request, response);

	}

}
