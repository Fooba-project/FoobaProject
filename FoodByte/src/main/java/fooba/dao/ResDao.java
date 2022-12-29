package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.util.Dbman;


public class ResDao {
	private ResDao() {}
	private static ResDao itc = new ResDao();
	public static ResDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	public RestaurantVO getResInfo(int rseq) {
		RestaurantVO rvo=new RestaurantVO();
		con = Dbman.getConnection();
		String sql = "select*from restaurant where rseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			rvo.setRname(rs.getString("rname"));
			rvo.setOwnername(rs.getString("ownername"));
			rvo.setRphone(rs.getString("rphone"));
			rvo.setRaddress(rs.getString("raddress"));
			rvo.setRimage(rs.getString("rimage"));
			rvo.setContent(rs.getString("content"));
			rvo.setHash(rs.getString("hash"));
			rvo.setRseq(rs.getInt("rseq"));
			rvo.setRbiznum(rs.getInt("biznum"));
			rvo.setKind(rs.getInt("kind"));
			rvo.setRtip(rs.getInt("rtip"));
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {Dbman.close(con, pstmt, rs);}
		return rvo;
	}


	public ArrayList<FoodmenuVO> foodList(int rseq) {
		ArrayList<FoodmenuVO> list= new ArrayList<>();
		con = Dbman.getConnection();
		String sql="select*from foodmenu where rseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FoodmenuVO fvo=new FoodmenuVO();
				fvo.setRseq(rs.getInt("rseq"));
				fvo.setFseq(rs.getInt("fseq"));
				fvo.setFname(rs.getString("fname"));
				fvo.setFprice(rs.getInt("fprice"));
				fvo.setFimage(rs.getString("fimage"));
				fvo.setFcontent(rs.getString("fcontent"));
				fvo.setFside1(rs.getString("fside1"));
				fvo.setFsideprice1(rs.getInt("fsideprice1"));
				fvo.setFside2(rs.getString("fside2"));
				fvo.setFsideprice2(rs.getInt("fsideprice2"));
				fvo.setFside3(rs.getString("fside3"));
				fvo.setFsideprice3(rs.getInt("fsideprice3"));	
				list.add(fvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	
	
}
