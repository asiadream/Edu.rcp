package kr.namoosori.swt.widgetwindow.graphics;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class ImageComposite extends Composite {
    public ImageComposite(final Composite parent) {
        super(parent, SWT.NONE);
        InputStream is = getClass().getResourceAsStream("sample.png");
        final ImageData data = new ImageData(is);
        //final ImageData small = data.scaledTo(data.width / 3, data.height / 3);
        this.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                GC gc = e.gc;
                Image image = new Image(e.display, data);
                // �̹��� ���� ������
                //gc.drawImage(image, 5, 5);
                
                // �̹����� �Ϻθ� ���� �����Ϸ�
                //gc.drawImage(image, 200, 150, 180, 100, 5, 5, 180, 100); 
                
                // �̹��� ��ü�� ȭ�鿡 �°� ���� ������
                Rectangle imageRec = image.getBounds();
                Point parentSize = parent.getSize();
                gc.drawImage(image, 
                		0, 0, imageRec.width, imageRec.height,
                		0, 0, parentSize.x, parentSize.y);
                image.dispose();
            }
        });
    }

}
