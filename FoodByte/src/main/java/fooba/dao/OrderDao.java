package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import fooba.VO.OrderDetailVO;
import fooba.VO.OrderVO;
import fooba.VO.OrderViewVO;
import fooba.VO.ReviewVO;
import fooba.util.Dbman;
import fooba.util.Paging;

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


	public ArrayList<OrderViewVO> selectOrderViewByOseq(int oseq) {
		ArrayList<OrderViewVO> list=new ArrayList<>();
		String sql="select*from order_view where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderViewVO ovo=new OrderViewVO();
				ovo.setOseq(oseq);
				ovo.setResult(rs.getInt("result"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setOadd1(rs.getString("oadd1"));
				ovo.setOadd2(rs.getString("oadd2"));
				ovo.setOphone(rs.getString("ophone"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setFseq(rs.getInt("fseq"));
				ovo.setSideyn1(rs.getInt("sideyn1"));
				ovo.setSideyn2(rs.getInt("sideyn2"));
				ovo.setSideyn3(rs.getInt("sideyn3"));
				ovo.setNick(rs.getString("nick"));
				ovo.setMadd1(rs.getString("madd1"));
				ovo.setMadd2(rs.getString("madd2"));
				ovo.setMphone(rs.getString("mphone"));
				ovo.setFname(rs.getString("fname"));
				ovo.setFprice(rs.getInt("fprice"));
				ovo.setFside1(rs.getString("fside1"));
				ovo.setFsideprice1(rs.getInt("fsideprice1"));
				ovo.setFside2(rs.getString("fside2"));
				ovo.setFsideprice2(rs.getInt("fsideprice2"));
				ovo.setFside3(rs.getString("fside3"));
				ovo.setFsideprice3(rs.getInt("fsideprice3"));
				ovo.setFimage(rs.getString("fimage"));
				ovo.setFcontent(rs.getString("fcontent"));
				ovo.setRname(rs.getString("rname"));
				ovo.setRseq(rs.getInt("rseq"));
				ovo.setRimage(rs.getString("rimage"));
				ovo.setRtip(rs.getInt("rtip"));
				ovo.setRyn(rs.getInt("ryn"));		
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

	
		public ArrayList<OrderVO> selectOrdersById(String id, Paging paging) {
			ArrayList<OrderVO> list=new ArrayList<>();
			con=Dbman.getConnection();
			String sql = "select * from ("
					+ "select * from ("
					+ "select rownum as rn, b.* from ((select * from orders where id=? order by oseq desc) b)"
					+ ") where rn>=?"
					+ ") where rn<=?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
				rs=pstmt.executeQuery();
				while(rs.next()) {
					OrderVO ovo=new OrderVO();
					ovo.setOseq(rs.getInt("oseq"));
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setId(rs.getString("id"));
					ovo.setRideryn(rs.getInt("rideryn"));
					ovo.setPlasticyn(rs.getInt("plasticyn"));
					ovo.setPayment(rs.getInt("payment"));
					ovo.setResult(rs.getInt("result"));
					ovo.setAddress1(rs.getString("address1"));
					ovo.setAddress2(rs.getString("address2"));
					ovo.setTotalprice(rs.getInt("totalprice"));
					ovo.setPhone(rs.getString("phone"));
					list.add(ovo);
				}
			} catch (SQLException e) {	e.printStackTrace();
			}finally {Dbman.close(con, pstmt, rs);}
			return list;
		}


	public ArrayList<OrderVO> selectOrdersIngById(String id, Paging paging) {
		ArrayList<OrderVO> list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, b.* from ((select * from orders where id=? and result in(0,1,2) order by oseq desc) b)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo=new OrderVO();
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setResult(rs.getInt("result"));
				ovo.setAddress1(rs.getString("address1"));
				ovo.setAddress2(rs.getString("address2"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				ovo.setPhone(rs.getString("phone"));
				list.add(ovo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}




	public OrderVO getOrderbyOseq(int oseq) {
		OrderVO ovo = null;
		con=Dbman.getConnection();
		String sql="select * from orders where oseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ovo=new OrderVO();
				ovo.setOseq(oseq);
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setResult(rs.getInt("result"));
				ovo.setAddress1(rs.getString("address1"));
				ovo.setAddress2(rs.getString("address2"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				ovo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return ovo;
	}

	

	public int getOrderIngCount(String id) {
			int cnt = 0;
			con = Dbman.getConnection();
			String sql = "select count(rownum) as cnt from orders where id=? and result in(0,1,2)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					cnt = rs.getInt("cnt");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Dbman.close(con, pstmt, rs);
			}
			return cnt;
	}
	

	public int getOrderAllCount(String id) {
		int cnt = 0;
		con = Dbman.getConnection();
		String sql = "select count(rownum) as cnt from orders where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return cnt;
	}


	public int getOrderIngCountByRseq(int rseq) {
		int cnt = 0;
		con = Dbman.getConnection();
		String sql = "select count(rownum) as cnt from order_view where rseq=? and result in(0,1,2)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return cnt;
	}


	public ArrayList<OrderVO> selectOrdersIngByRseq(int rseq, Paging paging) {
		ArrayList<OrderVO> list=new ArrayList<>();
		con=Dbman.getConnection();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, b.* from ((select * from order_view where rseq=? and result in(0,1,2) order by oseq desc) b)"
				+ ") where rn>=?"
				+ ") where rn<=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo=new OrderVO();
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setId(rs.getString("id"));
				ovo.setRideryn(rs.getInt("rideryn"));
				ovo.setPlasticyn(rs.getInt("plasticyn"));
				ovo.setPayment(rs.getInt("payment"));
				ovo.setResult(rs.getInt("result"));
				ovo.setAddress1(rs.getString("oadd1"));
				ovo.setAddress2(rs.getString("oadd2"));
				ovo.setTotalprice(rs.getInt("totalprice"));
				list.add(ovo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}


	public ReviewVO getOrderReviewByOseq(int oseq) {
		ReviewVO rvo = null;
		con=Dbman.getConnection();
		String sql="select * from review where oseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rvo=new ReviewVO();
				rvo.setContent(rs.getString("content"));
				rvo.setId(rs.getString("id"));
				rvo.setImage(rs.getString("image"));
				rvo.setIndate(rs.getTimestamp("indate"));
				rvo.setNick(rs.getString("nick"));
				rvo.setOseq(oseq);
				rvo.setReply(rs.getString("reply"));
				rvo.setReplyyn(rs.getInt("replyyn"));
				rvo.setReview_seq(rs.getInt("review_seq"));
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setStar(rs.getInt("star"));
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return rvo;
	}


	



	
}
