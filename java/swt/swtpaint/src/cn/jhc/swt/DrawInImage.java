/**
 * 
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;

/**
 * @author luyanfei
 * 本程序演示在图片上作画。
 */
public class DrawInImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = "img/java.jpg";
		String savename = "img/java_save.jpg";
		ImageLoader loader = new ImageLoader();
		ImageData[] data = loader.load(filename);
		if(data.length>0) {
			Image img = new Image(null,data[0]);
			GC gc = new GC(img);
			drawSomething(gc); //在图片上作画
			gc.dispose();
			loader.data[0] = img.getImageData();
			loader.save(savename, SWT.IMAGE_JPEG);
		}
	}
	
	private static void drawSomething(GC gc) {
		Rectangle r = gc.getClipping();
		gc.drawLine(r.x, r.y, r.x+r.width, r.y+r.height);
		gc.drawLine(r.x+r.width, r.y, r.x, r.y+r.height);
	}

}
