package lk.ijse.hostel.service.custom;

import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.service.SuperService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Transaction;

import java.util.List;

public interface ResuvationService extends SuperService {
    boolean save(ReservationDTO reservationDTO, RoomDTO roomDTO);

    List<String> getAllReservationId();

    String newId();
     ReservationDTO getReservetion(String id);
}
