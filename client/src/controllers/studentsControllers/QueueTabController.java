package controllers.studentsControllers;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.entity.Queue;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueTabController {

    @FXML
    private TableView<Queue> studentTable;

    @FXML
    private TableColumn<Queue, String> studentNameCollom;

    @FXML
    private TableColumn<Queue, String> studentSurnameCollom;

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
    private Queue[] queues;

    public QueueTabController(MyUser iUser, String token, MyUserCredentials myUserCredentials, Queue[] queues) {
        this.iUser = iUser;
        this.myUserCredentials = myUserCredentials;
        this.token = token;
        this.queues = queues;
    }

    public void initialize(){
        List<Queue> queueList = new ArrayList<>();
        for (Queue queu : queues){
            if (!ifExistsInList(queueList, queu)) {
                queueList.add(queu);
            }
        }
        ObservableList<Queue> queueObservableList = FXCollections.observableList(queueList);
        studentTable.setItems(queueObservableList);
        studentNameCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getMyUser().getUserName())
        );
        studentSurnameCollom.setCellValueFactory(
                cellDate -> new SimpleStringProperty(cellDate.getValue().getMyUser().getUserSurname())
        );
    }

    private boolean ifExistsInList(List<Queue> queues, Queue thisQueue){
        for (Queue queue : queues) {
            if (queue.getWork().getIdOfWork() == thisQueue.getWork().getIdOfWork() || queue.getMyUser().getIdUser() == thisQueue.getMyUser().getIdUser()) {
                return true;
            }
        }
        return false;
    }
}
