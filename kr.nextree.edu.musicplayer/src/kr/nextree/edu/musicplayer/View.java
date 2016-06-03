package kr.nextree.edu.musicplayer;

import kr.nextree.edu.musicplayer.basicplayer.BasicMusicPlayer;
import kr.nextree.edu.musicplayer.basicplayer.BasicMusicPlayerListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "kr.nextree.edu.musicplayer.view";
	
	private BasicMusicPlayer player = BasicMusicPlayer.getInstance();
	
	private Image pauseImage = Activator.getImageDescriptor("icons/l_icon_pause.png").createImage();
	private Image playImage = Activator.getImageDescriptor("icons/l_icon_play.png").createImage();

	public void createPartControl(Composite parent) {
		//
		final Button button = new Button(parent, SWT.PUSH);
		button.setImage(playImage);
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				//
				int status = player.getStatus();
				System.out.println("status:"+status);
				// 0:PLAYING, 1:PURSED, 2:STOPED
				if (0 == status) {
					player.pause();
				} else if (1 == status) {
					player.resume();
				} else if (2 == status) {
					player.play();
				} else if (-1 == status) {
					FileDialog dialog = new FileDialog(getSite().getShell());
					String musicFileName = dialog.open();
					player.setMusicFileName(musicFileName);
					player.play();
				}
			}
		});
		
		FileTransfer ft = FileTransfer.getInstance();
		Transfer[] trans = new Transfer[]{ft};
		DropTarget target = new DropTarget(button, DND.DROP_COPY | DND.DROP_DEFAULT);
		target.setTransfer(trans);
		target.addDropListener(new DropTargetAdapter(){
			@Override
			public void drop(DropTargetEvent event) {
				if (event.data instanceof Object[]) {
					//
					Object obj = ((Object[])event.data)[0];
					String musicFileName = (String) obj;
					player.setMusicFileName(musicFileName);
					player.play();
				}
			}

			@Override
			public void dragEnter(DropTargetEvent event) {
				//
				event.detail = DND.DROP_COPY;
			}
		});
		
		player.addBasicMusicPlayerListener(new BasicMusicPlayerListener() {
			@Override
			public void stateChanged(final State state) {
				//
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						//
						if (State.PLAYING == state) {
							//button.setText("재생중");
							button.setImage(pauseImage);
						} else if (State.PAUSED == state) {
							//button.setText("일시중지됨");
							button.setImage(playImage);
						} else if (State.STOPPED == state) {
							//button.setText("재생");
							button.setImage(playImage);
						}
					}
				});
			}
		});
	}

	public void setFocus() {
	}
}

