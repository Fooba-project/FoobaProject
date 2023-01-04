package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResDao rdao=ResDao.getInstance();
		RestaurantVO rvo=new RestaurantVO();
		
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String path=context.getRealPath("resimage"); //�����̸����� ����
		
		MultipartRequest multi = new MultipartRequest(
				request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
		);
		
		rvo.setRid(request.getParameter("rid"));
		rvo.setRpwd(request.getParameter("rpwd"));
		rvo.setRname(request.getParameter("rname"));
		rvo.setOwnername(request.getParameter("ownername"));
		rvo.setRphone(request.getParameter("rphone"));
		rvo.setRaddress(request.getParameter("raddress"));
		rvo.setRimage(multi.getFilesystemName("image"));
		rvo.setContent(request.getParameter("content"));
		rvo.setHash(request.getParameter("hash"));
		rvo.setRbiznum(request.getParameter("rbiznum")));
		rvo.setKind(Integer.parseInt(request.getParameter("kind")));
		rvo.setRtip(Integer.parseInt(request.getParameter("rtip")));
		
		int result=rdao.insertRes(rvo);
		
		if(result==1)session.setAttribute("message","ȸ������ �Ϸ�! �α����ϼ���.");
		else session.setAttribute("message","ȸ������ ����.  ��� �����ϸ� �����ڿ��� �����ϼ���.");
		
		response.sendRedirect("fooba.do?command=res_loginForm");

	}

}
