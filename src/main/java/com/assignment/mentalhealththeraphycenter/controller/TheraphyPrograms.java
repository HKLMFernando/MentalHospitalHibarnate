package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.dto.ProgramDto;
import com.assignment.mentalhealththeraphycenter.dto.TM.ProgramTM;
import com.assignment.mentalhealththeraphycenter.dto.TherapyProgramDTO;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TheraphyPrograms  implements Initializable {

    @FXML
    private TextField ProgramDetails;

    @FXML
    private TextField ProgramFee;

    @FXML
    private TextField ProgramName;

    @FXML
    private TableView<ProgramTM> Table;

    @FXML
    private Button delete;

    @FXML
    private ImageView image;

    @FXML
    private Label labelLoadID;

    @FXML
    private Button reset;

    @FXML
    private Button save;

    @FXML
    private TableColumn<ProgramTM, Double> tableFee;

    @FXML
    private TableColumn<ProgramTM, String> tableIID;

    @FXML
    private TableColumn<ProgramTM, String> tableName;

    @FXML
    private TableColumn<ProgramTM, String> tableProgramDetails;

    @FXML
    private Button update;

    TProgramBO tProgramBO = BOFactory.getInstance().getBO(BOType.THERAPY_PROGRAMS);

    @FXML
    void deleteBtnAction(ActionEvent event) throws Exception {
        String programID = labelLoadID.getText();
        boolean isDeleted = tProgramBO.deleteTProgram(programID);
        if (isDeleted) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Programs Deleted").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Programs Not Deleted").show();
        }
    }

    @FXML
    void resetBtnAction(ActionEvent event) throws Exception {
        refreshPage();
    }

    @FXML
    void saveBtnAction(ActionEvent event) throws Exception {
        String therapyPID = labelLoadID.getText();
        String therapyProgramName = ProgramName.getText();
        String therapyProgramDetails = ProgramDetails.getText();
        Double therapyProgramFee = Double.parseDouble(ProgramFee.getText());


        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                therapyPID,
                therapyProgramName,
                therapyProgramDetails,
                therapyProgramFee
        );
        boolean isSaved = tProgramBO.saveTPrograms(therapyProgramDTO);

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Therapy Program Saved").show();
            refreshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Therapy Program Not Saved").show();
        }
    }

    @FXML
    void tableAction(MouseEvent event) {
        ProgramTM selectedPatient = Table.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            labelLoadID.setText(selectedPatient.getTherapyID());
            ProgramName.setText(selectedPatient.getTherapyName());
            ProgramDetails.setText(selectedPatient.getTherapyDescription());
            ProgramFee.setText(String.valueOf(selectedPatient.getTherapyFee()));
        }
    }

    @FXML
    void updateBtnAction(ActionEvent event) throws Exception {
        String therapyPID = labelLoadID.getText();
        String therapyProgramName = ProgramName.getText();
        String therapyProgramDetails = ProgramDetails.getText();
        Double therapyProgramFee = Double.parseDouble(ProgramFee.getText());

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                therapyPID,
                therapyProgramName,
                therapyProgramDetails,
                therapyProgramFee
        );
        boolean isUpdated = tProgramBO.updateTPrograms(therapyProgramDTO);

        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Therapy Programs updated successfully").show();
            refreshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Therapy Programs updating Failed").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableIID.setCellValueFactory(new PropertyValueFactory<>("therapyID"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("therapyName"));
        tableProgramDetails.setCellValueFactory(new PropertyValueFactory<>("therapyDescription"));
        tableFee.setCellValueFactory(new PropertyValueFactory<>("therapyFee"));

        try{
            refreshPage();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to Load the Page", ButtonType.OK).show();
        }
    }

    private void refreshPage() throws Exception {
        loadTable();
        labelLoadID.setText(tProgramBO.getNextProgramID());
        ProgramName.clear();
        ProgramDetails.clear();
        ProgramFee.clear();
    }

    private void loadTable() throws Exception {
        List<ProgramDto> programDtos =  tProgramBO.getALL();
        ObservableList<ProgramTM> programTMS = FXCollections.observableArrayList();
        for (ProgramDto programDto : programDtos) {

            ProgramTM programTM = new ProgramTM(
                    programDto.getTherapyID(),
                    programDto.getTherapyName(),
                    programDto.getTherapyDescription(),
                    programDto.getTherapyFee()
            );
            programTMS.add(programTM);
        }
        Table.setItems(programTMS);

    }
}
