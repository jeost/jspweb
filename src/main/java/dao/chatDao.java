package dao;

import java.util.ArrayList;

import dto.Chat;

public class chatDao extends Dao{
	public chatDao() {super();}
	public static chatDao chatdao=new chatDao();
	
	//채팅 받아오기
	public ArrayList<Chat> getChat(){
		String sql="select*from chat";
		ArrayList<Chat> chatList=new ArrayList<Chat>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Chat chat=new Chat(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
				chatList.add(chat);
			}return chatList;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	//채팅 보내기
	public boolean submit(String cName, String cContent) {
		String sql="INSERT INTO `jspweb`.`chat` (`cname`, `ccontent`) VALUES (?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, cName);
			ps.setString(2, cContent);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
