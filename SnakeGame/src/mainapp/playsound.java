package mainapp;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class playsound {
	public void playmusic(){

		try {
			Clip bgm = AudioSystem.getClip();
			URL music = playsound.class.getClassLoader().getResource("Statics/music1.wav");
			AudioInputStream am = AudioSystem.getAudioInputStream(music);
			bgm.open(am);
			bgm.start();
			bgm.loop(Clip.LOOP_CONTINUOUSLY);
			
			while(true) {}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
