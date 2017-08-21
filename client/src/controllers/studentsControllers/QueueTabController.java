package controllers.studentsControllers;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class QueueTabController {

    @FXML
    private TableView<?> studentTable;

    @FXML
    private TableColumn<?, ?> studentNameCollom;

    @FXML
    private TableColumn<?, ?> studentSurnameCollom;

    @FXML
    private TableView<?> subjectTable;

    @FXML
    private TableColumn<?, ?> subjectCollom;

    @FXML
    private TableView<?> workTable;

    @FXML
    private TableColumn<?, ?> workCollom;

    @FXML
    private TableView<?> commentTable;

    @FXML
    private TableColumn<?, ?> commentToWorkCollom;

    private final MyUser iUser;
    private final MyUserCredentials myUserCredentials;
    private final String token;

    public QueueTabController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }
}
