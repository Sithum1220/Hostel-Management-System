package lk.ijse.hostel.repository.custom;

import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {

    List<String> searchStudent();
}
