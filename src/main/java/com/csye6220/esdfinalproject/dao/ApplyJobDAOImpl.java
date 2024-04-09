package com.csye6220.esdfinalproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csye6220.esdfinalproject.model.ApplyJob;

import com.csye6220.esdfinalproject.model.User;
import com.csye6220.esdfinalproject.util.HibernateUtil;

@Component
public class ApplyJobDAOImpl implements ApplyJobDAO{
	 private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	  public void save(ApplyJob applyJob) {
		  try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            if (applyJob.getId() == 0) {
	            
	                session.persist(applyJob);
	            } else {
	                
	                session.merge(applyJob);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  @Override
	    public ApplyJob getJobById(long id) {
	        try(Session session = sessionFactory.openSession()){
	        	ApplyJob applyjob = session.get(ApplyJob.class, id);
	        	
	            return applyjob;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	    }

	@Override
	public List<ApplyJob> findJobsByEmail(String email) {
		 
	        try (Session session = sessionFactory.openSession()) {
	            String hql = "SELECT j FROM ApplyJob a JOIN a.jobPost j WHERE a.email = :email";
	            Query<ApplyJob> query = session.createQuery(hql, ApplyJob.class);
	            query.setParameter("email", email);
	            List<ApplyJob>  appliedJobs = query.list();
	            return appliedJobs;
	        } catch (Exception e) {      
	            e.printStackTrace();   
	        }
			return null;
	       
	}
	
	@Override
	public List<ApplyJob> findApplicantsByEmail(String email) {
		 
	        try (Session session = sessionFactory.openSession()) {
	            String hql = "SELECT a FROM ApplyJob a JOIN a.jobPost j WHERE j.companyName = :email";
	            Query<ApplyJob> query = session.createQuery(hql, ApplyJob.class);
	            query.setParameter("email", email);
	            List<ApplyJob>  appliedJobs = query.list();
	            return appliedJobs;
	        } catch (Exception e) {      
	            e.printStackTrace();   
	        }
			return null;
	       
	}
	}


































