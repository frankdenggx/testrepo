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
 * Package : edu.frank.swing.framework.util
 * File Name : SwingUtils.java
 * File Version : 1.0.0.0
 * Description: <>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-2-28
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-2-28				<Created>
 *
 */
package edu.frank.swing.framework.util;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * <p>
 * SwingUtils comment
 * </p>
 *
 * @author Frank <FrankDengGX@gmail.com>
 *         <p>
 *         No.1 Modifier: Frank Modified Time: 2012-2-28 11:35:17 Modified
 *         Content: <Created>
 *         </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class SwingUtils {
	/**
	 * button
	 *
	 * @param button
	 */
	public static void enterPressesWhenFocused(JButton button) {
		button.registerKeyboardAction(button.getActionForKeyStroke(KeyStroke
				.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke
				.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
				JComponent.WHEN_FOCUSED);

		button.registerKeyboardAction(button.getActionForKeyStroke(KeyStroke
				.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke
				.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
				JComponent.WHEN_FOCUSED);
	}

	/**
	 * 
	 *
	 * @param textField
	 * @param actionListener
	 */
	public static void enterPressesWhenFocused(JTextField textField,
			ActionListener actionListener) {
		textField.registerKeyboardAction(actionListener,
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
				JComponent.WHEN_FOCUSED);

		textField.registerKeyboardAction(actionListener,
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
				JComponent.WHEN_FOCUSED);
	}

}
