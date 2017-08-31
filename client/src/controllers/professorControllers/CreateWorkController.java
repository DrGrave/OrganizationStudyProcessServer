package controllers.professorControllers;

import com.vkkzlabs.api.entity.*;
import controllers.converters.TypeOfWorkConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import requests.TypeOfWorkRequest;
import requests.WorkRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateWorkController {
    @FXML
    private AnchorPane createWorkAnchorPane;

    @FXML
    private TableView<Subject> tableSubjectProfessor;

    @FXML
    private TableColumn<Subject, String> subjectNameCollomProfessor;

    @FXML
    private TableView<Work> tableWorkProfessor;

    @FXML
    private TableColumn<Work, String> workNumberAddWork;

    @FXML
    private TableColumn<Work, String> workInfoAddWork;

    @FXML
    private Button changeWork;

    @FXML
    private Button createWork;

    @FXML
    private Button deleteWork;

    @FXML
    private TextField numberOfWorkTextField;

    @FXML
    private ChoiceBox<TypeOfWork> typeOfWorkChoiceBox;

    @FXML
    private TextField nameOfWorkTextField;

    @FXML
    private TextArea textOfWorkAddProfessor;

    @FXML
    private Button cansallWork;

    @FXML
    private Button accaptChangeWork;

    @FXML
    private Button accaptCreateWork;

    @FXML
    private Button accaptDeleteWork;
    private String token;
    private MyUser iUser;

    public CreateWorkController(MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.iUser = iUser;
        this.token = token;
    }


    public void initialize(){
        cansallWork.setVisible(false);
        accaptChangeWork.setVisible(false);
        accaptCreateWork.setVisible(false);
        accaptDeleteWork.setVisible(false);
        professorAddWorkInitialize(iUser);
    }

    @FXML
    void accaptCreateWorkAction(ActionEvent event) {
        WorkRequest worksControl = new WorkRequest();
        TypeOfWork typeOfWork;
        typeOfWork = typeOfWorkChoiceBox.getSelectionModel().getSelectedItem();
        Work work = new Work();
        work.setTextOfWork(textOfWorkAddProfessor.getText());
        Subject s = tableSubjectProfessor.selectionModelProperty().get().getSelectedItem();
        work.setSubject(s);
        work.setTypeOfWork(typeOfWork);
        work.setNumberOfWOrk(numberOfWorkTextField.getText());
        work.setProfessorId(iUser);
        work.setNameOfWork(nameOfWorkTextField.getText());
        worksControl.createWork(work, token);
        unVisibleCreateWork();
        professorAddWorkInitialize(iUser);
        tableSubjectProfessor.getSelectionModel().select(s);
    }

    @FXML
    void acceptChangeCreateWork(ActionEvent event) {
        WorkRequest getWorksControl = new WorkRequest();
        TypeOfWork typeOfWork;
        typeOfWork = typeOfWorkChoiceBox.getSelectionModel().getSelectedItem();
        Work work = tableWorkProfessor.getSelectionModel().getSelectedItem();
        work.setTextOfWork(textOfWorkAddProfessor.getText());
        Subject s = tableSubjectProfessor.selectionModelProperty().get().getSelectedItem();
        work.setSubject(s);
        work.setTypeOfWork(typeOfWork);
        work.setNumberOfWOrk(numberOfWorkTextField.getText());
        work.setProfessorId(iUser);
        work.setNameOfWork(nameOfWorkTextField.getText());
        getWorksControl.updateWork(work, token);
        tableSubjectProfessor.getSelectionModel().select(s);
        professorAddWorkInitialize(iUser);
        unVisibleChangeWork();
    }

    @FXML
    void acceptDeleteWork(ActionEvent event) {
        WorkRequest getWorksControl = new WorkRequest();
        getWorksControl.deleteWork(tableWorkProfessor.getSelectionModel().getSelectedItem(), token);
        Subject s = tableSubjectProfessor.selectionModelProperty().get().getSelectedItem();
        professorAddWorkInitialize(iUser);
        tableSubjectProfessor.getSelectionModel().select(s);
        unVisibleDeleteWork();
    }

    private void professorAddWorkInitialize(MyUser myUser) {
        WorkRequest getWorksControl = new WorkRequest();
        Subject[] subjects = getWorksControl.listOfSubjectToAddWorks(myUser.getIdUser(), token);
        List<Subject> subjectArrayList = new ArrayList<>();
        subjectArrayList.addAll(Arrays.asList(subjects));
        ObservableList<Subject> listUsers = FXCollections.observableList(subjectArrayList);
        tableSubjectProfessor.setItems(listUsers);
        subjectNameCollomProfessor.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getNameSubject())
        );
        tableSubjectProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showWorksForAddWorks(newValue, myUser)
        );
    }

    private void showWorksForAddWorks(Subject subject, MyUser myUser) {
        tableWorkProfessor.getItems().clear();
        clearFieldAddWorks();
        WorkRequest getWorksControl = new WorkRequest();
        Work[] works = null;
        if (subject != null) {
            works = getWorksControl.listAllWorksSubjectProfessor(myUser.getIdUser(), subject.getIdSubject(), token);
            if (works != null) {
                List<Work> workList = new ArrayList<>();
                workList.addAll(Arrays.asList(works));
                ObservableList<Work> workObservableList = FXCollections.observableList(workList);
                tableWorkProfessor.setItems(workObservableList);
                workNumberAddWork.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getNumberOfWOrk())
                );

                workInfoAddWork.setCellValueFactory(
                        cellData -> new SimpleStringProperty(cellData.getValue().getNameOfWork())
                );
                tableWorkProfessor.getSelectionModel().selectedItemProperty().addListener(
                        (observable, oldValue, newValue) -> initializeInfoOfWorks(newValue)
                );
            }
        }
    }

    private void clearFieldAddWorks() {

    }

    private void initializeInfoOfWorks(Work work) {
        TypeOfWorkConverter typeOfWorkConverter = new TypeOfWorkConverter();
        if (work != null) {
            numberOfWorkTextField.setText(work.getNumberOfWOrk());
            unVisibleChangeWork();
            nameOfWorkTextField.setText(work.getNameOfWork());
            textOfWorkAddProfessor.setText(work.getTextOfWork());
            ObservableList<TypeOfWork> typeOfWorks = FXCollections.observableArrayList();
            typeOfWorks.add(work.getTypeOfWork());
            typeOfWorkChoiceBox.setItems(typeOfWorks);
            typeOfWorkChoiceBox.setConverter(typeOfWorkConverter);
            typeOfWorkChoiceBox.getSelectionModel().select(0);
        }
    }

    @FXML
    void canselCDCwork(ActionEvent event) {
        unVisibleCreateWork();
        unVisibleDeleteWork();
        unVisibleChangeWork();
    }

    @FXML
    void changeCreateWork(ActionEvent event) {
        visibleChangeWork();
    }

    @FXML
    void deleteWorkAction(ActionEvent event) {
        visibleDeleteWork();
    }



    @FXML
    void createWorkAction(ActionEvent event) {
        TypeOfWorkRequest getTypeOfWorkControl = new TypeOfWorkRequest();
        TypeOfWorkConverter typeOfWorkConverter = new TypeOfWorkConverter();
        TypeOfWork[] typeOfWorks = getTypeOfWorkControl.listAllTypesOfWork(token);
        List<TypeOfWork> typeOfWorkArrayList = new ArrayList<>();
        typeOfWorkArrayList.addAll(Arrays.asList(typeOfWorks));
        ObservableList<TypeOfWork> listOfTypeOfWorks = FXCollections.observableList(typeOfWorkArrayList);
        visibleCreateWork();
        typeOfWorkChoiceBox.setItems(listOfTypeOfWorks);
        typeOfWorkChoiceBox.setConverter(typeOfWorkConverter);
        typeOfWorkChoiceBox.getSelectionModel().select(0);
    }



    private void visibleCreateWork(){
        numberOfWorkTextField.editableProperty().setValue(true);
        typeOfWorkChoiceBox.disableProperty().setValue(false);
        nameOfWorkTextField.editableProperty().setValue(true);
        textOfWorkAddProfessor.editableProperty().setValue(true);
        cansallWork.setVisible(true);
        accaptCreateWork.setVisible(true);
        changeWork.setVisible(false);
        deleteWork.setVisible(false);
        createWork.setVisible(false);
        tableWorkProfessor.setVisible(false);
        nameOfWorkTextField.clear();
        numberOfWorkTextField.clear();
        textOfWorkAddProfessor.clear();
    }
    private void unVisibleCreateWork(){
        numberOfWorkTextField.editableProperty().setValue(false);
        typeOfWorkChoiceBox.disableProperty().setValue(true);
        nameOfWorkTextField.editableProperty().setValue(false);
        textOfWorkAddProfessor.editableProperty().setValue(false);
        tableWorkProfessor.setVisible(true);
        changeWork.setVisible(true);
        deleteWork.setVisible(true);
        createWork.setVisible(true);
        cansallWork.setVisible(false);
        accaptCreateWork.setVisible(false);
    }
    private void visibleDeleteWork(){
        cansallWork.setVisible(true);
        accaptDeleteWork.setVisible(true);
        changeWork.setVisible(false);
        deleteWork.setVisible(false);
        createWork.setVisible(false);
    }
    private void unVisibleDeleteWork(){
        numberOfWorkTextField.editableProperty().setValue(false);
        typeOfWorkChoiceBox.disableProperty().setValue(true);
        nameOfWorkTextField.editableProperty().setValue(false);
        textOfWorkAddProfessor.editableProperty().setValue(false);
        tableWorkProfessor.setVisible(true);
        accaptDeleteWork.setVisible(false);
        changeWork.setVisible(true);
        deleteWork.setVisible(true);
        createWork.setVisible(true);
        cansallWork.setVisible(false);
    }
    private void visibleChangeWork(){
        numberOfWorkTextField.editableProperty().setValue(true);
        typeOfWorkChoiceBox.disableProperty().setValue(false);
        nameOfWorkTextField.editableProperty().setValue(true);
        textOfWorkAddProfessor.editableProperty().setValue(true);
        cansallWork.setVisible(true);
        accaptChangeWork.setVisible(true);
        changeWork.setVisible(false);
        deleteWork.setVisible(false);
        createWork.setVisible(false);
    }
    private void unVisibleChangeWork(){
        numberOfWorkTextField.editableProperty().setValue(false);
        typeOfWorkChoiceBox.disableProperty().setValue(true);
        nameOfWorkTextField.editableProperty().setValue(false);
        textOfWorkAddProfessor.editableProperty().setValue(false);
        tableWorkProfessor.setVisible(true);
        accaptDeleteWork.setVisible(false);
        accaptChangeWork.setVisible(false);
        changeWork.setVisible(true);
        deleteWork.setVisible(true);
        createWork.setVisible(true);
        cansallWork.setVisible(false);
    }



}
