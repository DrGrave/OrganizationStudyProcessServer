package controllers;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import controllers.studentsControllers.ButtonBoxForDebtController;
import controllers.studentsControllers.TableOfDebitsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.springframework.security.access.method.P;

import java.io.IOException;


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

    private MyUser iUser;
    private MyUserCredentials myUserCredentials;
    private String token;

    public StudentController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    public void initialize() throws IOException {

        FXMLLoader debtTable = new  FXMLLoader(getClass().getResource("../samples/studentFXML/DebtTable.fxml"));
        TableOfDebitsController tableOfDebitsController = new TableOfDebitsController();
        debtTable.setController(tableOfDebitsController);
        firstSudentInfoBox.getChildren().add(debtTable.load());

        
        FXMLLoader buttonBoxForDebtTable =new  FXMLLoader(getClass().getResource("../samples/studentFXML/ButtonBoxForDebtTable.fxml"));
        ButtonBoxForDebtController buttonBoxForDebtController = new ButtonBoxForDebtController();
        buttonBoxForDebtTable.setController(buttonBoxForDebtController);
        firstSudentInfoBox.getChildren().add(buttonBoxForDebtTable.load());


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
