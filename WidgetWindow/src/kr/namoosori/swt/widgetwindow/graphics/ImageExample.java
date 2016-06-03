package kr.namoosori.swt.widgetwindow.graphics;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageExample {
    public static void main(String[] args) {
    	Display display = new Display();
    	InputStream is = ImageExample.class.getResourceAsStream("sample.png");
        Image image = new Image(display, is);
        System.out.println("size:"+ image.getBounds());
    }
}
