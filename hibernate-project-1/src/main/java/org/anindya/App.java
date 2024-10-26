package org.anindya;

import org.anindya.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Users.class)
                                   .buildSessionFactory();
		
		System.out.println(factory.isClosed());
		
		Session session=factory.getCurrentSession();
		
		
		try {
			//Create object of entity type
		//	Users user=new Users("username", "password", "first_name", "last_name");
			Users user =new Users();
			System.out.println(user.getPassword());
			//Start transaction
			session.beginTransaction();
			
			//Perform operation
		  // session.save(user);
			user=session.get(Users.class, 1);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println(user);
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
