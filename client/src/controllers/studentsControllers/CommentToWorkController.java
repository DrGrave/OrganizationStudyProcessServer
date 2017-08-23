package controllers.studentsControllers;

import com.vkkzlabs.api.entity.CommentToWork;
import com.vkkzlabs.api.entity.M2MStudentWork;
import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import requests.CommentToWorkRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CommentToWorkController {

    private final MyUser iUser;
    private final MyUserCredentials myUserCredentials;
    private final String token;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final int idOfWork;
    @FXML
    private TableView<CommentToWork> commentToWorkTable;

    @FXML
    private TableColumn<CommentToWork, String> dateOfCommentToWorkCollom;

    @FXML
    private TableColumn<CommentToWork, String> whoLeftCommentCollom;

    public void initialize(){
        initializeCommentsToWork();
    }

    private void initializeCommentsToWork() {
        CommentToWorkRequest commentToWorkRequest = new CommentToWorkRequest();
        List<CommentToWork> list = Arrays.asList(commentToWorkRequest.getCommentsToWorkByIdUserAndIdWork(iUser,idOfWork,token));
        commentToWorkTable.setItems(FXCollections.observableList(list));
        dateOfCommentToWorkCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(String.valueOf(cellDate.getValue().getDate()))
        );
        whoLeftCommentCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getProfessor().getUserSurname() +" "+ cellDate.getValue().getProfessor().getUserSurname())
        );
        commentToWorkTable.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.RIGHT) {
                CommentToWork pos = commentToWorkTable.getFocusModel().getFocusedItem();
                if (pos != null) {
                    initializeCommentToWork(pos, iUser);
                }
            }
        });
    }

    private void initializeCommentToWork(CommentToWork pos, MyUser iUser) {

        DialogPane dialogPane = new DialogPane();
        alert.setTitle("Text Of Comment");
        Label label = new Label();
        label.setText(pos.getTextOfCommentWork());
        label.setMinSize(200,50);
        dialogPane.setContent(label);
        dialogPane.setOnKeyPressed(keyEvent ->{
         if (keyEvent.getCode() == KeyCode.ESCAPE){
             alert.close();
         }else if (keyEvent.getCode() == KeyCode.ENTER){
             alert.close();
         }
        });
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        alert.setDialogPane(dialogPane);

        alert.show();
    }


    public CommentToWorkController(MyUser iUser, String token, MyUserCredentials myUserCredentials, int idOfWork) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
        this.idOfWork = idOfWork;
    }
}
