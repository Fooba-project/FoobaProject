package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fooba.VO.OrderDetailVO;
import fooba.VO.OrderVO;
import fooba.VO.OrderViewVO;
import fooba.util.Dbman;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao itc = new OrderDao();
	public static OrderDao getInstance() {return itc;}
	
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


	public ArrayList<OrderViewVO> selectOrdersByOseq(int oseq) {
		ArrayList<OrderViewVO> list=new ArrayList<>();
		String sql="select*from order_view where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderViewVO ovo=new OrderViewVO();
				ovo.setFsideprice1(rs.getInt("fsideprice"));
				ovo.setFsideprice2(rs.getInt("fsideprice"));
				ovo.setFsideprice3(rs.getInt("fsideprice"));
				ovo.setFside1(rs.getString("fside1"));
				ovo.setFside2(rs.getString("fside2"));
				ovo.setFside3(rs.getString("fside3"));
				ovo.setFprice(rs.getInt("fprice"));
				ovo.setFname(rs.getString("fname"));
				ovo.setMphone(rs.getString("mphone"));
				ovo.setMadd2(rs.getString("madd2"));
				ovo.setMadd1(rs.getString("madd1"));
				ovo.setNick(rs.getString("nick"));
				ovo.setSideyn3(rs.getInt("sideyn3"));
				ovo.setSideyn2(rs.getInt("sideyn2"));
				ovo.setSideyn1(rs.getInt("sideyn1"));
				ovo.setFseq(rs.getInt("fseq"));
				ovo.setResult(rs.getInt("result"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setOadd1(rs.getString("oadd1"));
				ovo.setOadd2(rs.getString("oadd2"));
				ovo.setOphone(rs.getString("ophone"));
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				list.add(ovo);	
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);
		}
		return list;
	}

		public void nextOrderStatement(int oseq) {
		String sql="update orders set result=result+1 where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,oseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

//		public ArrayList<OrderVO> selectOrdersById(String id) {
//			ArrayList<OrderVO> list=new ArrayList<>();
//			con=Dbman.getConnection();
//			String sql="select *from order where id=? order by oseq desc";
//			try {
//				pstmt=con.prepareStatement(sql);
//				pstmt.setString(1, id);
//				rs=pstmt.executeQuery();
//				while(rs.next()) {
//					OrderVO ovo=new OrderVO();
//					ovo.setFsideprice1(rs.getInt("fsideprice"));
//					ovo.setFsideprice2(rs.getInt("fsideprice"));
//					ovo.setFsideprice3(rs.getInt("fsideprice"));
//					ovo.setFside1(rs.getString("fside1"));
//					ovo.setFside2(rs.getString("fside2"));
//					ovo.setFside3(rs.getString("fside3"));
//					ovo.setFprice(rs.getInt("fprice"));
//					ovo.setFname(rs.getString("fname"));
//					ovo.setMphone(rs.getString("mphone"));
//					ovo.setMadd2(rs.getString("madd2"));
//					ovo.setMadd1(rs.getString("madd1"));
//					ovo.setNick(rs.getString("nick"));
//					ovo.setSideyn3(rs.getInt("sideyn3"));
//					ovo.setSideyn2(rs.getInt("sideyn2"));
//					ovo.setSideyn1(rs.getInt("sideyn1"));
//					ovo.setFseq(rs.getInt("fseq"));
//					ovo.setResult(rs.getInt("result"));
//					ovo.setQuantity(rs.getInt("quantity"));
//					ovo.setOseq(rs.getInt("oseq"));
//					ovo.setIndate(rs.getTimestamp("indate"));
//					ovo.setId(rs.getString("id"));
//					ovo.setRideryn(rs.getInt("rideryn"));
//					ovo.setPlasticyn(rs.getInt("plasticyn"));
//					ovo.setPayment(rs.getInt("payment"));
//					ovo.setOadd1(rs.getString("oadd1"));
//					ovo.setOadd2(rs.getString("oadd2"));
//					ovo.setOphone(rs.getString("ophone"));
//					ovo.setOdseq(rs.getInt("odseq"));
//					ovo.setTotalprice(rs.getInt("totalprice"));
//					list.add(ovo);
//				}
//			} catch (SQLException e) {	e.printStackTrace();
//			}finally {Dbman.close(con, pstmt, rs);}
//			return list;
//		}
	
		public ArrayList<OrderVO> selectOrdersById(String id) {
			ArrayList<OrderVO> list=new ArrayList<>();
			con=Dbman.getConnection();
			String sql="select *from order where id=? order by oseq desc";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					OrderVO ovo=new OrderVO();
					ovo.setResult(rs.getInt("result"));
					ovo.setOseq(rs.getInt("oseq"));
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setId(rs.getString("id"));
					ovo.setRideryn(rs.getInt("rideryn"));
					ovo.setPlasticyn(rs.getInt("plasticyn"));
					ovo.setPayment(rs.getInt("payment"));
					ovo.setTotalprice(rs.getInt("totalprice"));
					list.add(ovo);
				}
			} catch (SQLException e) {	e.printStackTrace();
			}finally {Dbman.close(con, pstmt, rs);}
			return list;
		}


	public ArrayList<OrderVO> selectOrdersIngById(String id) {
		ArrayList<OrderVO> list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql="select * from orders where id=? and result in(0,1) order by oseq desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo=new OrderVO();
				ovo.setResult(rs.getInt("result"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				list.add(ovo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}


	public ArrayList<OrderDetailVO> getOrderDetailbyOseq(int oseq) {
		ArrayList<OrderDetailVO> list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql="select * from order_detail where oseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderDetailVO ovo=new OrderDetailVO();
				ovo.setFseq(rs.getInt("fseq"));
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setSideyn1(rs.getInt("sideyn1"));
				ovo.setSideyn2(rs.getInt("sideyn2"));
				ovo.setSideyn3(rs.getInt("sideyn3"));
				list.add(ovo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	
}
