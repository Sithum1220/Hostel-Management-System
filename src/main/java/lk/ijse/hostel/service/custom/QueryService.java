package lk.ijse.hostel.service.custom;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperService;

import java.util.List;

public interface QueryService extends SuperService {
     List<StudentDTO> getAllPendingPaymentStudent();
}
