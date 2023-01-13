package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;
import fooba.dao.ResDao;

public class res_FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ownername=request.getParameter("username");
		String rphone=request.getParameter("userphone");
		ResDao rdao=ResDao.getInstance();
		String id = rdao.memberFindId(ownername, rphone);
		String url="fooba.do?command=res_loginForm";
		System.out.println("id : "+id);
		request.setAttribute("message","귀하의 아이디는 '"+id+"'입니다.");
		
		if(id==null || id=="") {request.setAttribute("message","일치하는 정보가 없습니다. 다시 입력하세요.");
			url="fooba.do?command=res_FindIdForm"; }
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
