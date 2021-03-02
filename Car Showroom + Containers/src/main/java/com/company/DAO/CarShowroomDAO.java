package com.company.DAO;

import com.company.Classes.CarShowroom;
import com.company.Exceptetions.HibernateConnectionException;
import com.company.Hibernate.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;


public class CarShowroomDAO implements DAO<CarShowroom> {

    @Override
    public CarShowroom get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CarShowroom result;

        try {
            session.beginTransaction();
            final Query<CarShowroom> query = session.createQuery("from CarShowroom c where c.id= :id", CarShowroom.class).setParameter("id", id);
            result = query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    @Override
    public List<CarShowroom> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CarShowroom> result;

        try {
            session.beginTransaction();
            result = session.createQuery("from CarShowroom", CarShowroom.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    @Override
    public List<CarShowroom> getAllparam(long id) {
        return null;
    }

    @Override
    public void save(CarShowroom entity) {
        final Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            entity.getVehicleList().forEach(session::save);
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(CarShowroom entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            entity.getVehicleList().forEach(session::delete);
            session.delete(entity);
            tx.commit();
        } catch (HibernateConnectionException exception) {
            assert tx != null;
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteByModel(String model) {
    }

    @Override
    public int count(long id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        long result;

        try {
            session.beginTransaction();

            Query query = session.createQuery("select count(r) from RATING r where r.carshowroom= :id");
            query.setParameter("id", id);
            result = (long) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return Math.toIntExact(result);
    }

    @Override
    public int sum(long id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        long result = 0;

        try {
            session.beginTransaction();

            Query query = session.createQuery("select sum(r.value) from RATING r where r.carshowroom= :id");
            query.setParameter("id", id);
            if (query.uniqueResult() != null) {
                result = (long) query.uniqueResult();
            }
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return Math.toIntExact(result);
    }

    @Override
    public double showAmount(long id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        double result = 0.0;

        try {
            session.beginTransaction();
            TypedQuery<Double> query = session.createQuery("SELECT sum(v.price) FROM Vehicle v where v.Showroom= :id", Double.class);
            query.setParameter("id", id);
            if (query.getSingleResult() != null) {
                result = query.getSingleResult();
            }
            session.getTransaction().commit();
        } catch (HibernateConnectionException exception) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new HibernateConnectionException("Problems during operations.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }
}
