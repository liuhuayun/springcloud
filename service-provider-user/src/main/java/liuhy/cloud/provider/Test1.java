package liuhy.cloud.provider;

import java.util.ArrayList;
import java.util.List;

import liuhy.cloud.provider.entity.User;

public class Test1 {
	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		for(int x=0;x<30;x++) {
			User user = new User((long)x, "1");
			users.add(user);
		}
		System.out.println(isRepay3p(users));
	}
	
	public static boolean isRepay3p(List<User> users) { //users按时间倒序排好顺序
		List<String> status = new ArrayList<String>();
		status.add("2");status.add("3");status.add("4"); //逾期还款的状态
		
		if(users==null || users.size()<3) { //没有三期还款
			return false;
		}
		System.out.println(users);
		for(int i=0;i<=users.size()-3;i++) {
			List<User> userList = users.subList(i, i+3);
			System.out.println(userList);
			boolean isNormal3per = true; //是否正常连续还款三期
			for (User user : userList) {
				if(status.contains(user.getUsername())) {
					isNormal3per = false;
					break;
				}
			}
			if(isNormal3per) {
				return true;
			}
		}
		return false;
	}
}
