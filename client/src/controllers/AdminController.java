package controllers;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import static controllers.Controller.myUserCredentials;
import static controllers.Controller.token;
import static controllers.Controller.iUser;

public class AdminController {

    @FXML
    private TabPane adminTabPane;

    @FXML
    private AnchorPane userTab;


    @FXML
    private Tab setingsTab;

    public void initialize(){
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }



}
