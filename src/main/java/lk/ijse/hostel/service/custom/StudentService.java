package lk.ijse.hostel.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperService;

import java.util.List;

public interface StudentService extends SuperService {
    String saveStudent(StudentDTO studentDTO);
    List<String> getAllStudentId();
    String newId();

    StudentDTO getStudent(String id);
    List<String> getSearchStudentId();
    boolean update(StudentDTO studentDTO);

    boolean delete(StudentDTO studentDTO);

}
