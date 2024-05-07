package com.csye6220.esdfinalproject.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.csye6220.esdfinalproject.model.JobPost;
import com.csye6220.esdfinalproject.util.HibernateUtil;

@Component
public class JobPostDAOImpl implements JobPostDAO {

	    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	    @Override
	    public void save(JobPost jobPost) {
	        try(Session session = sessionFactory.openSession()){
	            Transaction transaction = session.getTransaction();
	            transaction.begin();
	            session.persist(jobPost);
	            transaction.commit();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public void update(JobPost jobPost) {
	        try(Session session = sessionFactory.openSession()){
	            Transaction transaction = session.getTransaction();
	            transaction.begin();
	            session.merge(jobPost);
	            transaction.commit();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void delete(JobPost jobPost) {
	        if(jobPost == null)
	            return;
	        try(Session session = sessionFactory.openSession()){
	            Transaction transaction = session.getTransaction();
	            transaction.begin();
	            session.remove(jobPost);
	            transaction.commit();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	    }

		@Override
		public List<JobPost> getAllJobs() {
			 try(Session session = sessionFactory.openSession()){
				 List<JobPost> jobList=session.createQuery("from JobPost").list();
				 return jobList;
			 }
			 catch (Exception e){
		            e.printStackTrace();
		            return null;
		        }
			
		}

		@Override
		public JobPost getJobById(long jobId) {
			 try(Session session = sessionFactory.openSession()){
		        	JobPost jobPost = session.get(JobPost.class, jobId);
		            return jobPost;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		            return null;
		        }
		    }

		@Override
		public List<Object[]> getFilterJobs() {
			 try(Session session = sessionFactory.openSession()){
				 List<Object []> jobList=session.createQuery(" Select location, companyName, title from JobPost").list();
				 return jobList;
			 }
			 catch (Exception e){
		            e.printStackTrace();
		            return null;
		        }
		}
}

