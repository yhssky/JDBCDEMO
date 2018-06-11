package action;

import model.Goddess;

import java.util.Date;
//import java.util.List;
import dao.GoddessDao;

public class GoddessAction {
    public static void main(String[] args) throws Exception {
	GoddessDao g=new GoddessDao();//创建一个GoddessDao的对象
	/*Goddess g1=new Goddess();
	g1.setUser_name("小朱");
	//g1.setAge(25);
	g1.setSex(1);
	g1.setAge(23);
	g1.setBirthday(new Date());
	g1.setEmail("xiaozhu@163.com");
	g1.setMoblie("12888888888");
	//g1.setCreate_user("管理员");
	g1.setUpdate_user("管理员");
	g1.setId(3);
	g1.setIsdel(1);*/
	Goddess g2=g.select(2);//调用查询方法付给g2实例对象，输出toString方法
	System.out.println(g2.toString());
	
	//g.deleteGoddess(1);
	//g.updateGoddess(g1);
	
	//g.addGoddess(g1);
	/*List<Goddess>gs=g.query();//将这个对象的查询结果放入gs的List表中；
	for (Goddess goddess : gs) {//遍历结果集gs，输出所有结果
		System.out.println(goddess.getUser_name()+","+goddess.getAge());
		
	}*/
  }
}
