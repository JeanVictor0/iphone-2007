package apple.iphone.midia;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private AudioInputStream audioInputStream;
	private Clip clip;
	private String filePath;
	private Long currentFrame;
	String status;
	
	public Music(String name ) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		this.filePath = name;
		this.audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
		this.setClip(AudioSystem.getClip());
		getClip().open(audioInputStream);
		getClip().loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void resetAudioStream() throws UnsupportedAudioFileException, IOException,LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(
		new File(filePath).getAbsoluteFile());
		getClip().open(audioInputStream);
		getClip().loop(Clip.LOOP_CONTINUOUSLY);
		}
	
	public void play()
	{
		getClip().start();
		
		status = "play";
	}
	
	// Method to pause the audio
	public void pause()
	{
		if (status.equals("paused"))
		{
			System.out.println("audio is already paused");
			return;
		}
		this.currentFrame = getClip().getMicrosecondPosition(); 
		getClip().stop();
		status = "paused";
	}
	
	// Method to resume the audio
	public void resumeAudio() throws UnsupportedAudioFileException,
								IOException, LineUnavailableException
	{
		if (status.equals("play"))
		{
			System.out.println("Audio is already "+
			"being played");
			return;
		}
		getClip().close();
		resetAudioStream();
		getClip().setMicrosecondPosition(currentFrame);
		this.play();
	}
	
	// Method to restart the audio
	public void restart() throws IOException, LineUnavailableException,
											UnsupportedAudioFileException
	{
		getClip().stop();
		getClip().close();
		resetAudioStream();
		this.currentFrame = 0L;
		getClip().setMicrosecondPosition(0);
		this.play();
	}
	
	// Method to stop the audio
	public void stop() throws UnsupportedAudioFileException,
	IOException, LineUnavailableException
	{
		this.currentFrame = 0L;
		getClip().stop();
		getClip().close();
	}
	
	// Method to jump over a specific part
	public void jump() throws UnsupportedAudioFileException, IOException,LineUnavailableException{
	
		getClip().stop();
		getClip().close();
		resetAudioStream();

	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}
	
}
