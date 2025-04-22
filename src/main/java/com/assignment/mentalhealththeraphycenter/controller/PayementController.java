package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.dto.PaymentDTO;
import com.assignment.mentalhealththeraphycenter.dto.TM.PaymentTM;
import com.assignment.mentalhealththeraphycenter.service.BOFactory;
import com.assignment.mentalhealththeraphycenter.service.BOType;
import com.assignment.mentalhealththeraphycenter.service.custom.PaymentBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PayementController implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    private TableView<PaymentTM> table;

    @FXML
    private TableColumn<PaymentTM, Double> tablePayAmount;

    @FXML
    private TableColumn<PaymentTM, String> tablePayDate;

    @FXML
    private TableColumn<PaymentTM, String> tablePayID;

    @FXML
    private TableColumn<PaymentTM,String> tablePayMethod;

    @FXML
    private TableColumn<PaymentTM, String> tablePayTime;

    @FXML
    private TableColumn<PaymentTM, String> tablePayerName;

    PaymentBO paymentBO = BOFactory.getInstance().getBO(BOType.PAYMENT);

    @FXML
    void tableAction(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablePayID.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        tablePayerName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tablePayAmount.setCellValueFactory(new PropertyValueFactory<>("paymentAmount"));
        tablePayMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        tablePayDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        tablePayTime.setCellValueFactory(new PropertyValueFactory<>("paymentTime"));

        try{
            loadTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error Failed to load Page", ButtonType.OK).show();
        }
    }

    private  void  loadTable() throws Exception {
        List<PaymentDTO> paymentDTOS =  paymentBO.getALL();
        ObservableList<PaymentTM> paymentTMS = FXCollections.observableArrayList();

        for (PaymentDTO paymentDTO : paymentDTOS) {
            PaymentTM paymentTM = new PaymentTM(
                    paymentDTO.getPaymentID(),
                    paymentDTO.getPatientName(),
                    paymentDTO.getPaymentAmount(),
                    paymentDTO.getPaymentMethod(),
                    paymentDTO.getPaymentDate(),
                    paymentDTO.getPaymentTime()
            );
            paymentTMS.add(paymentTM);
        }
        table.setItems(paymentTMS);
    }
}
