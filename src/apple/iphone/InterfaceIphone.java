package apple.iphone;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import apple.iphone.midia.Music;
import numbersPhone.NumberPhone;

public interface InterfaceIphone {
	public void exitChipNumber();
	
	public void putChipNumber();
	
	public void callNumber();
	
	public void onCall();
	
	public void offCall();
	
	public void sendSms(NumberPhone number);
	
	public void viewSms();

	public void playMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
	
	public void pauseMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
	
	public void restartMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
	
	public void jumpMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException;
}
