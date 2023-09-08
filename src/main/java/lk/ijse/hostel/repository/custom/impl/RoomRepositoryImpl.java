package lk.ijse.hostel.repository.custom.impl;

import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.repository.custom.RoomRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    private Session session;

    @Override
    public String save(Room room) {
        return (String) session.save(room);
    }

    @Override
    public void update(Room room) {
        session.update(room);
    }

    @Override
    public Room get(String s) {
        return session.get(Room.class, s);
    }

    @Override
    public void delete(Room Objec) {
        session.delete(Objec);
    }

    @Override
    public List<String> getAllId() {
        Query query = session.createQuery("select  id  from Room order by LENGTH(id),id ");
        return query.list();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        String sqlQuery = "FROM Room";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return (ArrayList<Room>) list;
    }
}
