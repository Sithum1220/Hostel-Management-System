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

    }

    @Override
    public Student get(String s) {
        return null;
    }

    @Override
    public void delete(Student Objec) {

    }

    @Override
    public List<String> getAllId() {
//        String sql="SELECT studentId FROM Student ORDER BY studentId DESC LIMIT 1";
//        return session.createQuery(sql).list();

        Query query = session.createQuery("select  studentId  from Student  order by LENGTH(studentId),studentId ");
        return query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}