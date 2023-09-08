package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.projection.CustomDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.ResuvationService;
import lk.ijse.hostel.service.custom.RoomService;
import lk.ijse.hostel.service.custom.StudentService;
import lk.ijse.hostel.utill.DateTimeUtil;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ResuvationFormController implements Initializable {
    public Pane bachId;
    public Pane addUpdatePane;
    public Pane hidePane;
    public Pane newReservationId;
    public VBox vBox;
    public JFXTextField txtkeyMoney;
    public JFXComboBox cmbRoomId;
    public JFXComboBox cmbStudentId;
    public Label lblRoomType;
    public VBox vBoxCart;
    public JFXComboBox cmbPaymentStatus;

    List<CustomDTO> customDTOList = new ArrayList<>();
    StudentService studentService = ServiceFactory.getInstance()
            .getServiceFactory(ServiceFactory.ServiceType.STUDENT_SERVICE);
    RoomService roomService = ServiceFactory.getInstance()
            .getServiceFactory(ServiceFactory.ServiceType.ROOM_SERVICE);

    ResuvationService resuvationService = ServiceFactory.getInstance()
            .getServiceFactory(ServiceFactory.ServiceType.RESERVATION_SERVICE);

    public void hideOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);
    }

    public void countBoxMouseEntered(MouseEvent event) {
        if (event.getSource() instanceof Pane) {
            Pane icon = (Pane) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.1);
            scaleT.setToY(1.1);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(10);
            glow.setHeight(10);
            glow.setRadius(10);
            icon.setEffect(glow);
        }
    }

    public void countBoxMouseExit(MouseEvent event) {
        if (event.getSource() instanceof Pane) {
            Pane icon = (Pane) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

        }
    }

    public void addOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(true);
        hidePane.setVisible(true);
        vBoxCart.getChildren().clear();
    }

    public void btnAddOnMouseEntered(MouseEvent event) {
        newReservationId.setVisible(true);

    }

    public void btnAddOnMouseExit(MouseEvent event) {
        newReservationId.setVisible(false);

    }

    public void backOnMouseEntered(MouseEvent event) {
        bachId.setVisible(true);

    }

    public void backOnMouseExit(MouseEvent event) {
        bachId.setVisible(false);

    }

    public void doneOnAction(ActionEvent actionEvent) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);

        boolean save = false;
        for (int i = 0; i < customDTOList.size(); i++) {
            RoomDTO roomDTO = roomService.getRoom(customDTOList.get(i).getRoomId());
            roomDTO.setQty(roomDTO.getQty() - 1);

            save = resuvationService.save(new ReservationDTO(
                    resuvationService.newId(),
                    customDTOList.get(i).getStudentId(),
                    customDTOList.get(i).getRoomId(),
                    customDTOList.get(i).getDate(),
                    customDTOList.get(i).getStatus()
            ), roomDTO);
        }


        if (save) {
            new Alert(Alert.AlertType.CONFIRMATION, "New Student Added!").showAndWait();
            loadAllIds();
            textField();
            vBoxCart.getChildren().clear();
            customDTOList.clear();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Saved!").show();
            textField();
            vBoxCart.getChildren().clear();
            customDTOList.clear();
        }
    }

    public void homeOnmouseClick(MouseEvent event) throws IOException {
        Navigation.switchNavigation("DashBoardForm.fxml", event);

    }

    public void addOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = studentService.getStudent(getStudent());
        RoomDTO roomDTO = roomService.getRoom(getRoom());

        CustomDTO customDTO = new CustomDTO();
        customDTO.setStudentId(studentDTO.getStudentId());
        customDTO.setStudentName(studentDTO.getName().getFirst_name() + " " + studentDTO.getName().getLast_name());

        customDTO.setRoomId(roomDTO.getId());
        customDTO.setRoomType(roomDTO.getType());
        customDTO.setStatus(getStatus());
        customDTO.setDate(DateTimeUtil.dateNow());
        customDTOList.add(customDTO);
        vBoxCart.getChildren().clear();
        for (int i = 0; i < customDTOList.size(); i++) {
            try {

                FXMLLoader loader = new FXMLLoader(ResuvationFormController.class.getResource("/view/ResuvationAddManageBarForm.fxml"));
                Parent root = loader.load();
                ResuvationAddManageBarFormController controller = loader.getController();
                controller.setData(customDTOList.get(i).getStudentId(), customDTOList.get(i).getRoomId(),
                        customDTOList.get(i).getRoomType(), customDTOList.get(i).getStudentName(),
                        customDTOList.get(i).getStatus(), customDTOList.get(i).getDate());
                vBoxCart.getChildren().add(root);
                textField();

            } catch (IOException e) {
                System.out.println("Catch");
                throw new RuntimeException(e);
            }

        }
    }

    public void textField() {
        cmbRoomId.getItems().clear();
        cmbStudentId.getItems().clear();
        cmbPaymentStatus.getItems().clear();
        setRoomIdInComboBox();
        setStudentIdInComboBox();
        setStatusInComboBox();
    }

    private void setRoomIdInComboBox() {
        List<String> list = roomService.getAllRoomId();
        cmbRoomId.getItems().addAll(list);
    }

    private void setStudentIdInComboBox() {
        List<String> list = studentService.getAllStudentId();
        cmbStudentId.getItems().addAll(list);
    }

    private String getRoom() {
        return String.valueOf(cmbRoomId.getSelectionModel().getSelectedItem());
    }

    private String getStudent() {
        return String.valueOf(cmbStudentId.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllIds();
        setRoomIdInComboBox();
        setStudentIdInComboBox();
        setStatusInComboBox();
    }

    private void setStatusInComboBox() {
        ArrayList<String> status = new ArrayList<>();
        status.add("Paid");
        status.add("Pending Payment");
        cmbPaymentStatus.getItems().addAll(status);
    }

    public void loadAllIds() {
        vBox.getChildren().clear();
        try {
            List<String> id = resuvationService.getAllReservationId();
            for (int i = 0; i < id.size(); i++) {
                loadAllStudent(id.get(i));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllStudent(String id) {

        try {
            FXMLLoader loader = new FXMLLoader(ResuvationFormController.class.getResource("/view/ResuvationManageBarForm.fxml"));
            Parent root = loader.load();
            ResuvationManageBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getStatus() {
        return String.valueOf(cmbPaymentStatus.getSelectionModel().getSelectedItem());
    }
}
