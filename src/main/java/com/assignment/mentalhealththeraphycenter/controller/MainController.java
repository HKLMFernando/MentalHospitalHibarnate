package com.assignment.mentalhealththeraphycenter.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;

public class MainController {

    @FXML
    private VBox adminVbox;

    @FXML
    private Button appointments;

    @FXML
    private Label dashBoardFrom;

    @FXML
    private AnchorPane header;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane loadAnchor;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button patients;

    @FXML
    private Button payments;

    @FXML
    private Button therapist;

    @FXML
    private Button therapyPrograms;

    @FXML
    private Button user;

    @FXML
    private VBox vbox;
    private String role;

    @Setter
    private String userName;

    @FXML
    void appointmentsAction(MouseEvent event) {
        navigateTo("/view/appointments.fxml");
        dashBoardFrom.setText("Appointment Details Form");

    }

    @FXML
    void doctorDetailsAction(MouseEvent event) {
        navigateTo("/view/Therapist.fxml");
        dashBoardFrom.setText("Therapist Details Form");
    }

    @FXML
    void patientsAction(MouseEvent event) {
        navigateTo("/view/patient.fxml");
        dashBoardFrom.setText("Patients Details Form");

    }

    @FXML
    void paymentsAction(MouseEvent event) {
        navigateTo("/view/payment.fxml");
        dashBoardFrom.setText("Payment Details Form");
    }

    @FXML
    void therapyProgramAction(MouseEvent event) {
        navigateTo("/view/TherapyPrograms.fxml");
        dashBoardFrom.setText("Therapy Programs Form");
    }

    @FXML
    void userAction(MouseEvent event) {

    }

    public void navigateTo(String fxmlPath) {
        try {
            loadAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
           // load.getStylesheets().add(getClass().getResource("/css/h.css").toExternalForm());
            load.prefWidthProperty().bind(loadAnchor.widthProperty());
            load.prefHeightProperty().bind(loadAnchor.heightProperty());
            loadAnchor.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }
    private void loadPage(String fxmlPath) throws IOException {
        Stage currentStage = (Stage) image.getScene().getWindow();
        currentStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlPath)));
        Stage stage = new Stage();
       // scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("The Serenity Mental Health Therapy Center");
        stage.show();
    }

    public void setUserRole(String role) {
        this.role = role;
        configureUI();
    }

    private void configureUI() {
        if ("admin".equals(role)) {
            adminVbox.setVisible(true);
        } else {
            adminVbox.setDisable(true);
        }
    }


}
