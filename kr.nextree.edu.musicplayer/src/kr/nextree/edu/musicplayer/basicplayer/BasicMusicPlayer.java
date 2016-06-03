package kr.nextree.edu.musicplayer.basicplayer;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import kr.nextree.edu.musicplayer.basicplayer.BasicMusicPlayerListener.State;

public class BasicMusicPlayer implements BasicPlayerListener {
	//
	private static BasicMusicPlayer INSTANCE;
	
	private PrintStream out;
	
	private BasicPlayer player;
	
	private String musicFileName;
	
	private List<BasicMusicPlayerListener> listeners = new ArrayList<BasicMusicPlayerListener>();
	
	public void addBasicMusicPlayerListener(BasicMusicPlayerListener listner) {
		listeners.add(listner);
	}
	
	public void removeBasicMusicPlayerListener(BasicMusicPlayerListener listener) {
		listeners.remove(listener);
	}
	
	public static BasicMusicPlayer getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BasicMusicPlayer();
		}
		return INSTANCE;
	}
	
	private BasicMusicPlayer() {
		out = System.out;
		player = new BasicPlayer();
		player.addBasicPlayerListener(this);
	}
	
	public void play() {
		//
		if (musicFileName == null) {
			return;
		}
		
		try {
			player.open(new File(musicFileName));
			player.play();
			player.setGain(1.0);
			player.setPan(0.0);
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public void pause() {
		try {
			player.pause();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public void resume() {
		try {
			player.resume();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
	
	public void setMusicFileName(String musicFileName) {
		this.musicFileName = musicFileName;
	}
	
	public int getStatus() {
		return player.getStatus();
	}

	// -------------------------------------------------------------------------
	// BasicPlayerListener implements
	// -------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	@Override
	public void opened(Object stream, Map properties) {
		//
		display("opened : "+properties.toString());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
		//
		display("progress : "+properties.toString());
	}

	@Override
	public void setController(BasicController controller) {
		//
		display("setController : "+controller);
	}

	@Override
	public void stateUpdated(BasicPlayerEvent event) {
		//
		display("stateUpdated : "+event.toString() + ", code:"+event.getCode());
		//OPENING:-1:F:\etc\backup\Music_lib\나는가수다_mp3\나는 가수다 - 경연2\03-You Are My Lady.mp3, code:0
		//PLAYING:69869, code:2
		//GAIN:1.0, code:10
		//PAN:0.0, code:9
		//PAUSED:512237, code:4
		//RESUMED:512237, code:5
		//STOPPED:-1, code:3
		int eventCode = event.getCode();
		if (2 == eventCode || 5 == eventCode) {
			notifyStateChangedToListeners(State.PLAYING);
		} else if (4 == eventCode) {
			notifyStateChangedToListeners(State.PAUSED);
		} else if (3 == eventCode) {
			notifyStateChangedToListeners(State.STOPPED);
		}
	}
	
	private void notifyStateChangedToListeners(State state) {
		//
		for (BasicMusicPlayerListener listener : listeners) {
			listener.stateChanged(state);
		}
	}

	public void display(String msg) {
		//
		if (out != null) {
			out.println(msg);
		}
	}

}
