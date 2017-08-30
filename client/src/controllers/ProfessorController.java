package controllers;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import controllers.calendarControllers.CalendarController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ProfessorController {
    @FXML
    private AnchorPane professorAnchorPane;

    @FXML
    private TabPane professorPane;

    @FXML
    private Tab professorTab;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField patrField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField emailField;

    @FXML
    private Tab professorSettingsTab;

    @FXML
    private HBox userInfohBox;

    private MyUser iUser;
    private MyUserCredentials myUserCredentials;
    private String token;

    public ProfessorController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    public void initialize() throws IOException {
        initializeInfoOfUser();
        initializeCalendar();
    }

    private void initializeCalendar() throws IOException {
        CalendarController calendarController = new CalendarController(iUser, token, myUserCredentials);
        FXMLLoader calendar = new  FXMLLoader(getClass().getResource("../samples/calendarFXML/Timetable.fxml"));
        calendar.setController(calendarController);
        userInfohBox.getChildren().add(calendar.load());
    }


    private void initializeInfoOfUser() {
        nameField.setText(iUser.getUserName());
        surnameField.setText(iUser.getUserSurname());
        patrField.setText(iUser.getUserPatronymic());
        typeField.setText(iUser.getUserType().getNameUserType());
        emailField.setText(iUser.getEmail());
        
    }
}
