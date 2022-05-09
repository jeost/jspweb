package dao;

import java.util.ArrayList;

import dto.Board;

public class boardDao extends Dao{
	public boardDao() {super();} // 부모 클래스의 db연동 메소드 호출
	public static boardDao boarddao=new boardDao();
	public static boardDao getboarddao() {return boarddao;}
	
	//게시물 쓰기 메소드
	public boolean write(Board board) {
		String sql="insert into board(btitle, bcontent, mno, bfile) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMno());
			ps.setString(4, board.getBfile());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//모든 게시물 출력 메소드
	public ArrayList<Board> getboardlist() {
		ArrayList<Board> boardlist = new ArrayList<Board>();
		String sql="select*from board order by bno desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Board board=new Board(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getInt(6),rs.getString(7),null);
				boardlist.add(board);
			}return boardlist;
		}catch(Exception e) {e.printStackTrace();}
		return null;}
	//개별 게시물 출력 메소드
	public Board getboard(int bno) {
		String sql="select*from board where bno='"+bno+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Board board=new Board(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getString(5),rs.getInt(6),rs.getString(7),null); return board;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;}
	
	public boolean update(Board board) {
		String sql="update board set btitle=?, bcontent=?, bfile=? where bno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBfile());
			ps.setInt(4, board.getBno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//게시물 삭제 메소드
	public boolean delete(int bno) {
		String sql="delete from board where bno='"+bno+"'";
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//첨부파일만 삭제(null로 변경) 메소드
	public boolean filedelete(int bno) {
		String sql="update board set bfile=null where bno='"+bno+"'";
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	//게시물 조회수 증가 메소드
	public void view(int bno) {
		String sql="update board set bview=bview+1 where bno="+bno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("조회수 증가 성공");
		}catch(Exception e) {e.printStackTrace();}
		}
	//댓글 작성 메소드
	public boolean replywrite() {return false;}
	//댓글 출력 메소드
	public boolean replylist() {return false;}
	//댓글 수정 메소드
	public boolean replyupdate() {return false;}
	//댓글 삭제 메소드
	public boolean replydelete() {return false;}
	
}
