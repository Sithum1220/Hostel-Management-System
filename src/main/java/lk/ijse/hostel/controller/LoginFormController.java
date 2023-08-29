package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import lk.ijse.hostel.controller.utill.Navigation;

import java.io.IOException;

public class LoginFormController {
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("DashBoardForm.fxml",actionEvent);
    }
}
