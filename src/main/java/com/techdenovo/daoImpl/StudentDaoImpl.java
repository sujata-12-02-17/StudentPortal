package com.techdenovo.daoImpl;

import com.techdenovo.dao.StudentDao;
import com.techdenovo.domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class StudentDaoImpl  implements StudentDao {

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createCriteria(Student.class).list();
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.update(student);
            transaction.commit();
            session.close();
        }

    }

    @Override
    public Student findById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, id);
//            session.close();

            return student;
        }
    }

    @Override
    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, (Serializable) id);
            session.delete(student);
            transaction.commit();

            session.close();
        }
    }
}
