package com.example.controllers;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import com.example.models.Pomodoro;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainController implements Initializable {
    @FXML
    private VBox vBoxRoot;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblTimer;
    @FXML
    private Button btnTimer;

    @FXML
    private void togglePause() {
        if (Pomodoro.isTimerPaused) {
            Pomodoro.isTimerPaused = false;
            btnTimer.setText("Pause");
            timerTick.play();
        } else {
            Pomodoro.isTimerPaused = true;
            btnTimer.setText("Resume");
            timerTick.pause();
        }
    }

    @FXML
    private void toggleTimerStatus() {
        Pomodoro.isTimerPaused = true;
        Pomodoro.isFocused = !Pomodoro.isFocused;

        if (Pomodoro.isFocused) {
            Pomodoro.timerDuration = Duration.ofMinutes(25L);
            lblStatus.setText("Pomodoro");
            vBoxRoot.getStyleClass().remove("mainBgBreak");
            btnTimer.getStyleClass().remove("btnTimerBreak");
        } else {
            Pomodoro.timerDuration = Duration.ofMinutes(5L);
            lblStatus.setText("Short break");
            vBoxRoot.getStyleClass().add("mainBgBreak");
            btnTimer.getStyleClass().add("btnTimerBreak");
        }

        btnTimer.setText("Start");
        updateTimerText();
    }

    private Timeline timerTick = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1.0), e -> {
        if (Pomodoro.timerDuration.getSeconds() > 0L && !Pomodoro.isTimerPaused) {
            Pomodoro.timerDuration = Pomodoro.timerDuration.minusSeconds(1L);
            updateTimerText();

            if (Pomodoro.timerDuration.getSeconds() == 0L) {
                Media media = new Media(getClass().getResource("/audio/alarm.mp3").toExternalForm());
                MediaPlayer mp3Player = new MediaPlayer(media);
                mp3Player.play();
                toggleTimerStatus();
            }
        }
    }));

    private void updateTimerText() {
        lblTimer.setText(
                String.format("%02d:%02d", Pomodoro.timerDuration.toMinutes(), Pomodoro.timerDuration.toSecondsPart()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pomodoro.timerDuration = Duration.ofMinutes(25L);
        timerTick.setCycleCount(Timeline.INDEFINITE);
        updateTimerText();
    }
}
