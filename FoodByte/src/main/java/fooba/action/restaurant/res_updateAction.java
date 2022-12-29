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
import fooba.dao.AdminDao;
import fooba.dao.ResDao;

public class res_updateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=res_info";
		HttpSession session=request.getSession();
		String avo=(String)session.getAttribute("loginUser");
		if(avo==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			RestaurantVO rvo=new RestaurantVO();
			ServletContext context=session.getServletContext();
			String path=context.getRealPath("resimage"); //폴더 이미지로 변경
			
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			ResDao rdao=ResDao.getInstance();
			
			rvo.setRid(request.getParameter("rid"));
			rvo.setRpwd(request.getParameter("rpwd"));
			rvo.setRname(request.getParameter("rname"));
			rvo.setOwnername(request.getParameter("ownername"));
			rvo.setRphone(request.getParameter("rphone"));
			rvo.setRaddress(request.getParameter("raddress"));
			rvo.setContent(request.getParameter("content"));
			rvo.setHash(request.getParameter("hash"));
			rvo.setKind(Integer.parseInt(request.getParameter("kind")));
			rvo.setRtip(Integer.parseInt(request.getParameter("rtip")));
			if(multi.getFilesystemName("rimage")==null)rvo.setRimage(multi.getParameter("oldImage"));
			else rvo.setRimage(multi.getFilesystemName("rimage"));
			
			
			rdao.updateRes(rvo);
			
		}
		request.getRequestDispatcher(url).forward(request, response);

		
	}

}
