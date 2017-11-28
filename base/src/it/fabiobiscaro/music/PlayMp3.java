package it.fabiobiscaro.music;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * Il player mp3 utilizza le funzionalità di javaFX per eseguire un file mp3, 
 * estendendo la classe Application. Attenzione perchè la classe appication una 
 * volta istanziata resta sempre attiva. Se si vogliono eseguire diverse musiche quindi 
 * credo sia meglio usare sempre la stessa classe PlayMp3
 * @author fabio
 *
 */
public class PlayMp3 extends Application {

	public void play(String file) {
		// Carico il file e lo eseguo
		Media hit = new Media(file);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		
		// Aggiungo un evento che si verifica quando l'mp3 è finito
		// Non è necessario se questa classe viene usata in un altro programma
		// In questo caso è utile perché altrimenti l'Application resta attiva
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
		// Avvia l'applicazione JavaFX mostrando la prima scena
		// In questo esempio non serve, ma il metodo è obbligatorio
	}

	public static void main(String[] args) {
		// Creo il player e gli passo il file mp3 da suonare
		PlayMp3 p = new PlayMp3();
		p.play(PlayMp3.class.getResource("bell.mp3").toString());
	}

}
