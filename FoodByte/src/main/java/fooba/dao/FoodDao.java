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
	
	
}
