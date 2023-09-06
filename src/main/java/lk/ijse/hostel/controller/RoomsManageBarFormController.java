package lk.ijse.hostel.controller;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.RoomService;
import lk.ijse.hostel.service.custom.StudentService;

public class RoomsManageBarFormController {
    public Text id;
    public Text roomType;
    public Text keyMoney;
    public Text qty;

    RoomService roomService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.ROOM_SERVICE);

    public void setData(String ids) {
        RoomDTO roomDTO = roomService.getRoom(ids);
        id.setText(roomDTO.getId());
        roomType.setText(roomDTO.getType());
        keyMoney.setText(roomDTO.getKeyMoney());
        qty.setText(String.valueOf(roomDTO.getQty()));
    }

    public void updateOnMouseClick(MouseEvent event) {
        RoomsManageFormController.getInstance().update(id.getText());
    }

    public void deleteOnMouseClick(MouseEvent event) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(id.getText());
        boolean delete = roomService.delete(roomDTO);

        if (delete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted!").showAndWait();
            RoomsManageFormController.getInstance().loadAllIds();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Deleted!").show();

        }
    }
}
