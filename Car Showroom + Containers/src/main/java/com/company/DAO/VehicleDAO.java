package com.company.DAO;

import com.company.Classes.Vehicle;
import com.company.Exceptetions.HibernateConnectionException;
import com.company.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class VehicleDAO implements DAO<Vehicle> {

    @Override
    public Vehicle get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Vehicle result;

        try {
            session.beginTransaction();
            final Query<Vehicle> query = session.createQuery("from Vehicle v where v.id= :id", Vehicle.class);
            query.setParameter("id", id);
            result = query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return result;
    }

    @Override
    public List<Vehicle> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Vehicle> result;

        try {
            session.beginTransaction();
            final Query<Vehicle> query = session.createQuery("from Vehicle", Vehicle.class);
            result = query.getResultList();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return result;
    }

    @Override
    public List<Vehicle> getAllparam(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Vehicle> result;

        try {
            session.beginTransaction();
            final Query<Vehicle> query = session.createQuery("from Vehicle v where v.Showroom= :Showroom", Vehicle.class);
            query.setParameter("Showroom", id);
            result = query.getResultList();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

        return result;
    }

    @Override
    public void save(Vehicle entity) {
        final Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void delete(Vehicle entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void deleteByModel(String model) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Vehicle where model = :model");
            query.setParameter("model", model);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if ( session.getTransaction().isActive() ) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public int count(long id) {
        return 0;
    }

    @Override
    public int sum(long id) {
        return 0;
    }

    @Override
    public double showAmount(long id) {
        return 0;
    }
}
