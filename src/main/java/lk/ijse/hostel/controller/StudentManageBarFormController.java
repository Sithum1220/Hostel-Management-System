package lk.ijse.hostel.controller;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.StudentService;

public class StudentManageBarFormController {


    public Text gender;
    public Text mobile;
    public Text dob;
    public Text address;
    public Text name;
    public Text id;
    StudentService studentService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.STUDENT_SERVICE);

    public void setData(String ids) {
        StudentDTO studentDTO = studentService.getStudent(ids);
        id.setText(studentDTO.getStudentId());
        mobile.setText(studentDTO.getContactNo());
        gender.setText(studentDTO.getGender());
        dob.setText(String.valueOf(studentDTO.getDob()));
        name.setText(studentDTO.getName().getFirst_name() + " " + studentDTO.getName().getLast_name());
        address.setText(studentDTO.getAddress().getHouseNo() + " " + studentDTO.getAddress().getStreet() + " " + studentDTO.getAddress().getCity());
    }

    public void updateOnMouseClick(MouseEvent event) {
        StudentManageFormController.getInstance().update(id.getText());
    }

    public void deleteOnMouseClick(MouseEvent event) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(id.getText());
        boolean delete = studentService.delete(studentDTO);

        if (delete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted!").showAndWait();
            StudentManageFormController.getInstance().loadAllIds();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Deleted!").show();

        }
    }
}
