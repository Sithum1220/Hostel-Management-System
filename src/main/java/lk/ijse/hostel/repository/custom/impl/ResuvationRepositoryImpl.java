package lk.ijse.hostel.repository.custom.impl;

import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.repository.custom.ResuvationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ResuvationRepositoryImpl implements ResuvationRepository {
    private Session session;

    @Override
    public String save(Reservation reservation) {
        return (String) session.save(reservation);
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
        Query query = session.createQuery("select  reservationId  from Reservation order by LENGTH(reservationId),reservationId ");
        return query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
