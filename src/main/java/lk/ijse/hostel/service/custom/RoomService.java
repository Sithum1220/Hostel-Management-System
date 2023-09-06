package lk.ijse.hostel.service.custom;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperService;

import java.util.List;

public interface RoomService extends SuperService {
    String saveRoom(RoomDTO roomDTO);
    List<String> getAllRoomId();
    String newId();
    RoomDTO getRoom(String id);

    boolean update(RoomDTO roomDTO);

    boolean delete(RoomDTO roomDTO);

}
