package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;

public class DashBoardFormController {
    public void btnMouseEntered(MouseEvent event) {

        if (event.getSource() instanceof JFXButton) {
            JFXButton icon = (JFXButton) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.4);
//            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
//            glow.setWidth(20);
//            glow.setHeight(20);
//            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void btnMouseExit(MouseEvent event) {
        if (event.getSource() instanceof JFXButton) {
            JFXButton icon = (JFXButton) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("StudentManageForm.fxml",actionEvent);
    }

    public void btnRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("RoomsMnageForm.fxml",actionEvent);
    }

    public void btnResuvationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("ResuvationForm.fxml",actionEvent);
    }
}
