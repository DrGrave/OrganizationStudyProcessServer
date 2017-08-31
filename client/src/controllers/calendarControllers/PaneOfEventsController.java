package controllers.calendarControllers;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.entity.Timetable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import requests.EventsRequest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PaneOfEventsController {
    @FXML
    private GridPane eventGridPane;

    @FXML
    private ScrollPane scrollPane;

    private Label textOfEvent = new Label();
    private Pane startPane = new Pane();
    private Pane endPane = new Pane();
    private Pane middlePane = new Pane();
    private Pane paneToText = new Pane();
    public static List<Timetable> listOfEvents = new ArrayList<>();

    public static ObservableList<Timetable> timetableObservableList = FXCollections.observableList(listOfEvents);
    public static Timetable nowTimetable = new Timetable();


    private Calendar calendar;
    private Label mondayLabel;
    private Label tuesdayLabel;
    private Label wednesdayLabel;
    private Label thursdayLabel;
    private Label fridayLabel;
    private Label saturdayLabel;
    private Label sundayLabel;
    private Label dateLabel;
    private double scrollPanePos;
    private MyUser iUser;
    private String token;
    private MyUserCredentials myUserCredentials;
    private Separator separator = new Separator();

    public PaneOfEventsController(Calendar calendar, Label mondayLabel, Label tuesdayLabel, Label wednesdayLabel, Label thursdayLabel, Label fridayLabel, Label saturdayLabel, Label sundayLabel, Label dateLabel, double scrollPanePos, MyUser iUser, String token, MyUserCredentials myUserCredentials) {
        this.calendar = calendar;
        this.mondayLabel = mondayLabel;
        this.tuesdayLabel = tuesdayLabel;
        this.wednesdayLabel = wednesdayLabel;
        this.thursdayLabel = thursdayLabel;
        this.fridayLabel = fridayLabel;
        this.saturdayLabel = saturdayLabel;
        this.sundayLabel = sundayLabel;
        this.dateLabel = dateLabel;
        this.scrollPanePos = scrollPanePos;
        this.iUser = iUser;
        this.token = token;
        this.myUserCredentials = myUserCredentials;
    }

    public void initialize(){
        scrollPane.setVvalue(scrollPanePos);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Create event");
        int[] contRowCol;
        contRowCol = new int[]{0, 0};
        item1.setOnAction(event -> {
            try {
                createEvent(contRowCol[1],contRowCol[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(item1);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 101; j++) {
                Pane pane = new Pane();
                int col = i;
                int row = j;

                pane.setOnContextMenuRequested(contextMenuEvent -> {
                    contextMenu.show(eventGridPane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
                    contRowCol[0] = col;
                    contRowCol[1] = row;
                });

                pane.setOnMouseClicked(mouseEvent -> {
                    try {
                        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                            if(mouseEvent.getClickCount() == 2){
                                createEvent(row, col);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                eventGridPane.add(pane, i, j);
            }
        }

        getTimeLine(calendar);
        Platform.runLater(this::initializeEvents);
    }




    private void initializeEvents() {
        getAllTimetables();
        if (listOfEvents != null) {
            for (Timetable timetable : listOfEvents) {
                getEvent(timetable);
            }
        }
    }

    private void getAllTimetables() {
        EventsRequest eventsRequest = new EventsRequest();
        listOfEvents = Arrays.asList(eventsRequest.getAllEvents(iUser.getIdUser(), token));

    }

    public void drawNewEvent(Timetable timetable){
        Platform.runLater(() -> {
                getEvent(timetable);

        });
    }


    private void createEvent(int row, int col) throws IOException {

        String[] dates = {mondayLabel.getText(), tuesdayLabel.getText(), wednesdayLabel.getText(),thursdayLabel.getText(),fridayLabel.getText(),saturdayLabel.getText(),sundayLabel.getText()};
        List<Integer> parsedDates = new ArrayList<>();
        for (String str :dates){
            parsedDates.add(Integer.parseInt(str.replaceAll("[\\D]", "")));
        }
        int selectDate = 0;
        for (int i = 1; i<8; i++){
            if (col == i){
                selectDate = parsedDates.get(i-1);
            }
        }
        int monthToEveryDate[] = new int[7];

        int month = Integer.parseInt(dateLabel.getText().substring(0,2).replaceAll("[\\D]", ""));
        monthToEveryDate[0] = month;
        for (int i = 1; i < 7; i ++){
            if (parsedDates.get(i) == 1){
                for (int j = i; j < 7; j++){
                    monthToEveryDate[j] = month+1;
                }
                break;
            }else monthToEveryDate[i] = month;
        }
        int year = Integer.parseInt(dateLabel.getText().substring(dateLabel.getText().indexOf('.')+1)) ;

        int day = selectDate;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH, monthToEveryDate[parsedDates.indexOf(day)]-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        showCreateEventDialog(row,col, calendar);


    }

    private void showCreateEventDialog(int row, int col, Calendar calendar) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = new DialogPane();
        Timetable timetable = new Timetable();
        FXMLLoader createEvent = new  FXMLLoader(getClass().getResource("../../samples/calendarFXML/CreateEvent.fxml"));
        CreateEventController createEventController = new CreateEventController(row,col, calendar, timetable, alert, iUser,token,myUserCredentials);
        createEvent.setController(createEventController);
        dialogPane.getChildren().add(createEvent.load());
        dialogPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE){
                alert.close();
            }
        });
        dialogPane.setMinHeight(300);
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Create event");
        alert.setTitle("Create event");
        alert.setDialogPane(dialogPane);
        alert.show();
    }

    private void getEvent(Timetable timetable) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        if (timetable != null) {
            String textOfEntity = "Subj:" + timetable.getSubject().getNameSubject() + " Loc:" + timetable.getAuditory() + " Start:" + dateFormat.format(timetable.getDate()) + " End:" + dateFormat.format(timetable.getTimeOfEndWork());
            compareWithDates(timetable.getDate(), timetable.getTimeOfEndWork(), textOfEntity, timetable);
        }
    }

    private void compareWithDates(Date dateOfStart, Date dateOfEnd,String text, Timetable timetable) {
        String[] dates = {mondayLabel.getText(), tuesdayLabel.getText(), wednesdayLabel.getText(),thursdayLabel.getText(),fridayLabel.getText(),saturdayLabel.getText(),sundayLabel.getText()};
        List<Integer> parsedDates = new ArrayList<>();
        for (String str :dates){
            parsedDates.add(Integer.parseInt(str.replaceAll("[\\D]", "")));
        }
        int month = Integer.parseInt(dateLabel.getText().substring(0,2).replaceAll("[\\D]", ""));
        int[] monthToEveryDate = new int[7];
        monthToEveryDate[0] = month;
        for (int i = 1; i < 7; i ++){
            if (parsedDates.get(i) == 1){
                for (int j = i; j < 7; j++){
                    monthToEveryDate[j] = month+1;
                }
                break;
            }else monthToEveryDate[i] = month;
        }
        int monthOfEvent = dateOfStart.getMonth()+1;
        if (parsedDates.contains(dateOfStart.getDate()) && monthToEveryDate[parsedDates.indexOf(dateOfStart.getDate())] == monthOfEvent){
            int column = parsedDates.indexOf(dateOfStart.getDate());
            int rowStart = dateOfStart.getHours()*4+1;
            int rowEnd = dateOfEnd.getHours()*4+1;
            int minuteStart = dateOfStart.getMinutes()/15;
            int minuteEnd = (dateOfEnd.getMinutes()-1)/15;
            rowEnd = rowEnd+minuteEnd;
            rowStart = rowStart+minuteStart;
            drawEvent(rowStart, rowEnd, column, text, timetable);
        }
    }

    private void drawEvent(int rowStart,int rowEnd, int column, String text, Timetable timetable) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Create event");
        final Timetable[] thisTimetable = {new Timetable()};
        item1.setOnAction(event -> {
            try {
                createSecEvent(thisTimetable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        MenuItem item2 = new MenuItem("Edit event");
        item2.setOnAction(event -> {
            try {
                editEvent(thisTimetable[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        contextMenu.getItems().addAll(item1,item2);
        startPane = new Pane();

        startPane.setOnContextMenuRequested(contextMenuEvent -> {
            thisTimetable[0] = timetable;
            contextMenu.show(eventGridPane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());

        });

        startPane.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    try {
                        editEvent(timetable);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        startPane.setOpacity(0.6F);
        startPane.setStyle("-fx-background-color: #3c763d; -fx-border-radius: 10 10 0 0; -fx-background-radius: 10 10 0 0;");
        eventGridPane.setMargin(startPane, new Insets(0,1,0,0));
        eventGridPane.add(startPane, column+1, rowStart);
        printMiddle(rowStart,rowEnd,column, text, timetable, contextMenu, thisTimetable);
        endPane = new Pane();
        endPane.setOpacity(0.6F);

        endPane.setOnContextMenuRequested(contextMenuEvent -> {
            thisTimetable[0] = timetable;
            contextMenu.show(eventGridPane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());

        });

        endPane.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    try {
                        editEvent(timetable);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        endPane.setStyle("-fx-background-color: #3c763d;-fx-border-radius: 0 0 10 10; -fx-background-radius: 0 0 10 10;");
        eventGridPane.setMargin(endPane, new Insets(0,1,0,0));
        eventGridPane.add(endPane, column+1, rowEnd);
    }

    private void createSecEvent(Timetable[] thisTimetable) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = new DialogPane();
        FXMLLoader createEvent = new  FXMLLoader(getClass().getResource("../../samples/calendarFXML/CreateEvent.fxml"));
        CreateEventController createEventController = new CreateEventController(0,0, calendar, thisTimetable[0], alert, iUser,token,myUserCredentials);
        createEvent.setController(createEventController);
        dialogPane.getChildren().add(createEvent.load());
        dialogPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE){
                alert.close();
            }
        });
        dialogPane.setMinHeight(300);
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Create event");
        alert.setTitle("Create event");
        alert.setDialogPane(dialogPane);
        alert.show();
    }

    private void editEvent(Timetable timetable) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = new DialogPane();
        FXMLLoader createEvent = new  FXMLLoader(getClass().getResource("../../samples/calendarFXML/CreateEvent.fxml"));
        CreateEventController createEventController = new CreateEventController(0,0, calendar, timetable,alert, iUser, token, myUserCredentials);
        createEvent.setController(createEventController);
        dialogPane.getChildren().add(createEvent.load());
        dialogPane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE){
                alert.close();
            }
        });
        dialogPane.setMinHeight(300);
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        alert.setHeaderText("Edit event");
        alert.setTitle("Edit event");
        alert.setDialogPane(dialogPane);
        alert.show();
    }

    private void printMiddle(int rowStart, int rowEnd, int column, String text, Timetable timetable, ContextMenu contextMenu, Timetable[] thisTimetable) {
        int col = (rowEnd-rowStart-1)/2;
        int rowToText = rowStart+col;
        for (int i = rowStart+1; i<rowEnd; i++ ){
            middlePane = new Pane();

            middlePane.setOnMouseClicked(mouseEvent -> {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        try {
                            editEvent(timetable);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            middlePane.setOnContextMenuRequested(contextMenuEvent -> {
                thisTimetable[0] = timetable;
                contextMenu.show(eventGridPane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());

            });

            middlePane.setOpacity(0.6F);
            middlePane.setStyle("-fx-background-color: #3c763d");
            eventGridPane.add(middlePane, column + 1, i);
            eventGridPane.setMargin(middlePane, new Insets(0,1,0,0));
        }
        paneToText = new Pane();
        paneToText.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2){
                    try {
                        editEvent(timetable);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        paneToText.setOnContextMenuRequested(contextMenuEvent -> {
            thisTimetable[0] = timetable;
            contextMenu.show(eventGridPane, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());

        });

        textOfEvent = new Label();
        textOfEvent.setFont(new Font(10));
        textOfEvent.setMaxWidth(75);
        textOfEvent.setWrapText(true);
        textOfEvent.setText(text);
        textOfEvent.setPadding(new Insets(0,0,0,10));
        paneToText.getChildren().add(textOfEvent);
        eventGridPane.add(paneToText, column+1,rowToText-1);

    }

    public void getTimeLine(Calendar calendar) {
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        int timeLine = i*4+1;
        i = calendar.get(Calendar.MINUTE);
        i = i/15;
        timeLine = timeLine + i;
        separator.setMinWidth(600);
        separator.getStylesheets().add((getClass().getResource("../calendarCSS/timeLine.css")).toExternalForm());
        separator.setPadding(new Insets(0,0,8,0));
        eventGridPane.getChildren().remove(separator);
        eventGridPane.add(separator, 1, timeLine);
        setNowTimetable(calendar);
    }

    private void setNowTimetable(Calendar calendar){
        int monthOfCalendar = calendar.get(Calendar.MONTH)+1;
        int dayOfCalendar = calendar.get(Calendar.DAY_OF_MONTH);
        int[] timeOfCalendar = {calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE)};
        for (Timetable timetable : listOfEvents){
            int monthOfTimetable = timetable.getDate().getMonth();
            int dayOfTimetable = timetable.getDate().getDate();
            int[] timeOfStartEnd = {timetable.getDate().getHours(), timetable.getDate().getMinutes(), timetable.getTimeOfEndWork().getHours(), timetable.getTimeOfEndWork().getMinutes()};
            if (monthOfCalendar == monthOfTimetable && dayOfCalendar == dayOfTimetable && timeOfStartEnd[0] <= timeOfCalendar[0] && timeOfStartEnd[1] <= timeOfCalendar[1] && timeOfStartEnd[2] >= timeOfCalendar[0] && timeOfStartEnd[3] >= timeOfCalendar[1]){
                nowTimetable = timetable;
            }
        }
    }

    public double getScrollValue() {
        return scrollPane.getVvalue();
    }
}
