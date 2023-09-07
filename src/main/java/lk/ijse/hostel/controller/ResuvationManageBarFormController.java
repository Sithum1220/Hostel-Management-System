package lk.ijse.hostel.controller;

import javafx.scene.text.Text;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.ResuvationService;
import lk.ijse.hostel.service.custom.StudentService;

public class ResuvationManageBarFormController {

    public Text id;
    public Text studentIdAndName;
    public Text status;
    public Text roomID;
    public Text date;
    ResuvationService resuvationService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.RESERVATION_SERVICE);

    public void setData(String id) {
        ReservationDTO reservationDTO = resuvationService.getReservetion(id);
        this.id.setText(reservationDTO.getResNo());
        roomID.setText(reservationDTO.getRId());
        date.setText(reservationDTO.getDate());
        studentIdAndName.setText(reservationDTO.getSId());
        status.setText(reservationDTO.getStatus());

    }
}
