package controllers;
import com.vkkzlabs.entity.MyUser;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
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
    private Tab studentSettingsTab;

    public void initialize(){
        checkForBadStudent(iUser);
        checkForAchievement(iUser);
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }

    private void checkForAchievement(MyUser iUser) {

    }

    private void checkForBadStudent(MyUser iUser) {

    }
}
