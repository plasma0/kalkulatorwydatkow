package uek.dbmanager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uek.pojo.DeviceUser;
import uek.pojo.Group;

import java.util.List;

public class DBManager {
    private SessionFactory sessionFactory;

    public DBManager() {
        try {
            sessionFactory = new Configuration().configure("/uek/dbmanager/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("BŁĄAD: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public boolean addObject(Object o) {
        if (!(o instanceof Group || o instanceof DeviceUser)) return false;
        else {

            Transaction tx = null;
            Session session = sessionFactory.openSession();
            try {
                tx = session.beginTransaction();
                session.save(o);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                return false;
            } finally {
                session.close();
            }
            return true;
        }
    }
    public Group getGroup(String login)
    {
        Group group = null;
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            group = (Group)session.get(Group.class, login);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return group;
    }
    public List<DeviceUser> getByToken(String token)
    {
        List<DeviceUser> toSend = null;
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            toSend = session.createQuery("FROM DEVICEUSER WHERE token="+token).list();
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return toSend;
    }
    public boolean updateContribution(String token, String groupid, double add)
    {
        DeviceUser deviceUser = null;
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            deviceUser = (DeviceUser) session.createQuery("FROM DEVICEUSER WHERE token=" + token + " AND groupid=" + groupid).list().get(0);
            session.evict(deviceUser);
            double current = deviceUser.getContrib();
            current += add;
            deviceUser.setContrib(current);
            session.update(deviceUser);
            tx.commit();
        }catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
        }
    }
}
