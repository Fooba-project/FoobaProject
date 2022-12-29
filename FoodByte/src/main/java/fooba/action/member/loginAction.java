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

public class loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=mdao.getMember(id);
		
		//getMember�޼��带 �����, ���� ��Ȳ�� �´� if���� �̿��ؼ� �α����� ����
		//���� �������� main.jsp
		
		String url="member/login.jsp";
		
		if(mvo==null) request.setAttribute("message","�������� �ʴ� ���̵��Դϴ�.");
		else if(mvo.getPwd()==null)request.setAttribute("message","�ý��� ����. �����ڿ��� �����ϼ���");
		else if(!mvo.getPwd().equals(pwd))request.setAttribute("message","��й�ȣ�� Ʋ���ϴ�.");
		else if(mvo.getPwd().equals(pwd)) {
			url="fooba.do?command=index";
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",mvo);
			
		}else request.setAttribute("message","�α��� ����, �����ڿ��� �����ϼ���.");
		
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
