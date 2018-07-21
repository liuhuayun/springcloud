package liuhy.cloud.provider;

import java.util.ArrayList;
import java.util.List;

import liuhy.cloud.provider.entity.User;

public class Test1 {
	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		User user1 = new User((long) 1, "1");
		User user2 = new User((long) 2, "1");
		User user3 = new User((long) 3, "2");
		User user4 = new User((long) 4, "1");
		User user5 = new User((long) 5, "2");
		User user6 = new User((long) 6, "1");
		User user7 = new User((long) 7, "1");
		User user8 = new User((long) 8, "2");
		User user9 = new User((long) 9, "1");
		User user10 = new User((long) 10, "1");
		User user11 = new User((long) 11, "2");
		User user12 = new User((long) 12, "1");
		User user13 = new User((long) 13, "1");
		User user14 = new User((long) 14, "2");
		User user15 = new User((long) 15, "2");
		User user16 = new User((long) 16, "1");
		User user17 = new User((long) 17, "1");
		User user18 = new User((long) 18, "2");
		User user19 = new User((long) 19, "1");
		User user20 = new User((long) 20, "1");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		
		users.add(user11);
		users.add(user12);
		users.add(user13);
		users.add(user14);
		users.add(user15);
		users.add(user16);
		users.add(user17);
		users.add(user18);
		users.add(user19);
		users.add(user20);
		System.out.println(isRepay3p(users));
	}
	
	public static boolean isRepay3p(List<User> users) { //users按时间倒序排好顺序
		List<String> status = new ArrayList<String>();
		status.add("2"); //逾期还款的状态
		
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
