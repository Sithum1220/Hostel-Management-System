package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.embedded.Address;
import lk.ijse.hostel.embedded.Name;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.StudentService;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentManageFormController implements Initializable {
    public Pane newStudentId;
    public Pane bachId;
    public Pane addUpdatePane;
    public Pane hidePane;
    public ScrollPane scrollPane;
    public JFXTextField first_name;
    public JFXTextField last_name;
    public JFXTextField city;
    public JFXTextField street;
    public JFXTextField lane;
    public JFXTextField mobileNo;
    public DatePicker dob;
    public JFXComboBox cmbGender;

    StudentService studentService = ServiceFactory.getInstance()
            .getServiceFactory(ServiceFactory.ServiceType.STUDENT_SERVICE);

    public void btnAddOnMouseEntered(MouseEvent event) {
        newStudentId.setVisible(true);
    }

    public void btnAddOnMouseExit(MouseEvent event) {
        newStudentId.setVisible(false);
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

    public void backOnMouseEntered(MouseEvent event) {
        bachId.setVisible(true);
    }

    public void backOnMouseExit(MouseEvent event) {
        bachId.setVisible(false);
    }

    public void doneOnAction(ActionEvent actionEvent) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);

        Name name = new Name();
        name.setFirst_name(first_name.getText());
        name.setLast_name(last_name.getText());

        Address address = new Address();
        address.setStreet(street.getText());
        address.setCity(city.getText());
        address.setHouseNo(lane.getText());
        studentService.saveStudent(new StudentDTO(
                studentService.newId(),
                name,
                address,
                mobileNo.getText(),
                dob.getValue(),
                getGender()

        ));


    }

    public void addOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(true);
        hidePane.setVisible(true);
    }

    public void hideOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);
    }

    public void homeOnmouseClick(MouseEvent event) throws IOException {
        Navigation.switchNavigation("DashBoardForm.fxml", event);
    }

    private void setDataInComboBox() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        cmbGender.getItems().addAll(gender);
    }
    private String getGender() {
        return String.valueOf(cmbGender.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDataInComboBox();
    }
}
