package lk.ijse.hostel.controller;

import javafx.scene.text.Text;

public class ResuvationAddManageBarFormController {
    public Text studentId;
    public Text roomId;
    public Text roomType;
    public Text studentName;
    public Text status;
    public Text date;

    public void setData(String studentIds, String roomIds, String roomTypes, String studentNames, String statuss, String dates) {
        studentId.setText(studentIds);
        roomId.setText(roomIds);
        roomType.setText(roomTypes);
        studentName.setText(studentNames);
        status.setText(statuss);
        date.setText(String.valueOf(dates));
    }
}
