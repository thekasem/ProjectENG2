package com.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.entity.HibernateArchiveUtil;
import com.entity.HibernateUtil;
import com.entity.User;

public class App  {
	public static void main(String[] args) {
		App app = new App();

		// create user data object
		User user = new User();
		user.setUserId(1);
		user.setFirstName("nagesh");
		user.setLastName("chauhan");
		user.setGender("male");
		user.setCity("gurgaon");
		user.setPassword("0000");
		user.setUserName("kasemsun");

		User user1 = new User();
		user1.setUserId(2);
		user1.setFirstName("ankush");
		user1.setLastName("thakur");
		user1.setGender("male");
		user1.setCity("delhi");
		user1.setPassword("0000");
		user1.setUserName("kasemsun");


		// save user in db
		app.saveUser(user);
		app.saveUser(user1);

		// update user data
		user.setCity("noida");
		app.updateUser(user);

		// delete user data
		app.deleteUser(user1);

		// get user data
		app.getUser();
	}

	public void saveUser(User user) {
		Session session = HibernateArchiveUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
	}

	public void updateUser(User user) {
		Session session = HibernateArchiveUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.merge(user);

		session.getTransaction().commit();
	}

	public void deleteUser(User user) {
		Session session = HibernateArchiveUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.delete(user);

		session.getTransaction().commit();
	}

	public List<User> getUser() {
		Session session = HibernateArchiveUtil.getSessionFactory().openSession();
		session.beginTransaction();

		ArrayList<User> list = (ArrayList<User>) session.createQuery("from User").list();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("User Data : " + list.get(i).getUserId());
				System.out.println("User First Name : "
						+ list.get(i).getFirstName());
				System.out.println("User Last Name : "
						+ list.get(i).getLastName());
				System.out.println("User Gender : " + list.get(i).getGender());
				System.out.println("User City : " + list.get(i).getCity());
			}
		}
		session.getTransaction().commit();
		return list;
	}
}
