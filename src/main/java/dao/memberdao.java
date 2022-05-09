package dao;

import dto.member;

public class memberdao extends Dao{
	public memberdao() {
		super(); // sql 연동하는 그거 호출
	}
	public static memberdao memberDao=new memberdao(); // dao 호출시 반복되는 new 연산자 제거
	public static memberdao getmemberDao() {return memberDao;}
	
	//아이디 중복체크 메소드
	public boolean idcheck(String id) {
		String sql="select * from member where mid='"+id+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return true;} // 동일한 아이디가 존재하면
		}catch(Exception e) {System.out.println("아이디 중복체크 오류 "+e);}
		return false;
	}
	//회원가입 메소드
	public boolean signup(member member) {
		String sql="insert into member (mid,mpassword,mname,mphone,memail,maddress) values (?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate(); return true;
		}catch(Exception e) {System.out.println("회원가입 오류 "+e);}
		return false;
	}
	public boolean emailcheck(String email) {
		String sql="select*from member where memail = '"+email+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) return true;
		}catch(Exception e) {System.out.println("이메일 중복체크 오류 "+e);}
		return false;
	}
	public int login(String mid, String mpassword) {
		String sql="select * from member where mid = '"+mid+"'and mpassword = '"+mpassword+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return 1;}else {return 2;}
		}catch(Exception e) {System.out.println("로그인 오류 "+e);}
		return 3;
	}
	public member getmember(String id) { //개별 회원정보 출력[ 인수 : 세션에 저장된 회원아이디 ]
		String sql="select*from member where mid='"+id+"'";
		try {
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()) {
			member member=new member(
					rs.getInt(1), rs.getString(2),
					null, rs.getString(4),
					rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getInt(8),
					rs.getString(9)
					);return member;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public boolean passwordcheck(String mid, String mpassword) {
		String sql="select*from member where mid='"+mid+"' and mpassword='"+mpassword+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public boolean delete(String mid) {
		String sql="delete from member where mid='"+mid+"'";
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public boolean update(member member) {
		
		try {
		if(member.getMpassword()==null) {
			String sql="update member set mname=?, mphone=?, memail=?, maddress=? where mno=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getMname());
			ps.setString(2, member.getMphone());
			ps.setString(3, member.getMemail());
			ps.setString(4, member.getMaddress());
			ps.setInt(5, member.getMno());
		}else {
			String sql="update member set mname=?, mpassword=?, mphone=?, memail=?, maddress=? where mno=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getMname());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMphone());
			ps.setString(4, member.getMemail());
			ps.setString(5, member.getMaddress());
			ps.setInt(6, member.getMno());
		}
			ps.executeUpdate(); return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	//회원번호 출력 메소드
	public int getmno(String mid) {
		String sql="select mno from member where mid='"+mid+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	//회원 아이디 출력 메소드
	public String getmid(int mno) {
		String sql="select mid from member where mno='"+mno+"'";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
