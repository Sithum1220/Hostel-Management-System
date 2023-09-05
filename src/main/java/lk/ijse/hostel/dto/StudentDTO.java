package lk.ijse.hostel.dto;

import lk.ijse.hostel.embedded.Address;
import lk.ijse.hostel.embedded.Name;
import lk.ijse.hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {

    private String studentId;
    private Name name;
    private Address address;
    private String contactNo;
    private LocalDate dob;
    private String gender;

    public Student toEntity() {
        Student student = new Student();
        student.setStudentId(this.studentId);
        student.setName(this.name);
        student.setAddress(this.address);
        student.setContactNo(this.contactNo);
        student.setDob(this.dob);
        student.setGender(this.gender);
        return student;
    }
}
