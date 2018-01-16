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
            return null;
        }finally {
            session.close();
        }
        return group;
    }

    public boolean updateContribution(String token, String groupid, double add)
    {
        DeviceUser deviceUser = null;
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            deviceUser = (DeviceUser) session.get(DeviceUser.class, token);
            double contrib = deviceUser.getContrib();
            contrib += add;
            deviceUser.setContrib(contrib);
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

    public String field2hql(String table, String field, String value)
    {
        String hql = "FROM ";
        hql += table;
        hql += " WHERE ";
        hql += field;
        hql += "=";
        hql += '\'';
        hql += value;
        hql += '\'';
        return  hql;
    }

    public List<DeviceUser> getMembersOf(Group group)
    {
        List<DeviceUser> members = null;
        Transaction tx = null;
        Session session = sessionFactory.openSession();
        try {
            tx = session.beginTransaction();
            List<DeviceUser> raw = session.createQuery("FROM DeviceUser as du WHERE du.groupid="+'\''+group.getName()+'\'').list();
            if(raw==null) return null;
            System.out.println(raw.size());
            members = raw;
            tx.commit();
        }catch (HibernateException e)
        {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return members;
    }

}
