package lk.ijse.hostel.repository.custom;

import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.repository.CrudRepository;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room, String> {

    public ArrayList<Room> getAllRooms();
}
