package sample;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import  javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FXMLDocumentController {

  //String date = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());


  //private static DateTimeFormatter SHORT_TIME_FORMATTER =       DateTimeFormatter.ofPattern("HH:mm:ss");


  @FXML
  private  Label label_to_show_current_time;



  @FXML
  public void  initialize() {
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.US);

    //label_to_show_current_time.textProperty().bind(bindToTime());
    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->  {
      LocalTime timenow = LocalTime.now();
      String displaytime = timenow.format(timeFormatter);
      //String timenowstring = timenow.toString();
      label_to_show_current_time.setText(displaytime);

    }),
      new KeyFrame(Duration.seconds(1))
      );

    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();


  }

}
