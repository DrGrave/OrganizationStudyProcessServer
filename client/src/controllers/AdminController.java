package controllers;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class AdminController {

    @FXML
    private TabPane adminTabPane;

    @FXML
    private AnchorPane userTab;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private TextField typeOfUserTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField genderTextField;

    @FXML
    private Button changeButton;

    @FXML
    private Tab setingsTab;

    private MyUser iUser;
    private MyUserCredentials myUserCredentials;
    private String token;

    public AdminController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    @FXML
    void changeButtonAction(ActionEvent event) {

    }


    public void initialize(){
        nameTextField.setText(iUser.getUserName());
        surnameTextField.setText(iUser.getUserSurname());
        patronymicTextField.setText(iUser.getUserPatronymic());
        typeOfUserTextField.setText(iUser.getUserType().getNameUserType());
        emailTextField.setText(iUser.getEmail());
        genderTextField.setText(iUser.getGender().getNameOfGender());
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }



}
