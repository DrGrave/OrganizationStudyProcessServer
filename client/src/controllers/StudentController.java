package controllers;


import com.vkkzlabs.entity.M2MUserAchievements;
import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import controllers.studentsControllers.TableOfDebitsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import requests.AchievementsRequest;


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
    private HBox hBoxStudentInfo;
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

    StudentController(MyUser iUser, MyUserCredentials myUserCredentials, String token) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
    }

    public void initialize() throws IOException {



//        FXMLLoader achievements = new  FXMLLoader(getClass().getResource("../samples/studentFXML/Achievements.fxml"));
//        AchievementsController achievementsController = new AchievementsController();
//        achievements.setController(achievementsController);
//        hBoxStudentInfo.getChildren().add(achievements.load());

        checkForAchievement(iUser);
        checkForBadStudent(iUser);
        checkForNewWorks(iUser);
        System.out.print(iUser.getIdUser());
        System.out.print(token);
        System.out.print(myUserCredentials.getUserLogin());
    }

    private void checkForNewWorks(MyUser iUser) {

    }

    private void checkForAchievement(MyUser iUser) {
        AchievementsRequest achievementsRequest = new AchievementsRequest();
        M2MUserAchievements[] achievements;
        achievements = achievementsRequest.getAchievementByUser(iUser, token);
        GridPane gridPane = new GridPane();
        gridPane.addColumn(0);
        gridPane.addColumn(1);
        int[] i = {1,0};
        for (M2MUserAchievements m2MUserAchievements : achievements){
            setGetedAchievements(m2MUserAchievements, gridPane, i);
        }

        ScrollPane splitPane = new ScrollPane();
        gridPane.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        splitPane.setContent(gridPane);
        splitPane.setPrefSize(330, Region.USE_COMPUTED_SIZE);
        hBoxStudentInfo.getChildren().add(splitPane);

    }

    private void setGetedAchievements(M2MUserAchievements m2MUserAchievements, GridPane gridPane, int[] i) {

        ImageView imageView = new ImageView();
        imageView.setImage(Image.impl_fromPlatformImage(m2MUserAchievements.getAchievement().getImageIcon()));
        Label label = new Label();
        Tooltip tooltip = new Tooltip();
        tooltip.setText(m2MUserAchievements.getAchievement().getTextOfAchievement());
        label.setText(m2MUserAchievements.getAchievement().getNameOfAchievement());
        imageView.setFitHeight(90);
        imageView.setFitWidth(120);
        VBox.setMargin(imageView, new Insets(20,0,0,35));
        VBox.setMargin(label, new Insets(5,0,0,45));
        VBox vBox = new VBox();


        Tooltip.install(vBox, tooltip);


        vBox.getChildren().addAll(imageView, label);
        if ((i[0] & 1) == 0) {
            gridPane.add(vBox, 0, i[1]);
            i[0]++;
            i[1]++;
        }else{
            gridPane.add(vBox, 1, i[1]);
            i[0]++;
        }

    }

    private void checkForBadStudent(MyUser iUser) throws IOException {
        FXMLLoader debtTable = new  FXMLLoader(getClass().getResource("../samples/studentFXML/DebtTable.fxml"));
        TableOfDebitsController tableOfDebitsController = new TableOfDebitsController(iUser, token, myUserCredentials);
        debtTable.setController(tableOfDebitsController);
        hBoxStudentInfo.getChildren().add(debtTable.load());
    }
}