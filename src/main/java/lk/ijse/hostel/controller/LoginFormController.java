package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.UserService;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class LoginFormController {
    public Pane signUpPane;
    public JFXTextField singUpUserName;
    public JFXPasswordField loginPassword;
    public JFXTextField loginUserName;
    public JFXTextField passwordShow;
    public JFXPasswordField singUpPassword;
    public JFXPasswordField singUpConfirmPassword;

    private UserService userService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.USER_Service);


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String password = loginPassword.getText();
        String userName = loginUserName.getText();
//        String pswdFildPassword = txtShowPassWord.getText();

        try {
            System.out.println(userName);
            UserDTO user = userService.get(userName);

            if (user == null) {
                loginUserName.requestFocus();
                loginUserName.setFocusColor(RED);

            } else {
                if (password.equals(user.getPassWord()) /*|| pswdFildPassword.equals(user.getPassWord())*/) {
                    if (userName.equals(user.getUserName())) {

                        Navigation.switchNavigation("DashBoardForm.fxml", actionEvent);

                        new Alert(Alert.AlertType.CONFIRMATION, "WELCOME!").show();

                    } else {
                        loginUserName.requestFocus();
                        loginUserName.setFocusColor(RED);
                    }
                } else {
                }
            }
            clearTextFeild();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createAccountOnMouseClick(MouseEvent event) {
        signUpPane.setVisible(true);
    }

    public void btnSignUpOnAction(ActionEvent actionEvent) {

        if (singUpUserName.getText().isEmpty() && singUpPassword.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Added Data First!").show();

        } else {
            String tempSingUpPassword = singUpPassword.getText();
            String tempSingUpConfirmPassword = singUpConfirmPassword.getText();
            if (tempSingUpPassword.equals(tempSingUpConfirmPassword)) {
                System.out.println("Paw");
                UserDTO userDTO = new UserDTO();
                userDTO.setUserName(singUpUserName.getText());
                userDTO.setPassWord(singUpPassword.getText());
                String save = userService.save(userDTO);
                if (save != null) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Added!").showAndWait();
                    signUpPane.setVisible(false);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Not Added!").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Password Not Match").showAndWait();
            }
            clearTextFeild();
        }
    }

    public void clearTextFeild() {
        singUpUserName.clear();
        singUpPassword.clear();
        loginPassword.clear();
        loginUserName.clear();
        singUpConfirmPassword.clear();
    }
}
