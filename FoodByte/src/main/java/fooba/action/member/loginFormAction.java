package fooba.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class loginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="member/login.jsp";
		
		//login ������ ȭ��� logout �� ������ ȭ���� �����ϹǷ� �α��λ��¸� üũ���� �ʰ�
		//header.jsp���� �α��� ���¿� ���� �޴��� �ٸ� �����ִ� ������ ������ �ȴ�.
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
