package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.dto.PatientDTO;
import com.assignment.mentalhealththeraphycenter.dto.TM.PatientTM;
import com.assignment.mentalhealththeraphycenter.service.BOFactory;
import com.assignment.mentalhealththeraphycenter.service.BOType;
import com.assignment.mentalhealththeraphycenter.service.custom.PatientBO;
import com.assignment.mentalhealththeraphycenter.service.custom.impl.PatientBOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<PatientTM,String> colAddrsee;

    @FXML
    private TableColumn<PatientTM,String> colBirth;

    @FXML
    private TableColumn<PatientTM,String> colGender;


    @FXML
    private TableColumn<PatientTM,String> colMobile;

    @FXML
    private TableColumn<PatientTM,String> colName;

    @FXML
    private TableColumn<PatientTM,String> colNic;

    @FXML
    private TableColumn<PatientTM,String> colPatientId;
    @FXML
    private TableColumn<PatientTM, String> ColEmail;


    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private Label lblPaymentId;

    @FXML
    private TableView<PatientTM> tblPatients;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtPatientAddress;

    @FXML
    private TextField txtPatientAge;



    @FXML
    private TextField txtPatientMobile;

    @FXML
    private TextField txtpatientName;
    @FXML
    private TextField txtEmail;

    PatientBO patientBO = BOFactory.getInstance().getBO(BOType.PATIENT);

    @FXML
    void btnDeleteOnClick(ActionEvent event) throws Exception {
        String patientID = lblPaymentId.getText();

        if (patientID.isEmpty()) {
            new Alert(Alert.AlertType.CONFIRMATION, " Please select data from table",ButtonType.CLOSE).show();
            return;
        }
        boolean isDeleted = patientBO.deletePatient(patientID);
        if (isDeleted) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Deletion Failed",ButtonType.OK).show();
        }
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws Exception {
        String patientID = lblPaymentId.getText();
        String patientName = txtpatientName.getText();
        String patientBirthDate = txtPatientAge.getText();
        String patientNIC = txtNIC.getText();
        String patientGender = genderBox.getValue();
        String patientAddress = txtPatientAddress.getText();
        String patientPhone = txtPatientMobile.getText();
        String patientEmail = txtEmail.getText();

        if (patientID.isEmpty() || patientName.trim().isEmpty() || patientBirthDate.isEmpty() || patientNIC.isEmpty() || patientGender.trim().isEmpty() || patientAddress.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please select data from table",ButtonType.CLOSE).show();
            return;
        }

        PatientDTO patientDTO = new PatientDTO(
                patientID,
                patientName,
                patientBirthDate,
                patientNIC,
                patientGender,
                patientAddress,
                patientPhone,
                patientEmail
        );

        boolean isUpdated = patientBO.savePatient(patientDTO);
        if (isUpdated) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "PatientDAOImpl updated successfully", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "PatientDAOImpl updated Failed",ButtonType.OK).show();
        }


    }
    @FXML
    void tableAction(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnClick(ActionEvent event) throws Exception {
        String patientID = lblPaymentId.getText();
        String patientName = txtpatientName.getText();
        String patientBirthDate = txtPatientAge.getText();
        String patientNIC = txtNIC.getText();
        String patientGender = genderBox.getValue();
        String patientAddress = txtPatientAddress.getText();
        String patientPhone = txtPatientMobile.getText();
        String patientEmail = txtEmail.getText();

        if (patientID.isEmpty() || patientName.trim().isEmpty() || patientBirthDate.isEmpty() || patientNIC.isEmpty() || patientGender.trim().isEmpty() || patientAddress.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please select data from table",ButtonType.CLOSE).show();
            return;
        }

        PatientDTO patientDTO = new PatientDTO(
                patientID,
                patientName,
                patientBirthDate,
                patientNIC,
                patientGender,
                patientAddress,
                patientPhone,
                patientEmail
        );

        boolean isUpdated = patientBO.updatePatient(patientDTO);
        if (isUpdated) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "PatientDAOImpl updated successfully", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "PatientDAOImpl updated Failed",ButtonType.OK).show();
        }


    }
    private void loadTableData() throws Exception {

        List<PatientDTO> patientDTOS = patientBO.getALL();
        ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();

        for (PatientDTO patientDTO : patientDTOS) {
            PatientTM patientTM = new PatientTM(
                    patientDTO.getPatientID(),
                    patientDTO.getPatientName(),
                    patientDTO.getPatientBirthDate(),
                    patientDTO.getPatientNIC(),
                    patientDTO.getPatientGender(),
                    patientDTO.getPatientAddress(),
                    patientDTO.getPatientPhone(),
                    patientDTO.getPatientEmail()

            );
            patientTMS.add(patientTM);
        }

        tblPatients.setItems(patientTMS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("patientBirthDate"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("patientPhone"));
        colAddrsee.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("patientNIC"));
        ColEmail.setCellValueFactory(new PropertyValueFactory<>("patientEmail"));


        try {
            refreshPage();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Failed ").show();
            throw new RuntimeException(e);
        }
    }

    private void refreshPage() throws Exception {
        loadTableData();
        lblPaymentId.setText(patientBO.getNextPatientID());
        txtpatientName.clear();
        txtPatientAge.clear();
        txtNIC.clear();
        genderBox.setItems(FXCollections.observableArrayList("Male", "Female"));
        txtPatientAddress.clear();
        txtPatientMobile.clear();
        txtEmail.clear();
    }

    public void tableAction(javafx.scene.input.MouseEvent mouseEvent) {
        PatientTM selectedPatient = tblPatients.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            lblPaymentId.setText(selectedPatient.getPatientID());
            txtpatientName.setText(selectedPatient.getPatientName());
            txtPatientAge.setText(selectedPatient.getPatientBirthDate());
            txtNIC.setText(selectedPatient.getPatientNIC());
            genderBox.setValue(selectedPatient.getPatientGender());
            txtPatientAddress.setText(selectedPatient.getPatientAddress());
            txtPatientMobile.setText(selectedPatient.getPatientPhone());
            txtEmail.setText(selectedPatient.getPatientEmail());

        }

    }
}
