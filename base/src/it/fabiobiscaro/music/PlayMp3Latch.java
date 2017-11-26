package it.fabiobiscaro.music;

import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayMp3Latch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CountDownLatch latch = new CountDownLatch(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JFXPanel(); // initializes JavaFX environment
				latch.countDown();
			}
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Media hit = new Media(PlayMp3.class.getResource("bell.mp3").toString());
			MediaPlayer mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
		}
		
		
	}

}
