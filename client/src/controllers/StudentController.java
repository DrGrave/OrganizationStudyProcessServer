package controllers;
import com.vkkzlabs.entity.MyUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.springframework.security.access.method.P;

import java.io.IOException;

import static controllers.Controller.myUserCredentials;
import static controllers.Controller.token;
import static controllers.Controller.iUser;

public class StudentController {
    @FXML
    private AnchorPane studentMainPane;
    @FXML
    private TabPane studentTabPane;
    @FXML
    private Tab studentUserTab;
    @FXML
    private TextField userName;
    @FXML
    private TextField userSurname;
    @FXML
    private TextField userPatronymic;
    @FXML
    private TextField userGender;
    @FXML
    private TextField userGroup;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField userType;
    @FXML
    private VBox firstSudentInfoBox;

    @FXML
    private VBox secondStudentInfoBox;

    @FXML
    private Button changeButton;
    @FXML
    private Tab studentSettingsTab;
    @FXML
    void changeUserInfoButton(ActionEvent event) {

    }

    public void initialize() throws IOException {
//        userName.setText(iUser.getUserName());
//        userSurname.setText(iUser.getUserSurname());
//        userPatronymic.setText(iUser.getUserPatronymic());
//        userGender.setText(iUser.getGender().getNameOfGender());
//        userGroup.setText(iUser.getStudentGroup().getNumberOfGroup());
//        userEmail.setText(iUser.getEmail());
//        userType.setText(iUser.getUserType().getNameUserType());
        Parent debtTable = FXMLLoader.load(getClass().getResource("../samples/studentFXML/DebtTable.fxml"));
        
        Parent buttonBoxForDebtTable = FXMLLoader.load(getClass().getResource("../samples/studentFXML/ButtonBoxForDebtTable.fxml"));
        firstSudentInfoBox.getChildren().add(debtTable);
        firstSudentInfoBox.getChildren().add(buttonBoxForDebtTable);

        checkForBadStudent(iUser);
        checkForAchievement(iUser);
        checkForNewWorks(iUser);
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }

    private void checkForNewWorks(MyUser iUser) {

    }

    private void checkForAchievement(MyUser iUser) {

    }

    private void checkForBadStudent(MyUser iUser) {

    }
}
