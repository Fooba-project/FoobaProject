package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}
