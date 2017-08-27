package controllers;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Timetable;
import javafx.event.ActionEvent;
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

public class CalendarController {

    @FXML
    private Button prevWeekButton;

    @FXML
    private Button thisDayButton;

    @FXML
    private Button nextWeekButton;

    @FXML
    private Label dateLabel;

    @FXML
    private GridPane dayGridPane;

    @FXML
    private Label mondayLabel;

    @FXML
    private Label tuesdayLabel;

    @FXML
    private Label wednesdayLabel;

    @FXML
    private Label thursdayLabel;

    @FXML
    private Label fridayLabel;

    @FXML
    private Label saturdayLabel;

    @FXML
    private Label sundayLabel;

    @FXML
    private GridPane eventGridPane;

    private Label textOfEvent = new Label();
    private Pane startPane = new Pane();
    private Pane endPane = new Pane();
    private Pane middlePane = new Pane();
    private Pane paneToText = new Pane();

    private Calendar calendar = Calendar.getInstance();
    private Calendar calendarNextWeek = Calendar.getInstance();
    @FXML
    void nextWeekAction(ActionEvent event) {
        clearEvents();
        if (calendar.get(Calendar.WEEK_OF_YEAR) == calendarNextWeek.get(Calendar.WEEK_OF_YEAR)){
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)+1);
            initializeWeeks(calendarNextWeek);
        }else {
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendarNextWeek.get(Calendar.WEEK_OF_YEAR)+1);
            initializeWeeks(calendarNextWeek);
        }

    }

    @FXML
    void prevWeekAction(ActionEvent event) {
        clearEvents();
        if (calendar.get(Calendar.WEEK_OF_YEAR) == calendarNextWeek.get(Calendar.WEEK_OF_YEAR)){
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
            initializeWeeks(calendarNextWeek);
        }else {
            calendarNextWeek.set(Calendar.WEEK_OF_YEAR, calendarNextWeek.get(Calendar.WEEK_OF_YEAR)-1);
            initializeWeeks(calendarNextWeek);
        }

    }

    private void clearEvents() {
        textOfEvent.setText(null);
        eventGridPane.getChildren().removeAll(startPane);
        eventGridPane.getChildren().removeAll(endPane);
        eventGridPane.getChildren().removeAll(middlePane);
        eventGridPane.getChildren().removeAll(middlePane);
        eventGridPane.getChildren().removeAll(middlePane);
        eventGridPane.getChildren().removeAll(middlePane);
        eventGridPane.getChildren().removeAll(paneToText);
        eventGridPane.getChildren().clear();

    }


    @FXML
    void thisDayAction(ActionEvent event) {
        clearEvents();
        calendar = Calendar.getInstance();
        calendarNextWeek = Calendar.getInstance();
        initializeWeeks(calendar);

    }

    public void initialize(){
        initializeLabelsTextSize();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        initializeWeeks(calendar);
    }

    private void initializeWeeks(Calendar calendar) {
        getDate(calendar);
        getWeek(calendar);
        getTimeLine(calendar);
        getEvent();
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Menu Item 1");
        Label label = new Label();
        item1.setOnAction(event -> label.setText("Select Menu Item 1"));
        MenuItem item2 = new MenuItem("Menu Item 2");
        item2.setOnAction(event -> label.setText("Select Menu Item 2"));
        contextMenu.getItems().addAll(item1,item2);
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
    }

    private void initializeLabelsTextSize() {
        dateLabel.setFont(new Font(20));
        mondayLabel.setFont(new Font(15));
        tuesdayLabel.setFont(new Font(15));
        wednesdayLabel.setFont(new Font(15));
        thursdayLabel.setFont(new Font(15));
        fridayLabel.setFont(new Font(15));
        saturdayLabel.setFont(new Font(15));
        sundayLabel.setFont(new Font(15));
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

    private void getDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        dateLabel.setText(String.valueOf(month+1) + "."+ String.valueOf(year));
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

    private void getWeek(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("u");
        Date date = new Date();
        Calendar thisCalendar = Calendar.getInstance();
        thisCalendar.setTime(date);
        int dateOfWeek = Integer.parseInt(dateFormat.format(date));
        if (calendar.get(Calendar.WEEK_OF_YEAR) != thisCalendar.get(Calendar.WEEK_OF_YEAR)){
            clearLabel();
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            sundayLabel.setText("  Sun " +calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setText("  Sat "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            return;
        }else if (dateOfWeek == 1){
            clearLabel();
            mondayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek ==2){
            clearLabel();
            tuesdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek == 3){
            clearLabel();
            wednesdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
        }if (dateOfWeek == 4){
            clearLabel();
            thursdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
        }if (dateOfWeek == 5){
            clearLabel();
            fridayLabel.setText("  Fri "+calendar.get(Calendar.DAY_OF_MONTH));
            fridayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3;");
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setText("  Sun "+calendar.get(Calendar.DAY_OF_MONTH));
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");

        }if (dateOfWeek == 6){
            clearLabel();
            saturdayLabel.setStyle("-fx-background-color: palevioletred; -fx-background-radius: 3 ; -fx-text-fill: #c9302c");
            saturdayLabel.setText("  Sat "+calendar.get(Calendar.DAY_OF_MONTH) );
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            sundayLabel.setStyle("-fx-text-fill: #c9302c");
            sundayLabel.setText("  Sun " +calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
        }if (dateOfWeek == 7){
            clearLabel();
            sundayLabel.setStyle("-fx-background-color: palevioletred; -fx-text-fill: #c9302c; -fx-background-radius: 3;");
            sundayLabel.setText("  Sun " +calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            saturdayLabel.setStyle("-fx-text-fill: #c9302c");
            saturdayLabel.setText("  Sat "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            fridayLabel.setText("  Fri "+ calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            thursdayLabel.setText("  Thu "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            wednesdayLabel.setText("  Wed "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            tuesdayLabel.setText("  Tue "+calendar.get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            mondayLabel.setText("  Mon "+ calendar.get(Calendar.DAY_OF_MONTH));
        }
    }

    private void clearLabel() {
        mondayLabel.setStyle(null);
        thursdayLabel.setStyle(null);
        tuesdayLabel.setStyle(null);
        wednesdayLabel.setStyle(null);
        fridayLabel.setStyle(null);
        sundayLabel.setStyle(null);
        saturdayLabel.setStyle(null);
    }

}
