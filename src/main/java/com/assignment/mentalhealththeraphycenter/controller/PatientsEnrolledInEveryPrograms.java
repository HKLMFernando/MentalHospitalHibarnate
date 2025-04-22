package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.dto.PatientsInEveryProgramDTO;
import com.assignment.mentalhealththeraphycenter.dto.TM.PatientsInEveryProgramTM;
import com.assignment.mentalhealththeraphycenter.service.BOFactory;
import com.assignment.mentalhealththeraphycenter.service.BOType;
import com.assignment.mentalhealththeraphycenter.service.custom.PatientBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientsEnrolledInEveryPrograms implements Initializable {

    @FXML
    private TableView<PatientsInEveryProgramTM> Table;

    @FXML
    private TableColumn<String,PatientsInEveryProgramTM> tableAddress;

    @FXML
    private TableColumn<String,PatientsInEveryProgramTM> tableContact;

    @FXML
    private TableColumn<String,PatientsInEveryProgramTM> tableID;

    @FXML
    private TableColumn<String,PatientsInEveryProgramTM> tableName;

    PatientBO patientBO = BOFactory.getInstance().getBO(BOType.PATIENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableID.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tableAddress.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        tableContact.setCellValueFactory(new PropertyValueFactory<>("patientContact"));

        try {
            loadTable();
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            throw new RuntimeException(e);
        }
    }

    private void loadTable() throws RuntimeException {
        List<PatientsInEveryProgramDTO> patientsInEveryProgramDTOS = patientBO.getPatientsInEveryProgram();

        ObservableList<PatientsInEveryProgramTM> patientsInEveryProgramTMS = FXCollections.observableArrayList();

        for (PatientsInEveryProgramDTO patients : patientsInEveryProgramDTOS) {
            PatientsInEveryProgramTM patientsInEveryProgramTM = new PatientsInEveryProgramTM(
                    patients.getPatientId(),
                    patients.getPatientName(),
                    patients.getPatientAddress(),
                    patients.getPatientContact()
            );
            patientsInEveryProgramTMS.add(patientsInEveryProgramTM);
        }

        Table.setItems(patientsInEveryProgramTMS);
    }
}
