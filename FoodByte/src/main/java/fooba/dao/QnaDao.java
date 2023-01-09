package fooba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fooba.VO.QnaVO;
import fooba.util.Dbman;

public class QnaDao {
	private QnaDao() {}
	private static QnaDao itc = new QnaDao();
	public static QnaDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public void insertQna(QnaVO qvo) {
		con=Dbman.getConnection();
		String sql="insert into qna(qseq, subject, content) values(qna_seq.nextVal,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, qvo.getSubject());
			pstmt.setString(2, qvo.getContent());			
			pstmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
	}


	public void updateQna(QnaVO qvo) {
		con=Dbman.getConnection();
		String sql="update qna set content=?, subject=? where qseq=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, qvo.getContent());
			pstmt.setString(2, qvo.getSubject());
			pstmt.setInt(3,qvo.getQseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
	}


	public void deleteQna(int qseq) {
		con=Dbman.getConnection();
		String sql="delete from qna where qseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,qseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
	}


	public QnaVO getQna(int qseq) {
		QnaVO qvo=null;
		String sql="select*from qna where qseq=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				
			}
		} catch (SQLException e) {	e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return qvo;
	}
}
