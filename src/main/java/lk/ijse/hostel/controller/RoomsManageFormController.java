package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.RoomService;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomsManageFormController implements Initializable {
    public Pane bachId;
    public Pane addUpdatePane;
    public Pane hidePane;
    public Pane newRoomId;
    public VBox vBox;
    public JFXButton btnCrud;
    public JFXTextField keyMoney;
    public JFXTextField roomQTY;
    public JFXTextField roomType;
    public ScrollPane scrollPane;

    RoomService roomService = ServiceFactory.getInstance()
            .getServiceFactory(ServiceFactory.ServiceType.ROOM_SERVICE);

    public void hideOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);
    }

    public void doneOnAction(ActionEvent actionEvent) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);

        if (btnCrud.getText().equals("Save")) {

            String save = roomService.saveRoom(new RoomDTO(
                    roomService.newId(),
                    roomType.getText(),
                    keyMoney.getText(),
                    Integer.parseInt(roomQTY.getText())

            ));

            if (save != null) {
                new Alert(Alert.AlertType.CONFIRMATION, "New Room Added!").showAndWait();
                loadAllIds();
            } else {
                new Alert(Alert.AlertType.ERROR, "Not Saved!").show();

            }
        }
//        else if (btnCrud.getText().equals("Update")) {
//            Name name = new Name();
//            name.setFirst_name(first_name.getText());
//            name.setLast_name(last_name.getText());
//
//            Address address = new Address();
//            address.setStreet(street.getText());
//            address.setCity(city.getText());
//            address.setHouseNo(lane.getText());
//            boolean update = studentService.update(new StudentDTO(
//                    updateId,
//                    name,
//                    address,
//                    mobileNo.getText(),
//                    dob.getValue(),
//                    getGender()
//            ));
//
//            if (update) {
//                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated!").showAndWait();
//                loadAllIds();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Student Not Updated!").show();
//            }
//        }
    }

    public void backOnMouseExit(MouseEvent event) {
        bachId.setVisible(false);

    }

    public void backOnMouseEntered(MouseEvent event) {
        bachId.setVisible(true);

    }

    public void btnAddOnMouseEntered(MouseEvent event) {
        newRoomId.setVisible(true);
    }

    public void btnAddOnMouseExit(MouseEvent event) {
        newRoomId.setVisible(false);

    }

    public void addOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(true);
        hidePane.setVisible(true);
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

    public void homeOnmouseClick(MouseEvent event) throws IOException {
        Navigation.switchNavigation("DashBoardForm.fxml",event);

    }

    public void loadAllIds() {
        vBox.getChildren().clear();
        try {
            List<String> id = roomService.getAllRoomId();
            for (int i = 0; i < id.size(); i++) {
                loadAllRooom(id.get(i));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllRooom(String id) {

        try {
            FXMLLoader loader = new FXMLLoader(RoomsManageFormController.class.getResource("/view/RoomsManageBarForm.fxml"));
            Parent root = loader.load();
            RoomsManageBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllIds();
    }
}
