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
		String sql="select* from restaurant where kind=? and result='1'";
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

	public void insertCart(CartVO cvo) {
		con=Dbman.getConnection();
		String sql="insert into cart(cseq,quantity,id,fseq,sideyn1,sideyn2,sideyn3,cprice,cfname,rseq)"
				+ " values(cart_seq.nextVal,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cvo.getQuantity());
			pstmt.setString(2, cvo.getId());
			pstmt.setInt(3,cvo.getFseq());
			pstmt.setString(4, cvo.getSideyn1());
			pstmt.setString(5, cvo.getSideyn2());
			pstmt.setString(6, cvo.getSideyn3());
			pstmt.setInt(7, cvo.getCprice());
			pstmt.setString(8, cvo.getCfname());
			pstmt.setInt(9,cvo.getRseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
	}

	public ArrayList<CartVO> CartList(String id,int rseq) {
		ArrayList<CartVO> clist=new ArrayList<>();
		con=Dbman.getConnection();
		String sql="select * from cart where id=? and rseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, rseq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CartVO cvo=new CartVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setIndate(rs.getTimestamp("indate"));
				cvo.setId(rs.getString("id"));
				cvo.setFseq(rs.getInt("fseq"));
				cvo.setSideyn1(rs.getString("sideyn1"));
				cvo.setSideyn2(rs.getString("sideyn2"));
				cvo.setSideyn3(rs.getString("sideyn3"));
				cvo.setCprice(rs.getInt("cprice"));
				cvo.setCfname(rs.getString("cfname"));
				cvo.setRseq(rs.getInt("rseq"));
				clist.add(cvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return clist;
	}

	public int deletecart(int cseq) {
		int rseq = 0;
		con=Dbman.getConnection();
		String sql="select *from cart where cseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cseq);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				rseq=rs.getInt("rseq");
			}
		} catch (SQLException e1) {	e1.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		 sql="delete from cart where cseq=?";
		 con=Dbman.getConnection();		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con,pstmt,rs);}
		return rseq;
	}

	public int CartListSum(String id, int rseq) {
		con=Dbman.getConnection();
		String sql="select * from cart where id=? and rseq=?";
		int sum=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, rseq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sum=sum+rs.getInt("cprice");
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return sum;
		
	}

	
/*
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
*/
	
	
	
}
