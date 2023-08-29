package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StudentManageFormController {
    public Pane newStudentId;
    public Pane bachId;

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

    public void countBoxMouseExit (MouseEvent event) {
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
}
