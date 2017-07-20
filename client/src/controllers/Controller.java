package controllers;


import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import requests.LoginController;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button signInButtom;

    @FXML
    private Label incorrectLogPass;

    @FXML
    private GridPane logInForm;

    private LoginController loginController = new LoginController();

    static MyUserCredentials myUserCredentials;
    static String token;
    static MyUser iUser;

    @FXML
    void signInEvent(ActionEvent event) throws IOException {
        myUserCredentials = new MyUserCredentials(loginTextField.getText(), passwordTextField.getText());
        System.out.print(myUserCredentials);
        token = loginController.loginEvent(myUserCredentials);
        if (token != null){
            incorrectLogPass.setVisible(false);
            myUserCredentials.setUserPassword(null);
            iUser = loginController.getUserByLogin(myUserCredentials, token);
            if (iUser.getUserType().getIdUserType() == 1) {
                openAdminStage();
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 2) {
                openProfessorStage();
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 3) {
                openStudentStage();
                signInButtom.getScene().getWindow().hide();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("No such user type! Say to administrator");
                alert.showAndWait();
            }

        }else {
            incorrectLogPass.setStyle("-fx-text-fill: red");
            incorrectLogPass.setVisible(true);
        }
    }

    private void openAdminStage() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../samples/Admin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void openStudentStage() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../samples/Student.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void openProfessorStage() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../samples/Professor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}