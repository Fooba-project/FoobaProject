package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;
import fooba.dao.ResDao;

public class res_FindPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ownername=request.getParameter("username");
		String rphone=request.getParameter("userphone");
		String rid =request.getParameter("userid");
		ResDao rdao=ResDao.getInstance();
		String raddress = rdao.memberFindPw(ownername, rphone, rid);
		String url="fooba.do?command=res_loginForm";
		System.out.println(raddress);
		request.setAttribute("message","비밀번호 재설정 링크를 귀하의 전화번호("+rphone+")로 보냈습니다.");
		if(raddress==null || raddress=="") {request.setAttribute("message","일치하는 정보가 없습니다. 다시 입력하세요.");
			url="fooba.do?command=res_FindPwForm"; }
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
