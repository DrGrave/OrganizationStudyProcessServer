package controllers;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Timetable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PaneOfEventsController {
    @FXML
    private GridPane eventGridPane;

    private Label textOfEvent = new Label();
    private Pane startPane = new Pane();
    private Pane endPane = new Pane();
    private Pane middlePane = new Pane();
    private Pane paneToText = new Pane();

    private Calendar calendar;
    private Label mondayLabel;
    private Label tuesdayLabel;
    private Label wednesdayLabel;
    private Label thursdayLabel;
    private Label fridayLabel;
    private Label saturdayLabel;
    private Label sundayLabel;
    private Label dateLabel;
    public PaneOfEventsController(Calendar calendar, Label mondayLabel, Label tuesdayLabel, Label wednesdayLabel, Label thursdayLabel, Label fridayLabel, Label saturdayLabel, Label sundayLabel, Label dateLabel) {
        this.calendar = calendar;
        this.mondayLabel = mondayLabel;
        this.tuesdayLabel = tuesdayLabel;
        this.wednesdayLabel = wednesdayLabel;
        this.thursdayLabel = thursdayLabel;
        this.fridayLabel = fridayLabel;
        this.saturdayLabel = saturdayLabel;
        this.sundayLabel = sundayLabel;
        this.dateLabel = dateLabel;

    }

    public void initialize(){

        eventGridPane.setOnContextMenuRequested(contextMenuEvent -> {
        });
        List<Integer> rowSel = new ArrayList<>();
        List<Integer> colSel = new ArrayList<>();
        rowSel.add(0);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 101; j++) {
                Pane pane = new Pane();
                int col = i;
                int row = j;

                pane.setOnMouseClicked(mouseEvent -> {
                    try {
                        createEvent(row, col, rowSel, colSel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                eventGridPane.add(pane, i, j);
            }
        }
        initializeEvents();
    }

    private void initializeEvents() {
        getTimeLine(calendar);
        getEvent();
    }

    private void createEvent(int row, int col, List<Integer> rowSel, List<Integer> colSel) throws IOException {

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
        int year = Integer.parseInt(dateLabel.getText().substring(dateLabel.getText().indexOf('.')+1)) ;
        int month = Integer.parseInt(dateLabel.getText().substring(0,2).replaceAll("[\\D]", ""));
        int day = selectDate;
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);


        rowSel.add(row);
        colSel.add(col);
        if (Objects.equals(rowSel.get(rowSel.size() - 1), rowSel.get(rowSel.size() - 2))){
            rowSel.clear();
            rowSel.add(0);
            colSel.clear();
            showCreateEventDialog(row,col, calendar);
            System.out.println(row);
            System.out.println(col);
        }
    }

    private void showCreateEventDialog(int row, int col, Calendar calendar) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = new DialogPane();
        FXMLLoader createEvent = new  FXMLLoader(getClass().getResource("../samples/CreateEvent.fxml"));
        CreateEventController createEventController = new CreateEventController(row,col, calendar);
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
        alert.setDialogPane(dialogPane);
        alert.show();
    }

    private void getEvent() {
        Timetable timetable = new Timetable();
        Date date = new Date();
        Date dateEnd = new Date();
        timetable.setDate(date);
        timetable.setAuditory("3451");
        date.setHours(22);
        dateEnd.setHours(23);
        timetable.setTimeOfEndWork(date);
        Subject subject = new Subject();
        subject.setNameSubject("POVS");
        timetable.setSubject(subject);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String textOfEntity = "Subj:"+timetable.getSubject().getNameSubject()+ " Loc:" + timetable.getAuditory() +" Start:"+ dateFormat.format(date)+" End:"+ dateFormat.format(dateEnd);
        Date dateOfStart;
        dateOfStart = timetable.getDate();
        compareWithDates(dateOfStart, dateEnd, textOfEntity);

    }

    private void compareWithDates(Date dateOfStart, Date dateofEnd,String text) {
        String[] dates = {mondayLabel.getText(), tuesdayLabel.getText(), wednesdayLabel.getText(),thursdayLabel.getText(),fridayLabel.getText(),saturdayLabel.getText(),sundayLabel.getText()};
        List<Integer> parsedDates = new ArrayList<>();
        for (String str :dates){
            parsedDates.add(Integer.parseInt(str.replaceAll("[\\D]", "")));
        }
        int month = Integer.parseInt(dateLabel.getText().substring(0,2).replaceAll("[\\D]", ""));
        if (parsedDates.contains(dateOfStart.getDate()) && dateOfStart.getMonth() == month-1){
            int column = parsedDates.indexOf(dateOfStart.getDate());
            int rowStart = dateOfStart.getHours()*4+1;
            int rowEnd = dateofEnd.getHours()*4+1;
            int minuteStart = dateOfStart.getMinutes()/15;
            int minuteEnd = (dateofEnd.getMinutes()-1)/15;
            rowEnd = rowEnd+minuteEnd;
            rowStart = rowStart+minuteStart;
            drawEvent(rowStart, rowEnd, column, text);
        }
    }

    private void drawEvent(int rowStart,int rowEnd, int column, String text) {
        startPane = new Pane();
        startPane.setOpacity(0.6F);
        startPane.setStyle("-fx-background-color: #3c763d; -fx-border-radius: 10 10 0 0; -fx-background-radius: 10 10 0 0;");
        eventGridPane.setMargin(startPane, new Insets(0,1,0,0));
        eventGridPane.add(startPane, column+1, rowStart);
        printMiddle(rowStart,rowEnd,column, text);
        endPane = new Pane();
        endPane.setOpacity(0.6F);
        endPane.setStyle("-fx-background-color: #3c763d;-fx-border-radius: 0 0 10 10; -fx-background-radius: 0 0 10 10;");
        eventGridPane.setMargin(endPane, new Insets(0,1,0,0));
        eventGridPane.add(endPane, column+1, rowEnd);
    }

    private void printMiddle(int rowStart, int rowEnd, int column, String text) {
        int col = (rowEnd-rowStart-1)/2;
        int rowToText = rowStart+col;
        for (int i = rowStart+1; i<rowEnd; i++ ){
            middlePane = new Pane();
            middlePane.setOpacity(0.6F);
            middlePane.setStyle("-fx-background-color: #3c763d");
            eventGridPane.add(middlePane, column + 1, i);
            eventGridPane.setMargin(middlePane, new Insets(0,1,0,0));
        }
        paneToText = new Pane();
        textOfEvent = new Label();
        textOfEvent.setFont(new Font(10));
        textOfEvent.setMaxWidth(75);
        textOfEvent.setWrapText(true);
        textOfEvent.setText(text);
        textOfEvent.setPadding(new Insets(0,0,0,10));
        paneToText.getChildren().add(textOfEvent);
        eventGridPane.add(paneToText, column+1,rowToText-1);
        System.out.println(col);
    }

    private void getTimeLine(Calendar calendar) {
        int i = calendar.get(Calendar.HOUR_OF_DAY);
        int timeLine = i*4+1;
        i = calendar.get(Calendar.MINUTE);
        i = i/15;
        timeLine = timeLine + i;
        Separator separator = new Separator();
        separator.setMinWidth(600);
        separator.getStylesheets().add((getClass().getResource("calendarCSS/timeLine.css")).toExternalForm());
        separator.setPadding(new Insets(0,0,8,0));
        eventGridPane.add(separator, 1, timeLine);
    }
}
