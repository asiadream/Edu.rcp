package kr.namoosori.swt.widgetwindow.textviewer;

import java.util.StringTokenizer;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class CompletionEditorComposite extends Composite {
	private TextViewer textViewer;
	private WordTracker wordTracker;

	private static final int MAX_QUEUE_SIZE = 200;

	public CompletionEditorComposite(Composite parent) {
		super(parent, SWT.NULL);
		wordTracker = new WordTracker(MAX_QUEUE_SIZE);
		buildControls();
	}

	private void buildControls() {
		setLayout(new FillLayout());
		textViewer = new TextViewer(this, SWT.MULTI | SWT.V_SCROLL);

		textViewer.setDocument(new Document());

		final ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(
				new RecentWordContentAssistProcessor(wordTracker),
				IDocument.DEFAULT_CONTENT_TYPE);

		assistant.install(textViewer);

		textViewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.F1:
					assistant.showPossibleCompletions();
					break;
				default:
					// ignore everything else
				}
			}
		});

		textViewer.addTextListener(new ITextListener() {
			public void textChanged(TextEvent e) {
				if (isWhitespaceString(e.getText())) {
					wordTracker.add(findMostRecentWord(e.getOffset() - 1));
				}
			}
		});
	}

	protected String findMostRecentWord(int startSearchOffset) {
		int currOffset = startSearchOffset;
		char currChar;
		String word = "";
		try {
			while (currOffset > 0
					&& !Character.isWhitespace(currChar = textViewer
							.getDocument().getChar(currOffset))) {
				word = currChar + word;
				currOffset--;
			}
			return word;
		} catch (BadLocationException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected boolean isWhitespaceString(String string) {
		StringTokenizer tokenizer = new StringTokenizer(string);
		// if there is at least 1 token, this string is not whitespace
		return !tokenizer.hasMoreTokens();
	}

}