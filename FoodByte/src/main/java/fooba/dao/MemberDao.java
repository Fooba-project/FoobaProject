package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fooba.VO.AddressVO;
import fooba.VO.MemberVO;
import fooba.util.Dbman;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	/*
	public void Method() {
		con = Dbman.getConnection();
		String sql = ""; 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		catch (Exception e) {e.printStackTrace();} 
		finally {Dbman.close(con, pstmt, rs);}
	}*/

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
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,mvo.getPwd());
			pstmt.setString(2,mvo.getEmail());
			pstmt.setString(3,mvo.getPhone());
			pstmt.setString(4,mvo.getZip_num());
			pstmt.setString(5, mvo.getAddress1());
			pstmt.setString(6, mvo.getAddress2());
			pstmt.setString(7, mvo.getNick());
			pstmt.setString(8,mvo.getId());
			
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
	
	
}
