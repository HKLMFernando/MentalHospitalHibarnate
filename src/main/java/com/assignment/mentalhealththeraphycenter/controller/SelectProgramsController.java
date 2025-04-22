package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.dto.ProgramDto;
import com.assignment.mentalhealththeraphycenter.dto.TM.ProgramTM;
import com.assignment.mentalhealththeraphycenter.dto.TM.TProgramTM;
import com.assignment.mentalhealththeraphycenter.service.BOFactory;
import com.assignment.mentalhealththeraphycenter.service.BOType;
import com.assignment.mentalhealththeraphycenter.service.custom.TProgramBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.Setter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectProgramsController implements Initializable {

    @FXML
    private TableView<ProgramTM> Table;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Button select;

    @FXML
    private TableColumn<TProgramTM, Double> tableFee;

    @FXML
    private TableColumn<TProgramTM, String> tableIID;

    @FXML
    private TableColumn<TProgramTM, String> tableName;

    @FXML
    private TableColumn<TProgramTM, String> tableProgramDetails;

    TProgramBO tProgramBO = BOFactory.getInstance().getBO(BOType.THERAPY_PROGRAMS);

    @Setter
    private AppointmentsController appointmentsController;


    @FXML
    void selectBtnAction(ActionEvent event) {
        String ID = idLabel.getText();
        String Name = nameLabel.getText();
        if (appointmentsController != null) {
            appointmentsController.setDetails(ID, Name);
        }
    }

    @FXML
    void tableAction(MouseEvent event) {
        ProgramTM selectedPatient = Table.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            idLabel.setText(selectedPatient.getTherapyID());
            nameLabel.setText(selectedPatient.getTherapyName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableIID.setCellValueFactory(new PropertyValueFactory<>("therapyID"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("therapyName"));
        tableProgramDetails.setCellValueFactory(new PropertyValueFactory<>("therapyDescription"));
        tableFee.setCellValueFactory(new PropertyValueFactory<>("therapyFee"));

        try {
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Load Page", ButtonType.OK).show();
        }
    }
    private void loadTable() throws Exception {
        List<ProgramDto> therapyProgramDTOS =  tProgramBO.getALLTPrograms();
        ObservableList<ProgramTM> tProgramTMS = FXCollections.observableArrayList();
        for (ProgramDto programDto : therapyProgramDTOS) {
            ProgramTM programTM = new ProgramTM(
                    programDto.getTherapyID(),
                    programDto.getTherapyName(),
                    programDto.getTherapyDescription(),
                    programDto.getTherapyFee()
            );
            tProgramTMS.add(programTM);
        }
        Table.setItems(tProgramTMS);
    }
}
