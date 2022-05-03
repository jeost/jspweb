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
		String sql="select * from member where mid="+id;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return true;} // 동일한 아이디가 존재하면
		}catch(Exception e) {System.out.println("아이디 중복체크 오류 "+e);}
		return false;
	}
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
			ps.executeUpdate();
		}catch(Exception e) {System.out.println("회원가입 오류 "+e);}
		return false;
	}
}
