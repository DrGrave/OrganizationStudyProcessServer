package controllers;


import com.vkkzlabs.api.entity.*;
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
import requests.SettingsRequest;
import requests.StudentWorksController;
import requests.SupportFilesRequest;


import javax.swing.*;
import java.io.*;
import java.sql.Date;
import java.util.Arrays;


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
    private Button acceptButton;
    @FXML
    private Button declineButton;
    @FXML
    private Tab queueTab;
    @FXML
    private Tab marksTab;
    @FXML
    void acceptButtonEvent(ActionEvent event) {

    }



    @FXML
    void changeUserInfoButton(ActionEvent event) {

    }

    @FXML
    void declineButtonEvent(ActionEvent event) {

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
        initializeInfoOfStudent(iUser);
        initializeCreateFolders();


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

    private void initializeCreateFolders() throws FileNotFoundException, UnsupportedEncodingException {
        SettingsRequest settingsRequest = new SettingsRequest();
        M2MUserSettings m2MUserSettings = settingsRequest.getSettingByUserAndSittingId(iUser, token, 1);
        if (settingsRequest.getSettingByUserAndSittingId(iUser, token, 1) == null) {
            m2MUserSettings = new M2MUserSettings();
            UserSettings userSettings = settingsRequest.getSettingById(1,token);
            m2MUserSettings.setSetting(userSettings);
            m2MUserSettings.setMyUser(iUser);
            m2MUserSettings.setSettingOn(true);
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f.showSaveDialog(null);
            m2MUserSettings.setPathToDirectoty(String.valueOf(f.getSelectedFile()));
            settingsRequest.saveUserSetting(m2MUserSettings, token);
        }else
        if ( !settingsRequest.getSettingByUserAndSittingId(iUser,token,1 ).isSettingOn())
        {
            m2MUserSettings.setSettingOn(true);
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            f.showSaveDialog(null);
            m2MUserSettings.setPathToDirectoty(String.valueOf(f.getSelectedFile()));
            settingsRequest.editUserSetting(m2MUserSettings, token);
        }
            StudentWorksController studentWorksController = new StudentWorksController();
            String part;
            Date date = studentWorksController.getServerDate(token);
            if (date.getMonth() <= 8){
                part = "1";
            }else part = "2";
            String filepath = m2MUserSettings.getPathToDirectoty() + "/" + iUser.getStudentGroup().getChair().getFaculty().getUniversity().getNameUniversity() + "/" + iUser.getStudentGroup().getChair().getFaculty().getNameFaculty() + "/" + iUser.getStudentGroup().getChair().getNameChair() + "/Course " + iUser.getStudentGroup().getCourse()+ "/Therm " + part;
            addAllFilePaces(filepath);

    }

    private void addAllFilePaces(String filepath) throws FileNotFoundException, UnsupportedEncodingException {
        StudentWorksController studentWorksController = new StudentWorksController();
        M2MStudentWork[] studentWorks = studentWorksController.getStudentWorks(iUser.getIdUser(), token);
        PrintWriter printWriter;
        String pathToSubject;
        String path;
        File file;
        for (M2MStudentWork studentWork : studentWorks) {
            pathToSubject = filepath + "/" + studentWork.getIdOfWork().getSubject().getNameSubject();
            path = pathToSubject + "/Work №" + studentWork.getIdOfWork().getNumberOfWOrk();
            file = new File(path);
            file.mkdirs();
            printWriter = new PrintWriter(path + "/" + studentWork.getIdOfWork().getNameOfWork(), "UTF-8");
            printWriter.print(studentWork.getIdOfWork().getTextOfWork());
            printWriter.close();
//            makeDataFile(pathToSubject, path);
//            uploadDataFile("s",pathToSubject);
        }
    }

    private void makeDataFile(String pathToSubject, String path) {
    }

    private void uploadDataFile(String subject, String path) {
            SupportFilesRequest supportFilesRequest = new SupportFilesRequest();
            
            try {
                supportFilesRequest.sendFile("file", token, 1);
                byte[] outputStream = supportFilesRequest.downloadFile(13,token, path);
                System.out.println(Arrays.toString(supportFilesRequest.getSubjectSupportFileByIdSubject(13, token)));

            }catch (IOException i){
                i.printStackTrace();
            }
//           

    }

    private void initializeInfoOfStudent(MyUser iUser) {
        userName.setText(iUser.getUserName());
        userSurname.setText(iUser.getUserSurname());
        userPatronymic.setText(iUser.getUserPatronymic());
        userEmail.setText(iUser.getEmail());
        userGender.setText(iUser.getGender().getNameOfGender());
        userGroup.setText(iUser.getStudentGroup().getNumberOfGroup());
        userType.setText(iUser.getUserType().getNameUserType());
    }

    private void checkForNewWorks(MyUser iUser) {
        StudentWorksController studentWorksController = new StudentWorksController();
        M2MStudentWork[] studentWorks = studentWorksController.getAllNewWork(iUser.getIdUser(), token);
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