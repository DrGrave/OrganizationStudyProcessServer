package controllers.studentsControllers;

import com.vkkzlabs.api.entity.M2MStudentWork;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by vadim on 23.08.17.
 */
public class TableOfMarksController {
    @FXML
    private TableView<M2MStudentWork> subjectTable;

    @FXML
    private TableColumn<M2MStudentWork, String> subjectCollom;

    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;

    public TableOfMarksController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.token = token;
        this.myUserCredentials = myUserCredentials;
    }


    public void initialize(){

    }
}
