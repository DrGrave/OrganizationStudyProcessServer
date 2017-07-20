package controllers;


import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import requests.LoginController;

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
    void signInEvent(ActionEvent event) {
        MyUserCredentials myUserCredentials = new MyUserCredentials(loginTextField.getText(), passwordTextField.getText());
        System.out.print(myUserCredentials);
        String token = loginController.loginEvent(myUserCredentials);
        if (token != null){
            incorrectLogPass.setVisible(false);
            myUserCredentials.setUserPassword(null);
            MyUser iUser = loginController.getUserByLogin(myUserCredentials, token);
            if (iUser.getUserType().getIdUserType() == 1) {
                openAdminStage(iUser, token, myUserCredentials);
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 2) {
                openProfessorStage(iUser, token, myUserCredentials);
                signInButtom.getScene().getWindow().hide();
            }else if (iUser.getUserType().getIdUserType() == 3) {
                openSudentStage(iUser, token, myUserCredentials);
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

    private void openAdminStage(MyUser iUser, String token, MyUserCredentials myUserCredentials) {

    }

    private void openSudentStage(MyUser iUser, String token, MyUserCredentials myUserCredentials) {

    }

    private void openProfessorStage(MyUser iUser, String token, MyUserCredentials myUserCredentials) {

    }

}