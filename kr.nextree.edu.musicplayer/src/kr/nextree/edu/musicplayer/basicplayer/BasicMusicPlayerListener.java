package kr.nextree.edu.musicplayer.basicplayer;

public interface BasicMusicPlayerListener {
	enum State {
		PLAYING, PAUSED, STOPPED
	};

	public void stateChanged(State state);
}
