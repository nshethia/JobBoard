package com.csye6220.esdfinalproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.csye6220.esdfinalproject.model.Company;
import com.csye6220.esdfinalproject.util.HibernateUtil;


@Component
public class CompanyDAOImpl implements CompanyDAO {

	
	private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	
	@Override
	public void save(Company company) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(company);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }

		
	}
	
	 @Override
	    public Company getByEmail(String CompanyEmail) {
	        try(Session session = sessionFactory.openSession()) {
	            String queryString = "FROM Company where CompanyEmail= :CompanyEmail";
	            @SuppressWarnings("rawtypes")
				Query query = session.createQuery(queryString, Company.class);
	            query.setParameter("CompanyEmail", CompanyEmail);
	            @SuppressWarnings("unchecked")
				List<Company> company = query.list();
	            return company.size() == 1 ? company.get(0) : null;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }

	 private Session getSession(){
	        @SuppressWarnings("resource")
			ApplicationContext context = new AnnotationConfigApplicationContext(this.getClass());
	        System.out.println("Session factory: "+context.getBean("sessionFactory"));
	        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	        return sessionFactory.openSession();
	    }
}
