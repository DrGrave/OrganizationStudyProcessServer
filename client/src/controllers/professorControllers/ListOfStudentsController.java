package controllers.professorControllers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class ListOfStudentsController {
    private Label textLabel = new Label();
    private Separator separator = new Separator();
    private Insets insets = new Insets(0,0,0,5);

    @FXML
    private TableView<?> subjectTable;

    @FXML
    private TableColumn<?, ?> subjectColumn;

    @FXML
    private TableView<?> typeOfLessonTable;

    @FXML
    private TableColumn<?, ?> typeOfLessonColoumn;

    @FXML
    private TableView<?> groupTable;

    @FXML
    private TableColumn<?, ?> groupColumn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane inClassGridPane;

    @FXML
    private ScrollPane inClassScroll;

    @FXML
    private GridPane studentInClassGridPane;


    public void initialize(){
        scrollPane.setStyle("-fx-background-color: transparent;");
        inClassScroll.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                scrollPane.setHvalue(newValue.doubleValue());
            }
        });
        inClassScroll.setStyle("-fx-background-color: transparent;");
        textLabel = new Label("Text");
        textLabel.setPadding(insets);
        inClassGridPane.add(textLabel,2,0);
    }

}
