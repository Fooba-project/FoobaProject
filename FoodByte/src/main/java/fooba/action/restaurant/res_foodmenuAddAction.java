package fooba.action.res_info;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_menuAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=res_menu";
        HttpSession session=request.getSession();
        RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginUser");
        if(rvo==null) {
           url="fooba.do?command=res_loginFrom";
        }else {
           FoodmenuVO fvo=new FoodmenuVO();
           ServletContext context=session.getServletContext();
           String path=context.getRealPath("foodmenu_images");
           
           MultipartRequest multi = new MultipartRequest(
                 request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
           );
           
           fvo.setRseq(Integer.parseInt(multi.getParameter("rseq")));
           fvo.setFname(multi.getParameter("fname"));
           fvo.setFprice(Integer.parseInt(multi.getParameter("fprice")));
           fvo.setFcontent(multi.getParameter("fcontent"));
           fvo.setFside1(multi.getParameter("fside1"));
           fvo.setFsideprice1(Integer.parseInt(multi.getParameter("fsideprice1")));
           fvo.setFside1(multi.getParameter("fside2"));
           fvo.setFsideprice1(Integer.parseInt(multi.getParameter("fsideprice2")));
           fvo.setFside1(multi.getParameter("fside3"));
           fvo.setFsideprice1(Integer.parseInt(multi.getParameter("fsideprice3")));
           if(multi.getFilesystemName("fimage")==null)fvo.setFimage(multi.getParameter("oldImage"));
           else fvo.setFimage(multi.getFilesystemName("fimage"));
           
           ResDao rdao=ResDao.getInstance();
           rdao.addFoodMenu(fvo);
           url=url+"&rseq="+fvo.getRseq();
           
        }
        request.getRequestDispatcher(url).forward(request, response);


	}

}
