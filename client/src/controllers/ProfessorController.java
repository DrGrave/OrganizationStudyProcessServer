package controllers;
import com.calendarfx.util.CalendarFX;
import com.calendarfx.view.page.WeekPage;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    private MyUser iUser;
    private MyUserCredentials myUserCredentials;
    private String token;

    public ProfessorController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    public void initialize(){
        initializeInfoOfUser();
        initializeTimetableToProfessor();
        initializeCalendar();
    }

    private void initializeCalendar() {
        CalendarController calendarController = new CalendarController();

    }

    private void initializeTimetableToProfessor() {

    }

    private void initializeInfoOfUser() {
        nameField.setText(iUser.getUserName());
        surnameField.setText(iUser.getUserSurname());
        patrField.setText(iUser.getUserPatronymic());
        typeField.setText(iUser.getUserType().getNameUserType());
        emailField.setText(iUser.getEmail());
        
    }
}
