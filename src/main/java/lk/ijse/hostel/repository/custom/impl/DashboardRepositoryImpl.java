package lk.ijse.hostel.repository.custom.impl;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.repository.custom.DashboardRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DashboardRepositoryImpl implements DashboardRepository {
    private Session session;
    @Override
    public String save(Reservation reservation) {
        return null;
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public Reservation get(String s) {
        return null;
    }

    @Override
    public void delete(Reservation Objec) {

    }

    @Override
    public List<String> getAllId() {
        return null;
    }

    @Override
    public void setSession(Session session) {
this.session = session;
    }

    @Override
    public List<StudentDTO> getAllPendingPaymentStudent() {
        try {
            Query query = session.createQuery("SELECT new  lk.ijse.hostel.dto.StudentDTO(s.studentId,s.name,s.address,s.contactNo,s.dob,s.gender)\n" +
                    "FROM Student AS s INNER JOIN Reservation AS r ON s.studentId=r.students.studentId\n" +
                    "WHERE r.status=:status");
            query.setParameter("status", "Pending payment");
            List<StudentDTO> list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getAllPendingPaymentCount() {
        try {
            Query query = session.createQuery("SELECT COUNT(r)\n" +
                    "FROM Reservation AS r\n" +
                    "WHERE r.status=:status");
            query.setParameter("status", "Pending Payment");
            Long count = (Long) query.uniqueResult();
            session.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
