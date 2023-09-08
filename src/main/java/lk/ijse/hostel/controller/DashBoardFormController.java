package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.custom.DashboardService;
import lk.ijse.hostel.service.custom.QueryService;
import lk.ijse.hostel.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    public Label pendingPayment;
    public Label availableRooms;
    public VBox vBox;
   
    public Label date;
    public Text hour;
    public Text min;
    DashboardService dashboardService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.DASHBOARD_SERVICE);
    QueryService queryService = ServiceFactory.getInstance().getServiceFactory(ServiceFactory.ServiceType.QUARY_SERVICE);

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
        Navigation.switchNavigation("StudentManageForm.fxml", actionEvent);
    }

    public void btnRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("RoomsMnageForm.fxml", actionEvent);
    }

    public void btnResuvationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("ResuvationForm.fxml", actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pendingPayment.setText(
                String.valueOf(dashboardService.getPendingPaymentCount())
        );

        availableRooms.setText(String.valueOf(dashboardService.getRoomCount()));

        List<StudentDTO> allStudent = queryService.getAllPendingPaymentStudent();
        try {
            FXMLLoader loader = new FXMLLoader(DashBoardFormController.class.getResource("/view/PendingPaymentBarForm.fxml"));
            Parent root = loader.load();
            PendingPaymentBarFormController controller = loader.getController();
            controller.setData(allStudent);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        time();
    }

    private void time() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm");
            try {
                while (true) {
                    Thread.sleep(1000);
                    String format1 = format.format(new Date());
                    String[] split = format1.split(":");
                    min.setText(split[1]);
                    hour.setText(split[0]);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d");
        date.setText(format.format(new Date()));
    }
}
