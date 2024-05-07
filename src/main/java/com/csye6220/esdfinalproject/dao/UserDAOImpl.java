package com.csye6220.esdfinalproject.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.util.HibernateUtil;

@Component
public class UserDAOImpl implements UserDAO {

	    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	    @Override
	    public void save(User user) {
	        try(Session session = sessionFactory.openSession()){
	            Transaction transaction = session.getTransaction();
	            transaction.begin();
	            session.persist(user);
	            transaction.commit();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }

	    }

	   

	    @Override
	    public User getById(Long id) {
	        try(Session session = sessionFactory.openSession()) {
	            String queryString = "FROM User where id="+id;
	            @SuppressWarnings("rawtypes")
				Query query = session.createQuery(queryString, User.class);
	            @SuppressWarnings("unchecked")
				List<User> users = query.list();
	            return users.size() == 1 ? users.get(0) : null;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public User getByEmail(String email) {
	        try(Session session = sessionFactory.openSession()) {
	            String queryString = "FROM User where email= :email";
	            @SuppressWarnings("rawtypes")
				Query query = session.createQuery(queryString, User.class);
	            query.setParameter("email", email);
	            @SuppressWarnings("unchecked")
				List<User> users = query.list();
	            return users.size() == 1 ? users.get(0) : null;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	   

	    @Override
	    public List<User> getAllUsers() {
	        try(Session session = sessionFactory.openSession()) {
	            String queryString = "FROM User";
	            @SuppressWarnings("rawtypes")
				Query query = session.createQuery(queryString, User.class);
	            @SuppressWarnings("unchecked")
				List<User> users = query.list();
	            return users;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }

	    private Session getSession(){
	        ApplicationContext context = new AnnotationConfigApplicationContext(this.getClass());
	        System.out.println("Session factory: "+context.getBean("sessionFactory"));
	        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	        return sessionFactory.openSession();
	    }
	}

