package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fooba.VO.MemberVO;
import fooba.VO.OrderViewVO;
import fooba.VO.QnaVO;
import fooba.VO.RestaurantVO;
import fooba.util.Dbman;
import fooba.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public String workerCheck(String workId) {
		String pwd = null;
		
		String sql = "select * from admin where id = ?";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			if( rs.next() )
				pwd = rs.getString("pwd");
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return pwd;
	}
	
 
	public String AdminCheck(String id) {	
		String pwd=null;
		String sql= "select*from admin where id=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next())
				pwd=rs.getString("pwd");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return pwd;
	}

	public int getAllCount(String tableName, String fieldName, String key,String result) {
		int count=0;
		
		con=Dbman.getConnection();
		String sql="select count(*) as cnt from "+tableName + " where "+fieldName +" like '%'||?||'%'";// and ryn=?;
		//key 값만 따로 하는 이유는 null 이 들어갔을때 오류가 날 수있기때문
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			//pstmt.setString(2, result);
			rs=pstmt.executeQuery();
			if(rs.next())count=rs.getInt("cnt");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return count;
	}

	public ArrayList<RestaurantVO> selectRes(Paging paging, String key,String result) {
		ArrayList<RestaurantVO> list=new ArrayList<RestaurantVO>();
		con=Dbman.getConnection();
		String sql="select * from ("
				+"select * from("
				+ "select rownum as rn, r.* from((select * from restaurant where rname like '%'||?||'%' order by rseq desc) r )"
				+ ") where rn>=?"
				+ ") where rn<=?"; //ryn=?
		//오타 제대로 확인
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			//pstmt.setString(2, result);
			pstmt.setInt(2,paging.getStartNum());
			pstmt.setInt(3,paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RestaurantVO rvo=new RestaurantVO();
				rvo.setRid(rs.getString("rid"));
				rvo.setRpwd(rs.getString("rpwd"));
				rvo.setRname(rs.getString("rname"));
				rvo.setOwnername(rs.getString("ownername"));
				rvo.setRphone(rs.getString("rphone"));
				rvo.setRaddress(rs.getString("raddress"));
				rvo.setRimage(rs.getString("rimage"));
				rvo.setContent(rs.getString("content"));
				rvo.setHash(rs.getString("hash"));
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setRbiznum(rs.getString("rbiznum"));
				rvo.setKind(rs.getInt("kind"));
				rvo.setRtip(rs.getInt("rtip"));
				rvo.setRyn(rs.getInt("ryn"));
				list.add(rvo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public int getOrderCount(String tableName, String fieldName, String field2, String key) {
		int count=0;
		
		con=Dbman.getConnection();
		String sql="select count(*) as cnt from "+tableName + " where "+fieldName +" like '%'||?||'%' or "+ field2 +" like '%'||?||'%'";

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			rs=pstmt.executeQuery();
			if(rs.next())count=rs.getInt("cnt");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return count;
	}
	
	public int getMemberCount(String tableName, String fieldName, String key) {
	      int count=0;
	      
	      con=Dbman.getConnection();
	      String sql="select count(*) as cnt from "+tableName + " where "+fieldName +" like '%'||?||'%' ";
	      try {
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, key);
	         rs=pstmt.executeQuery();
	         if(rs.next())count=rs.getInt("cnt");
	      } catch (SQLException e) {   e.printStackTrace();
	      }finally {Dbman.close(con, pstmt, rs);}
	      
	      return count;
	   }

	public ArrayList<MemberVO> selectMember(Paging paging, String key) {
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		con=Dbman.getConnection();
		String sql="select * from ("
				+"select * from("
				+ "select rownum as rn, m.* from((select * from member where id like '%'||?||'%' order by indate desc) m )"
				+ ") where rn>=?"
				+ ") where rn<=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2,paging.getStartNum());
			pstmt.setInt(3,paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress1(rs.getString("address1"));
				mvo.setPhone(rs.getString("Phone"));
				mvo.setAddress2(rs.getString("address2"));
				mvo.setNick(rs.getString("nick"));
				mvo.setIndate(rs.getTimestamp("indate"));
				list.add(mvo);
				}
			} catch (SQLException e) {	e.printStackTrace();
			}finally {Dbman.close(con, pstmt, rs);}
		
		
		return list;
	}

	public ArrayList<OrderViewVO> selectOrder(Paging paging, String key) {
		ArrayList<OrderViewVO> list=new ArrayList<OrderViewVO>();
		con=Dbman.getConnection();
		String sql="select * from ("
				+"select * from("
				+ "select rownum as rn, o.* from((select * from order_view where id like '%'||?||'%' or rname like '%'||?||'%' order by odseq desc) o )"
				+ ") where rn>=?"
				+ ") where rn<=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setInt(3,paging.getStartNum());
			pstmt.setInt(4,paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				if (list.size()==0) {
					OrderViewVO ovo=new OrderViewVO();
					ovo.setFsideprice1(rs.getInt("fsideprice1"));
					ovo.setFsideprice2(rs.getInt("fsideprice2"));
					ovo.setFsideprice3(rs.getInt("fsideprice3"));
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
					ovo.setRname(rs.getString("rname"));
					ovo.setRseq(rs.getInt("rseq"));
					list.add(ovo);
				} else if (list.get(list.size()-1).getOseq()!=rs.getInt("oseq")) {
					OrderViewVO ovo=new OrderViewVO();
					ovo.setFsideprice1(rs.getInt("fsideprice1"));
					ovo.setFsideprice2(rs.getInt("fsideprice2"));
					ovo.setFsideprice3(rs.getInt("fsideprice3"));
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
					ovo.setRname(rs.getString("rname"));
					ovo.setRseq(rs.getInt("rseq"));
					list.add(ovo);
				}
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	

	public int getAllCountForQna(String key, String string, String key2) {
		int count=0;
		
		con=Dbman.getConnection();
		String sql="select count(*) as cnt from qna where content like '%'||?||'%' or subject like '%'||?||'%'";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			rs=pstmt.executeQuery();
			if(rs.next())count=rs.getInt("cnt");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return count;
	}

	public ArrayList<QnaVO> selectQna(Paging paging, String key) {
		ArrayList<QnaVO> list=new ArrayList<QnaVO>();
		con=Dbman.getConnection();
		String sql="select * from ("
				+"select * from("
				+ "select rownum as rn, b.* from((select * from qna where content like '%'||?||'%' or subject like '%'||?||'%' order by qseq desc) b )"
				+ ") where rn>=?"
				+ ") where rn<=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setInt(3,paging.getStartNum());
			pstmt.setInt(4,paging.getEndNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				list.add(qvo);
				}
			} catch (SQLException e) {	e.printStackTrace();
			}finally {Dbman.close(con, pstmt, rs);}
		
		
		return list;
	}


	public void acceptRes(int rseq) {
		String sql="update restaurant set ryn=1 where rseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,rseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}
	
	
	public void rejectRes(int rseq) {
		String sql="update restaurant set ryn=2 where rseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,rseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}


	public void orderLb(int oseq) {
		String sql="update orders set result=result-1 where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,oseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
	}


	public void orderRb(int oseq) {
		String sql="update orders set result=result+1 where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,oseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
	}


	public int removeReview(int oseq) {
		int re=0;
		String sql="delete from review where oseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,oseq);
			re = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return re;
	}

}	
