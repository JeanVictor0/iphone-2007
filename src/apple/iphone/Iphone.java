package apple.iphone;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import apple.iphone.aplications.MusicPlayer;
import apple.iphone.aplications.Sms;
import numbersPhone.NumberPhone;

public class Iphone implements InterfaceIphone {
	private String versionOsx = "1.1";
	private final String name = "Iphone 2g";
	private NumberPhone[] iNumbers = new NumberPhone[2];
	private MusicPlayer musicPlayer;
	private Sms sms;
	private NumberPhone useNumber;
	private int actualNumber;
	
	public Iphone() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this(new NumberPhone[2], 0);
	}
	
	public Iphone(NumberPhone[] iNumbers, int actualNumber) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.musicPlayer = new MusicPlayer();
		this.sms = new Sms();
		this.actualNumber = actualNumber;
		this.iNumbers = iNumbers;
		if (!(iNumbers[actualNumber] == null)) {
			useNumber = iNumbers[actualNumber];
		} else {
			System.out.println("Dont have number phone");
		}
	}
	
	public String getVersionOsx() {
		return versionOsx;
	}
	public String getName() {
		return name;
	}
	
	public NumberPhone[] getiNumbers() {
		return iNumbers;
	}
	
	public void setiNumbers(NumberPhone[] iNumbers) {
		this.iNumbers = iNumbers;
	}
	
	public void setMusicPlayer(MusicPlayer musicPlayer) {
		this.musicPlayer = musicPlayer;
	}
	
	@Override
	public void callNumber() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCall() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void offCall() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendSms(NumberPhone number) {
		sms.sendSms(number);
	}
	
	@Override
	public void viewSms() {
		
	}
	
	@Override
	public void exitChipNumber() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void putChipNumber() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void playMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		this.musicPlayer.gotoChoice(2);
		
	}

	@Override
	public void pauseMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		this.musicPlayer.gotoChoice(1);
		
	}

	@Override
	public void restartMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		this.musicPlayer.gotoChoice(3);
		
	}

	@Override
	public void jumpMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		this.musicPlayer.gotoChoice(4);
		
	}
	

}
