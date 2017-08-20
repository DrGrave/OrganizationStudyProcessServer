package controllers;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class ProfessorController {
    @FXML
    private AnchorPane professorAnchorPane;

    @FXML
    private TabPane professorPane;

    @FXML
    private Tab professorTab;

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
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }
}
