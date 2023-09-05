package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;

public class LoginFormController {
    public Pane signUpPane;
    public JFXTextField singUpUserName;
    public JFXTextField singUpPassword;
    public JFXTextField singUpConfirmPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("DashBoardForm.fxml",actionEvent);
    }

    public void createAccountOnMouseClick(MouseEvent event) {
        signUpPane.setVisible(true);
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        signUpPane.setVisible(false);

    }
}
