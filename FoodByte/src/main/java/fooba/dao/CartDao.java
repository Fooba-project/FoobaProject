package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fooba.VO.CartVO;
import fooba.VO.RestaurantVO;
import fooba.util.Dbman;

public class CartDao {
	private CartDao() {}
	private static CartDao itc = new CartDao();
	public static CartDao getInstance() {return itc;}
	
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

	public ArrayList<RestaurantVO> searchKey(String key) {
		ArrayList<RestaurantVO>list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql="select*from search where (fname='%'||?||'%' or rname='%'||?||'%' or hash='%'||?||'%') and result='1'";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setString(3, key);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RestaurantVO rvo=new RestaurantVO();
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setRname(rs.getString("rname"));
				rvo.setRimage(rs.getString("rimage"));
				rvo.setKind(rs.getInt("kind"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public ArrayList<RestaurantVO> searchKind(String kind) {
		ArrayList<RestaurantVO>list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql="select from restaurant where kind=? and result='1'";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RestaurantVO rvo=new RestaurantVO();
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setRname(rs.getString("rname"));
				rvo.setRimage(rs.getString("rimage"));
				rvo.setKind(rs.getInt("kind"));
				list.add(rvo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	

	public void deleteCart(int cseq) {
		
		String sql="delete from cart where cseq=?";
		con=Dbman.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con,pstmt,rs);}
		
	}
	
	
}
