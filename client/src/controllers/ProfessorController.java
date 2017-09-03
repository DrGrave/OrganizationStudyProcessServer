package controllers;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import controllers.calendarControllers.CalendarController;
import controllers.professorControllers.CreateWorkController;
import controllers.professorControllers.ListOfStudentsController;
import controllers.professorControllers.ProfessorQueueController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    @FXML
    private VBox calendarVBox;


    @FXML
    private Tab addWorkTab;

    @FXML
    private Tab professorQueueTab;

    @FXML
    private Tab studentListTab;

    private MyUser iUser;
    private MyUserCredentials myUserCredentials;
    private String token;


    //TODO do queue adn create work!

    ProfessorController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    public void initialize() throws IOException {
        Platform.runLater(() -> {
            try {
                initializeCalendar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Platform.runLater(this::initializeInfoOfUser);
        Platform.runLater(() -> {
            try {
                initializeCreateWork();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Platform.runLater(() -> {
            try {
                initializeProfessorQueue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Platform.runLater(() -> {
            try {
                initializeListOfStudent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void initializeListOfStudent() throws IOException {
        ListOfStudentsController listOfStudentsController = new ListOfStudentsController();
        FXMLLoader listOfStudent = new FXMLLoader(getClass().getResource("../samples/professorFXML/ListOfStudents.fxml"));
        listOfStudent.setController(listOfStudentsController);
        studentListTab.setContent(listOfStudent.load());
    }

    private void initializeProfessorQueue() throws IOException {
        ProfessorQueueController professorQueueController = new ProfessorQueueController(iUser,token,myUserCredentials);
        FXMLLoader professorQueue = new FXMLLoader(getClass().getResource("../samples/professorFXML/ProfessorQueue.fxml"));
        professorQueue.setController(professorQueueController);
        professorQueueTab.setContent(professorQueue.load());
    }

    private void initializeCreateWork() throws IOException {
        CreateWorkController createWorkController = new CreateWorkController(iUser, token, myUserCredentials);
        FXMLLoader createWork = new FXMLLoader(getClass().getResource("../samples/professorFXML/CreateWork.fxml"));
        createWork.setController(createWorkController);
        addWorkTab.setContent(createWork.load());
    }

    private void initializeCalendar() throws IOException {
        CalendarController calendarController = new CalendarController(iUser, token, myUserCredentials);
        FXMLLoader calendar = new  FXMLLoader(getClass().getResource("../samples/calendarFXML/Timetable.fxml"));
        calendar.setController(calendarController);
        calendarVBox.getChildren().add(calendar.load());
    }


    private void initializeInfoOfUser() {
        nameField.setText(iUser.getUserName());
        surnameField.setText(iUser.getUserSurname());
        patrField.setText(iUser.getUserPatronymic());
        typeField.setText(iUser.getUserType().getNameUserType());
        emailField.setText(iUser.getEmail());
        
    }
}
