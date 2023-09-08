package lk.ijse.hostel.repository.custom;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.repository.CrudRepository;

import java.util.List;

public interface DashboardRepository extends CrudRepository<Reservation,String> {

    List<StudentDTO> getAllPendingPaymentStudent();

    Long getAllPendingPaymentCount();
}
