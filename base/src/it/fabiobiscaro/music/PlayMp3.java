package it.fabiobiscaro.music;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlayMp3 extends Application {

	public void play(String file) {
		Media hit = new Media(file);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				// Quando ha finito esce
				System.exit(0);
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// In questo esempio non serve
	}

	public static void main(String[] args) {
		// Eseguo il player e passo il file mp3
		PlayMp3 p = new PlayMp3();
		p.play(PlayMp3.class.getResource("bell.mp3").toString());
	}

}
