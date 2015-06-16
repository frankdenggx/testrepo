package edu.frank.headfirst.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {

	ImageIcon imageIcon;
	URL imageUrl;
	boolean retriving = false;
	Thread retrivalThread;
	public ImageProxy(URL url) {
		this.imageUrl = url;
	}
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if (imageIcon != null) {
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Loading CD Cover, please wait...", x+30, y+190);
			if (!retriving) {
				retriving = true;
				retrivalThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							//Thread.sleep(2000);
							imageIcon = new ImageIcon(imageUrl, "CD Cover");
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrivalThread.start();
			}
		}
		
	}

	@Override
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} 
		return 800;
	}

	@Override
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		}
		return 600;
	}

}
