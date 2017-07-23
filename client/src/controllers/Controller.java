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
import javafx.scene.layout.Pane;
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



    @FXML
    void signInEvent(ActionEvent event) throws IOException {
        MyUserCredentials myUserCredentials = new MyUserCredentials(loginTextField.getText(), passwordTextField.getText());
        System.out.print(myUserCredentials);
        String token = loginController.loginEvent(myUserCredentials);
        if (token != null){
            incorrectLogPass.setVisible(false);
            myUserCredentials.setUserPassword(null);
            MyUser iUser = loginController.getUserByLogin(myUserCredentials, token);
            if (iUser.getUserType().getIdUserType() == 1) {
                openAdminStage(iUser, myUserCredentials, token);
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 2) {
                openProfessorStage(iUser, myUserCredentials, token);
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 3) {
                openStudentStage(iUser, myUserCredentials, token);
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

    private void openAdminStage(MyUser iUser, MyUserCredentials myUserCredentials, String token) throws IOException {
        Stage stage = new Stage();
        AdminController adminController = new AdminController(iUser, myUserCredentials, token);
        FXMLLoader load = new  FXMLLoader(getClass().getResource("../samples/Admin.fxml"));
        load.setController(adminController);
        Scene scene = new Scene(load.load());
        stage.setScene(scene);
        stage.setTitle("Admin client");
        stage.show();
    }

    private void openStudentStage(MyUser iUser, MyUserCredentials myUserCredentials, String token) throws IOException {
        Stage stage = new Stage();
        StudentController studentController = new StudentController(iUser, myUserCredentials, token);
        FXMLLoader root = new  FXMLLoader(getClass().getResource("../samples/Student.fxml"));
        root.setController(studentController);
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.setTitle("Student client");
        stage.show();
    }

    private void openProfessorStage(MyUser iUser, MyUserCredentials myUserCredentials, String token) throws IOException {
        Stage stage = new Stage();
        ProfessorController professorController = new ProfessorController(iUser, myUserCredentials, token);
        FXMLLoader root =  new  FXMLLoader(getClass().getResource("../samples/Professor.fxml"));
        root.setController(professorController);
        Scene scene = new Scene(root.load());
        stage.setScene(scene);
        stage.setTitle("Professor client");
        stage.show();
    }

}