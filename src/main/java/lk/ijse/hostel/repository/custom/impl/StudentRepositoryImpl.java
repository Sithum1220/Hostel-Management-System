package lk.ijse.hostel.repository.custom.impl;

import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.repository.custom.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private Session session;

    @Override
    public String save(Student student) {
        return (String) session.save(student);
    }

    @Override
    public void update(Student student) {
        session.update(student);
    }

    @Override
    public Student get(String s) {
        return session.get(Student.class, s);
    }

    @Override
    public void delete(Student Objec) {
        session.delete(Objec);
    }

    @Override
    public List<String> getAllId() {
        Query query = session.createQuery("select  studentId  from Student  order by LENGTH(studentId),studentId ");
        return query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<String> searchStudent() {
        return null;
    }
}