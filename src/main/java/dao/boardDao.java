package dao;

import java.util.ArrayList;

import dto.Board;
import dto.Reply;

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
	public ArrayList<Board> getboardlist(int startrow, int listsize, String key, String keyword) {
		ArrayList<Board> boardlist = new ArrayList<Board>();
		String sql=null;
		if(key.equals("")&&keyword.equals("")) {
			sql="select*from board order by bno desc limit "+startrow+","+listsize;
		}else {
			sql="select*from board where '"+key+"' like '%"+keyword+"%' order by bno desc limit "+startrow+","+listsize;
		}
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
	//게시물 전체 개수 출력 메소드
	public int gettotalrow(String key, String keyword) {
		String sql=null;
		if(key.equals("")&&keyword.equals("")) {
		sql="select count(*) from board";
		}else {
			sql="select count(*) from board where '"+key+"' like '%"+keyword+"%'";
		}
		try {
			ps=con.prepareStatement(sql); rs=ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		}catch(Exception e) {e.printStackTrace();} return 0;
	}
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
			System.out.println("조회수 증가");
		}catch(Exception e) {e.printStackTrace();}
		}
	//게시물 댓글수 조회 메소드
	public int replyview(int bno) {
		String sql="select*from reply where bno="+bno;
		int r=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				r++;
			}
		}catch(Exception e) {e.printStackTrace();}
		return r;
	}
	//댓글 작성 메소드
	public boolean replywrite(Reply reply) {
		String sql="insert into reply(rcontent, rindex, bno, mno) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getBno());
			ps.setInt(4, reply.getMno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//댓글 출력 메소드
	public ArrayList<Reply> replylist( int bno ) { 
		ArrayList<Reply> replylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = 0"; // rindex = 0  : 댓글만 출력 [ 대댓글 제외 ] 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while( rs.next() ) { 
				Reply reply = new Reply( 
						rs.getInt(1) , rs.getString(2) , 
						rs.getString(3) , rs.getInt(4) , 
						rs.getInt(5), rs.getInt(6), null);
				replylist.add(reply);
			}
			return replylist;
		}catch (Exception e) { System.out.println( e ); } return null; 
	}
	//댓글 수정 메소드
	public boolean replyupdate(String rcontent, int rno) {
		String sql="update reply set rcontent='"+rcontent+"' where rno="+rno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch (Exception e) { System.out.println( e ); }
		return false;}
	//댓글 삭제 메소드
	public boolean replydelete(int rno) {
		String sql="delete from reply where rno="+rno+" or rindex="+rno;
		try {
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
		return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;}
	//대댓글 보기 메소드
	public ArrayList<Reply> rereplylist(int bno,int rno){
		ArrayList<Reply> rereplylist=new ArrayList<Reply>();
		String sql="select*from reply where bno="+bno+" and rindex=+"+rno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Reply reply=new Reply(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),null);
			rereplylist.add(reply);}return rereplylist;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
