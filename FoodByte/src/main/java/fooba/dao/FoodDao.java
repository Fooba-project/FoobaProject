package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fooba.VO.FoodmenuVO;
import fooba.util.Dbman;

public class FoodDao {
	private FoodDao() {}
	private static FoodDao itc = new FoodDao();
	public static FoodDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void Method() {
		con = Dbman.getConnection();
		String sql = ""; 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();} 
		finally {Dbman.close(con, pstmt, rs);}
	}

	public FoodmenuVO selectFood(int rseq) {
		con = Dbman.getConnection();
		FoodmenuVO fvo = null;
		String sql = "select * from foodmenu where rseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,rseq);
			rs = pstmt.executeQuery();
			rs.next();
			fvo=new FoodmenuVO();
			fvo.setFimage(rs.getString("fimage").replace(".jfif",""));
			fvo.setRseq(rs.getInt("rseq"));
			fvo.setFname(rs.getString("fname"));
			System.out.println(rs.getString("fname"));
		} catch (SQLException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();} 
		finally {Dbman.close(con, pstmt, rs);}
		return fvo;
	}

	public FoodmenuVO getFoodDetail(int fseq) {
		FoodmenuVO fvo=null;
		con=Dbman.getConnection();
		String sql="select*from foodmenu where fseq=?";
			
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, fseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				fvo.setRseq(rs.getInt("rseq"));
				fvo.setFseq(rs.getInt("fseq"));
				fvo.setFname(rs.getString("fname"));
				fvo.setFprice(rs.getInt("fprice"));
				fvo.setFimage(rs.getString("fimage"));
				fvo.setFcontent(rs.getString("fcontent"));
				fvo.setFside1(rs.getString("fside1"));
				fvo.setFsideprice1(rs.getInt("fsideprice1"));
				fvo.setFside1(rs.getString("fside2"));
				fvo.setFsideprice1(rs.getInt("fsideprice2"));
				fvo.setFside1(rs.getString("fside3"));
				fvo.setFsideprice1(rs.getInt("fsideprice3"));
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return fvo;
	}
	
	
}
