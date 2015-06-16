/*
 * Software License
 * The file Library is
 * Copyright (C) 2010-2011 Hotel1802 Technologies Studio All Right Reserved .
 *
 * By obtaining,using,and/or copying this software and/or its associated
 * documentation, you agree that you have read, understood, and will comply
 * with the following terms and conditions :
 *
 * Permission to use, copy, modify, and distribute this file and its associated
 * documentation for any purpose and without fee is hereby granted, provide that
 * the above copyright notice appears in all copies, and that both that copyright
 * notice and this permission ontice appear in supporting documentation, and that
 * the name of Hotel802 or the author not be used in advertising or publicity
 * pertaining to distribution of the file without specific, written prior permission .
 *
 */
/**
 * Copyright : Hotel1802 All Right Reserved.
 * JDK Version : 1.6.10
 * Project : JavaBasic
 * Package : com.frank.swing.framework
 * File Name : JApplicationMain.java
 * File Version : 1.0.0.0
 *
 *
 * Author : Frank
 * Date : 2011-05-04
 * History :
 * <Name>				<Date>				<Content>
 *
 */

package edu.frank.swing.framework;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JWindow;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 *
 * <p>
 * Application will start from this class. It'll create a flash window to show
 * the loading split bar to user about the application loading.
 * </p>
 *
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class JApplicationMain extends JWindow implements Runnable {

	/**
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -7571190991184840261L;

	private static final Logger logger = Log4JConfig.getLogger(JApplicationMain.class);

	// initial the varialbe
	private Image logo = null; // logo image object
	private Color bg_color = new Color(255, 255, 255);
	private Toolkit toolkit = getToolkit();
	private int image_width = 0;
	private int image_height = 0;

	/**
	 *
	 * construct a new <code>JApplicationMain</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public JApplicationMain() {
		this.logo = new CreatIcon().getSplashImage();
		loadImage(this.logo, 0);
		this.image_width = this.logo.getWidth(this);
		this.image_height = this.logo.getHeight(this);
		setBackground(this.bg_color);
		setCursor(new Cursor(3));
		setSize(this.image_width + 10, this.image_height + 10);
		// JWindow
		int Xpos = (this.toolkit.getScreenSize().width - getSize().width) / 2;
		int Ypos = (this.toolkit.getScreenSize().height - getSize().height) / 2;
		setBounds(Xpos, Ypos, getSize().width, getSize().height);
		setAlwaysOnTop(true);
		setVisible(true);
	}

	/*
	 * MediaTracker 
	 */
	private void loadImage(Image image, int ID) {
		if (image != null) {
			MediaTracker tracker = new MediaTracker(this);
			tracker.addImage(image, ID);
			try {
				tracker.waitForID(ID);
			} catch (InterruptedException _ex) {
				JOptionPane.showMessageDialog(this, "");
			}
		}
	}

	/*
	 * JWindow
	 */

	@Override
	public void paint(Graphics g) {
		int n;
		g.drawImage(this.logo, 5, 5, this.image_width, this.image_height, this);

		// JWindow
		g.setColor(Color.BLUE);
		g.setFont(new Font("Serif", Font.PLAIN, 26));
		g.drawString("", 70, getSize().height - 200);
		g.drawString("Java ", 100, getSize().height - 170);
		// 
		g.setFont(new Font("Serif", Font.PLAIN, 12));
		g.setColor(new Color(226, 116, 43));
		g.drawString("CopyRight (C) 2007-2008 YOYUDENG", 100,
				getSize().height - 30);
		// 
		g.setColor(new Color(226, 116, 43));
		g.drawString("......", 7, getSize().height - 100);
		// 
		g.setColor(new Color(255, 255, 255));

		// 
		g.fillRect(5, getSize().height - 98, 400, 5);
		g.drawRect(5, getSize().height - 98, 400, 5);

		// 
		g.setColor(new Color(226, 116, 43));
		for (n = 0; n < 400; n += 5) {
			try {
				// 50
				Thread.sleep(50L);
				// 
				g.fillRect(5, getSize().height - 98, n, 5);
			} catch (Exception _ex) {
			}
		}
		if (n >= 400) {
			stop();
		}
	}

	public void run() {
		// 
		setCursor(new Cursor(3));
		repaint();
	}

	public void stop() {
		// 
		this.logo = null;
		JSwingMain frm = new JSwingMain();
		frm.setVisible(true);
		logger.debug("This frame will dispose, then the Java Learning System will start ...");
		JApplicationMain.this.dispose();
	}

	// 

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	/**
	 *
	 * <code>main</code> Main method of the main class
	 *
	 * @param args
	 *			console argument
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String args[]) {
		new JApplicationMain();
	}

}

/**
 *
 * <p>
 * 	This inner class is used to create and return the background image to the invoked class
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
class CreatIcon {

	private static Image SplashImage;	// background image object

	/**
	 *
	 * construct a new <code>CreatIcon</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public CreatIcon() {
		SplashImage = getImageFromResouce("src/main/resources/edu/frank/swing/picture/backb.gif");
	}

	/**
	 *
	 * <code>getImageFromResouce</code> Use the special file path to get the picture
	 * file
	 * @param image_path
	 * 			background image file path
	 * @return
	 *			image file path
	 * @since JavaBasic 1.0.0.0
	 */
	private Image getImageFromResouce(String image_path) {
		return Toolkit.getDefaultToolkit().getImage(image_path);
	}

	/**
	 *
	 * <code>getSplashImage</code> Get the background image
	 *
	 * @return
	 *		background image
	 * @since JavaBasic 1.0.0.0
	 */
	public Image getSplashImage() {
		return SplashImage;
	}
}