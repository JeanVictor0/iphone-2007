package apple.iphone.aplications;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import apple.iphone.midia.Music;

public class MusicPlayer {
	
	Map<Integer,Music> listMusics;
	Music actualMusic;
	int indexMusic;

	
	public MusicPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		listMusics = new HashMap<>();
		this.addMusic();
		indexMusic = 1;
		actualMusic = listMusics.get(indexMusic++);
	}
	
	public void addMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File folder = new File("../files/songs/");
		String url;
		int number = 0;
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				url = file.getPath();
				listMusics.put(number++,new Music(url));
			}
		}
	}
	
	public void gotoChoice(int controller)
			throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		switch (controller)
		{
			case 1:
				actualMusic.pause();
				break;
			case 2:
				actualMusic.resumeAudio();
				break;
			case 3:
				actualMusic.restart();
				break;
			case 4:
				actualMusic.stop();
				break;
			case 5:
				actualMusic.jump();
				this.nextMusic();
				break;
	
		}
	
	}
	
	public void nextMusic() {
		if (listMusics.containsKey(indexMusic)) {
			actualMusic = listMusics.get(indexMusic++);
		} else {
			indexMusic = 1;
			actualMusic = listMusics.get(indexMusic++);
		}
	}

}
