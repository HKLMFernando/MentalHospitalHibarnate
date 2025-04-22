package com.assignment.mentalhealththeraphycenter.controller;

import com.assignment.mentalhealththeraphycenter.controller.UtilClasses.PasswordUtil;
import com.assignment.mentalhealththeraphycenter.controller.UtilClasses.SessionHolder;
import com.assignment.mentalhealththeraphycenter.service.BOFactory;
import com.assignment.mentalhealththeraphycenter.service.BOType;
import com.assignment.mentalhealththeraphycenter.service.custom.UserBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogingController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView image;

    @FXML
    private Button login;
    @FXML
    private TextField passwordTextField;

    @FXML
    private PasswordField passwordPWField;

    @FXML
    private TextField userName;

    @Setter
    private String role;

    UserBO userBO = BOFactory.getInstance().getBO(BOType.USER);

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        String username = userName.getText();
        String password = passwordPWField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your username and password", ButtonType.OK).show();
            return;
        }

        String role1 = SessionHolder.currentRole;
        boolean userFromDB = userBO.findUser(username);
        String passFromDB = userBO.findPassWord(username,role1);

        if (userFromDB && PasswordUtil.matches(password, passFromDB)) {
            navigateToMainPage("/view/MainLayout.fxml", "user", username);
        } else {
            new Alert(Alert.AlertType.ERROR, "Login Failed..", ButtonType.OK).show();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image adminIMage = new Image(getClass().getResourceAsStream("/icon/icons8-user-50.png"));
        image.setImage(adminIMage);
        refreshPage();
        SessionHolder.currentRole = role;
    }

    private void navigateToMainPage(String fxmlPath,String role,String userName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        MainController controller = loader.getController();
        controller.setUserRole(role);
        controller.setUserName(userName);
        Stage currentStage = (Stage) login.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("The Serenity Mental Health Therapy Center");
        currentStage.close();
        stage.show();
    }
    private void refreshPage(){
        passwordPWField.setVisible(true);
        passwordTextField.setVisible(false);
    }
}
