package lk.ijse.hostel.controller;

import javafx.scene.text.Text;
import lk.ijse.hostel.dto.StudentDTO;

import java.util.List;

public class PendingPaymentBarFormController {
    public Text studentId;
    public Text name;
    public Text mobile;
    public Text address;

    public Text gender;

    public void setData(List<StudentDTO> list){

        for (StudentDTO c : list) {
            studentId.setText(c.getStudentId());
            name.setText(c.getName().getFirst_name()+" "+c.getName().getLast_name());
            mobile.setText(c.getContactNo());
            address.setText(c.getAddress().getHouseNo()+" "+c.getAddress().getStreet()+" "+c.getAddress().getCity());
            gender.setText(c.getGender());
        }
    }
}
