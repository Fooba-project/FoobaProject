package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import fooba.VO.AddressVO;
import fooba.VO.MemberVO;
import fooba.VO.QnaVO;
import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.util.Dbman;
import fooba.util.Paging;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberVO getMember(String id) {
		MemberVO mvo=null;
		
		con=Dbman.getConnection();
		String sql="select * from member where id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mvo=new MemberVO();
				mvo.setId(id);
				mvo.setName(rs.getString("name"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setEmail(rs.getString("email"));
				mvo.setZip_num(rs.getString("zip_num"));
				mvo.setAddress1(rs.getString("address1"));
				mvo.setAddress2(rs.getString("address2"));
				mvo.setNick(rs.getString("nick"));
				mvo.setIndate(rs.getTimestamp("indate"));
			}
			
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return mvo;
	}

	public ArrayList<AddressVO> selectAddress(String dong) {
		ArrayList<AddressVO> list=new ArrayList<AddressVO>();
		con=Dbman.getConnection();
		String sql="select*from address where dong like '%'||?||'%' ";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,dong);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AddressVO avo=new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}

	public int insertMember(MemberVO mvo) {
		int result=0;
		String sql="insert into member(id, pwd, name, zip_num, address1, address2, email, phone,nick) values(?,?,?,?,?,?,?,?,?)";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,mvo.getId() );
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3,mvo.getName());
			pstmt.setString(4,mvo.getZip_num() );
			pstmt.setString(5,mvo.getAddress1() );
			pstmt.setString(6,mvo.getAddress2() );
			pstmt.setString(7,mvo.getEmail() );
			pstmt.setString(8,mvo.getPhone() );
			pstmt.setString(9, mvo.getNick());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return result;
	}

	public int updateMember(MemberVO mvo) {
		int result=0;
		con=Dbman.getConnection();
		String sql="update member set pwd=?, email=? , phone=?, zip_num=?,address1=?,address2=? ,nick=? where id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getEmail());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getNick());
			pstmt.setString(8, mvo.getId());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return result;

	}

	public void deleteMember(String id) {
		con=Dbman.getConnection();
		String sql="delete from member where id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
	}

	public void writeReview(ReviewVO rvvo) {
		String sql="insert into review(review_seq, content, id, image, oseq, rseq, star, nick) values(review_seq_seq.nextVal,?,?,?,?,?,?,?)";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rvvo.getContent());
			pstmt.setString(2, rvvo.getId());
			pstmt.setString(3, rvvo.getImage());
			pstmt.setInt(4, rvvo.getOseq());
			pstmt.setInt(5, rvvo.getRseq());
			pstmt.setInt(6, rvvo.getStar());
			pstmt.setString(7, rvvo.getNick());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
	}

	public int getAllCountForQna(String key) {
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


	public String memberFindId(String name, String phone) {
		String id = "";
		con=Dbman.getConnection();
		String sql="select id from member where name=? and phone=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs=pstmt.executeQuery();
			if (rs.next()) 
				id = rs.getString("id");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return id;
	}

	public String memberFindPw(String name, String phone, String id) {
		String email = "";
		con=Dbman.getConnection();
		String sql="select email from member where name=? and phone=? and id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, id);
			rs=pstmt.executeQuery();
			if (rs.next()) 
				email = rs.getString("email");
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return email;
	}

}
