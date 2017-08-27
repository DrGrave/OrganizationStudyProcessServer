package controllers;

import com.vkkzlabs.api.entity.Subject;
import com.vkkzlabs.api.entity.Timetable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;

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

    @FXML
    void nextWeekAction(ActionEvent event) {

    }

    @FXML
    void prevWeekAction(ActionEvent event) {

    }

    @FXML
    void thisDayAction(ActionEvent event) {

    }

    public void initialize(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        getDate(calendar);
        getWeek(calendar);
        getTimeLine(calendar);
        getEvent();
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Menu Item 1");
        Label label = new Label();
        item1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                label.setText("Select Menu Item 1");
            }
        });
        MenuItem item2 = new MenuItem("Menu Item 2");
        item2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                label.setText("Select Menu Item 2");
            }
        });
        contextMenu.getItems().addAll(item1,item2);
        eventGridPane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent contextMenuEvent) {

            }
        });
        List<Integer> rowSel = new ArrayList<>();
        List<Integer> colSel = new ArrayList<>();
        rowSel.add(0);
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 101; j++) {
                Pane pane = new Pane();
                int col = i;
                int row = j;

                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            createEvent(row, col, rowSel, colSel);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                eventGridPane.add(pane, i, j);
            }
        }
    }

    private void createEvent(int row, int col, List<Integer> rowSel, List<Integer> colSel) throws IOException {

        Date date = new Date();
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
            showCreateEventDialog(row,col, date);
            System.out.println(row);
            System.out.println(col);
        }
    }

    private void showCreateEventDialog(int row, int col, Date date) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = new DialogPane();
        FXMLLoader createEvent = new  FXMLLoader(getClass().getResource("../samples/CreateEvent.fxml"));
        CreateEventController createEventController = new CreateEventController(row,col);
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
        if (parsedDates.contains(dateOfStart.getDate())){
            int column = parsedDates.indexOf(dateOfStart.getDate());
            int rowStart = dateOfStart.getHours()*4+1;
            int rowEnd = dateofEnd.getHours()*4+1;
            int minuteStart = dateOfStart.getMinutes()/15;
            int minuteEnd = (dateofEnd.getMinutes()-1)/15;
            rowEnd = rowEnd+minuteEnd;
            rowStart = rowStart+minuteStart;
            drawEvent(rowStart, rowEnd, column, text);
        }
        System.out.println(parsedDates.get(1));
    }

    private void drawEvent(int rowStart,int rowEnd, int column, String text) {
        Pane startPane = new Pane();
        startPane.setOpacity(0.6F);
        startPane.setStyle("-fx-background-color: #3c763d; -fx-border-radius: 10 10 0 0; -fx-background-radius: 10 10 0 0;");
        eventGridPane.setMargin(startPane, new Insets(0,1,0,0));
        eventGridPane.add(startPane, column+1, rowStart);
        printMiddle(rowStart,rowEnd,column, text);
        Pane endPane = new Pane();
        endPane.setOpacity(0.6F);
        endPane.setStyle("-fx-background-color: #3c763d;-fx-border-radius: 0 0 10 10; -fx-background-radius: 0 0 10 10;");
        eventGridPane.setMargin(endPane, new Insets(0,1,0,0));
        eventGridPane.add(endPane, column+1, rowEnd);
    }

    private void printMiddle(int rowStart, int rowEnd, int column, String text) {
        int col = (rowEnd-rowStart-1)/2;
        int rowToText = rowStart+col;
        for (int i = rowStart+1; i<rowEnd; i++ ){
            if (i == rowToText){
                Pane paneToText = new Pane();
                Pane pane = new Pane();
                Label label = new Label();
                label.setMaxWidth(75);
                label.setWrapText(true);
                label.setText(text);
                paneToText.getChildren().add(label);
                pane.setOpacity(0.6F);
                pane.setStyle("-fx-background-color: #3c763d");
                eventGridPane.add(pane, column+1,i);
                eventGridPane.setMargin(pane, new Insets(0,1,0,0));
                eventGridPane.add(paneToText, column+1,i-1);
            }else {
                Pane middlePane = new Pane();
                middlePane.setOpacity(0.6F);
                middlePane.setStyle("-fx-background-color: #3c763d");
                eventGridPane.add(middlePane, column + 1, i);
                eventGridPane.setMargin(middlePane, new Insets(0,1,0,0));
            }
        }
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
        int dateOfWeek = Integer.parseInt(dateFormat.format(date));
        if (dateOfWeek == 1){
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

}
