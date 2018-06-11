package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.jdbc.DBUtil;

import model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql=""+"insert into imooc_goddess"+
		           "(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel)"+
				  "values("+"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";//?相当于占位符
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());//利用set方法插入对应字段的值，由Goddes类的形参g通过get方法获得
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//ptmt.setDate(4, (Date) g.getBirthday());
		ptmt.setDate(4, new Date (g.getBirthday().getTime()));//java.until下的date转换为java.sql下的date
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMoblie());
		ptmt.setString(7, g.getCreate_user());
		//ptmt.setDate(8, (Date) g.getCreate_date());
		//ptmt.setDate(8, new Date (g.getCreate_date().getTime()));
		ptmt.setString(8, g.getUpdate_user());
		//ptmt.setDate(10, (Date) g.getUpdate_date());
		//ptmt.setDate(10, new Date (g.getUpdate_date().getTime()));
		ptmt.setInt(9,g.getIsdel());
		
        ptmt.execute();
	}
	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql=""+"update imooc_goddess"+
		           " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=?"
				    +" where id=?";//?相当于占位符
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());//利用set方法插入对应字段的值，由Goddes类的形参g通过get方法获得
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		//ptmt.setDate(4, (Date) g.getBirthday());
		ptmt.setDate(4, new Date (g.getBirthday().getTime()));//java.until下的date转换为java.sql下的date
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMoblie());
		//ptmt.setString(7, g.getCreate_user());
		//ptmt.setDate(8, (Date) g.getCreate_date());
		//ptmt.setDate(8, new Date (g.getCreate_date().getTime()));
		ptmt.setString(7, g.getUpdate_user());
		//ptmt.setDate(10, (Date) g.getUpdate_date());
		//ptmt.setDate(10, new Date (g.getUpdate_date().getTime()));
		ptmt.setInt(8,g.getIsdel());
		ptmt.setInt(9,g.getId());
		
        ptmt.execute();
		
	}
	public void deleteGoddess(Integer id) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql=""+"delete from imooc_goddess"+
		          
				    " where id=?";//?相当于占位符
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1,id);
		
        ptmt.execute();
		
	}
    public List<Goddess> query(String name) throws Exception{
    	Connection conn=DBUtil.getConnection();
    	StringBuilder sb=new StringBuilder();
    	sb.append("select * from imooc_goddess");
    	sb.append("where user_name = ?");
    	//java.sql.Statement stmt=conn.createStatement();//Statement 是 Java 执行数据库操作的一个重要接口，用于在已经建立数据库连接的基础上，向数据库发送要执行的SQL语句
		//结果集 rs查询结果的存放对象
    	PreparedStatement ptmt=conn.prepareStatement(sb.toString());
    	ptmt.setString(1,name);
        ResultSet rs=ptmt.executeQuery();
        List<Goddess> gs=new ArrayList<Goddess>();
        Goddess g=null;
        while(rs.next()){
        	g=new Goddess();
        	g.setUser_name(rs.getString("user_name"));
        	g.setAge(rs.getInt("age"));
    	   //System.out.println(rs.getString("user_name")+","+rs.getInt("age"));//rs.get获得相应的查询结果的方法
    	   //System.out.println(rs);
    	   System.out.println("恭喜大王，连接成功！");
        	gs.add(g);
        }
    	return gs;
    }
    public Goddess select(Integer id) throws SQLException {
    	Goddess g=null;
    	Connection conn=DBUtil.getConnection();
		String sql=""+"select * from imooc_goddess"+
		           
				    " where id=?";//?相当于占位符
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1,id);
		
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setId(rs.getInt("id"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setIsdel(rs.getInt("isdel"));
			
		}
		return g;
    }
	
}
