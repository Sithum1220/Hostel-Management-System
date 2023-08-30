package lk.ijse.hostel.controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.hostel.controller.utill.Navigation;

import java.io.IOException;

public class RoomsManageFormController {
    public Pane bachId;
    public Pane addUpdatePane;
    public Pane hidePane;
    public Pane newRoomId;

    public void hideOnMouseClick(MouseEvent event) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);
    }

    public void doneOnAction(ActionEvent actionEvent) {
        addUpdatePane.setVisible(false);
        hidePane.setVisible(false);
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
}
