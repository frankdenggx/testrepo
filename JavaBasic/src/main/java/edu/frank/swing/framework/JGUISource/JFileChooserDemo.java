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
 * Copyright :  Hotel1802 All Right Reserved.
 * JDK Version :  1.6.10
 * Project :  JavaBasic
 * Package : edu.frank.swing.framework.JGUISource
 * File Name : JFileChooserDemo.java
 * File Version : 1.0.0.0
 * File Spec:
 * 		Creates a <code>javax.swing.JFileChooser</code> component to load one or more excel files, then analyse those files and
 * put the information into the existed table.
 *
 * Author : Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * Date : 2011-06-13 23:14:10
 * History :
 * <Name>				<Date>								<Comments>
 * Frank					2011-06-13 23:14:10			Created
 */

package edu.frank.swing.framework.JGUISource;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;
import edu.frank.office.excel.ExcelUtils;

/**
 *
 * <p>
 * 	
 * </p>
 *
 * @author Frank <a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a><p>
 *
 * 	<p>
 * <p>
 * <p>
 *
 * @Version JavaBasic 1.0.0.0
 */
class JFileChooserDemo extends JFrame {

	/**
	 * Class serialized id
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 9154285482810842904L;

	/**
	 * Program logger object
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final Logger logger = Log4JConfig
			.getLogger(JFileChooserDemo.class);

	/**
	 * Menu tool bar
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JMenuBar menuBar;

	/**
	 * Menu
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JMenu menuFile;

	private String[] menuNames = {
			"fileMenu"
	};

	private String[] menuTexts = {
			"File()"
	};

	/**
	 * Menu items
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JMenuItem menuItemImport, menuItemExport, menuItemExit;

	private String[][] menuItemNames = {
		{"ImportMenuItem", "ExportMenuItem", "ExitMenuItem"}
	};

	private String[][] menuItemTexts = {
			{"Import()", "Export()", "Exit()"}
		};

	private JSeparator separatorMenuBarAndToolBar, separatorToolBarAndMainPanel;

	/**
	 * 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JToolBar toolBar;

	/**
	 * 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JButton[] toolBarButtons;

	private String[] toolbarButtonNames = {"importButton", "exportButton"};

	private static String[] Icons = {
		"src/main/resources/edu/frank/swing/picture/common/open.png",
		"src/main/resources/edu/frank/swing/picture/common/save.png",
		"src/main/resources/edu/frank/swing/picture/common/exit.png"
	};

	private static String[] IconDescs = {
		"Excel",
		"Excel",
		""
	};

	/**
	 * Component container
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Container container;

	/**
	 * Frame main panel
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JPanel mainPanel;

	/**
	 * File chooser
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JFileChooser fileChooser;

	/**
	 * Message label
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JLabel labMsg;

	/**
	 * file names content
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JTextField jTextFiled;

	/**
	 * Search file button, when press it, will open the file chooser dialog.
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private JButton searchButton;

	/**
	 * Frame's width and height
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int height, width;

	/**
	 * Frame tookit
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Toolkit toolkit = getToolkit();

	/**
	 * construct a new <code>JFileChooserDemo</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public JFileChooserDemo() {
		initComponents();
	}

	/**
	 * <code>initComponents</code> initialized components
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void initComponents() {
		setTitle("Excel"); // Frame title
		setSize(700, 450); // Frame size

		// Force the frame on the middle of the screen
		this.width = getWidth();
		this.height = getHeight();
		int x = (this.toolkit.getScreenSize().width - this.width) / 2;
		int y = (this.toolkit.getScreenSize().height - this.height) / 2;
		this.setBounds(x, y, this.width, this.height);

		this.container = getContentPane(); // Get componet container
		this.container.setLayout(new BoxLayout(this.container, BoxLayout.Y_AXIS));

		this.menuBar = new JMenuBar(); // create a menu bar
		this.menuFile = new JMenu(this.menuTexts[0]); // create a menu named 'File'
		this.menuFile.setMnemonic(java.awt.event.KeyEvent.VK_F);

		this.menuItemImport = new JMenuItem(this.menuItemTexts[0][0]); // create a menu item named 'Open'
		this.menuItemImport.setName(this.menuItemNames[0][0]);
		this.menuItemImport.setIcon(new ImageIcon(JFileChooserDemo.Icons[0], JFileChooserDemo.IconDescs[0]));
		this.menuItemImport.setMnemonic(java.awt.event.KeyEvent.VK_I);
		this.menuItemImport.addActionListener(new menuActionListener());

		this.menuItemExport = new JMenuItem(this.menuItemTexts[0][1]);
		this.menuItemExport.setName(this.menuItemNames[0][1]);
		this.menuItemExport.setIcon(new ImageIcon(JFileChooserDemo.Icons[1], JFileChooserDemo.IconDescs[1]));
		this.menuItemExport.setMnemonic(java.awt.event.KeyEvent.VK_E);
		this.menuItemExport.addActionListener(new menuActionListener());

		this.menuItemExit = new JMenuItem(this.menuItemTexts[0][2]); // create a menu item named 'Exit'
		this.menuItemExit.setName(this.menuItemNames[0][2]);
		this.menuItemExit.setIcon(new ImageIcon(JFileChooserDemo.Icons[2], JFileChooserDemo.IconDescs[2]));
		this.menuItemExit.setMnemonic(java.awt.event.KeyEvent.VK_X);
		this.menuItemExit.addActionListener(new ActionListener() { // add actionlistener, when 'Exit' menu itme is selected, then disposes the frame
					public void actionPerformed(ActionEvent e) {
						JFileChooserDemo.this.dispose();
					}
			});
		// add menu item to the menu bar, then set the menu bar
		this.menuFile.add(this.menuItemImport);
		this.menuFile.add(this.menuItemExport);
		this.menuFile.add(this.menuItemExit);
		this.menuBar.add(this.menuFile);
		setJMenuBar(this.menuBar);

		this.separatorMenuBarAndToolBar = new JSeparator(SwingConstants.HORIZONTAL);
		this.separatorMenuBarAndToolBar.setBounds(0, ImageObserver.HEIGHT, this.width, 1);
		this.container.add(this.separatorMenuBarAndToolBar);


		this.toolBar = new JToolBar("mainToolBar", SwingConstants.HORIZONTAL);
		this.toolBar.setBackground(Color.PINK);
		JButton importFile = new JButton();
		importFile.setName(this.toolbarButtonNames[0]);
		importFile.setToolTipText("Excel");
		importFile.setIcon(new ImageIcon(Icons[0], IconDescs[0]));
		importFile.addActionListener(new toolbarActionListener());

		JButton exportFile = new JButton();
		exportFile.setName(this.toolbarButtonNames[1]);
		exportFile.setToolTipText("Excel");
		exportFile.setIcon(new ImageIcon(Icons[1], IconDescs[1]));
		exportFile.addActionListener(new toolbarActionListener());

		this.toolBar.add(importFile);
		this.toolBar.add(exportFile);
		this.toolBar.setFloatable(false);
		this.container.add(this.toolBar);

		this.separatorToolBarAndMainPanel = new JSeparator(SwingConstants.HORIZONTAL);
		//this.container.add(this.separatorToolBarAndMainPanel);

		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(null); // don't set the layout
		this.mainPanel.setBackground(Color.GRAY);
		//this.mainPanel.setBounds(10, 10, 700, 430);
		this.container.add(this.mainPanel);







		this.labMsg = new JLabel("Message:");
		this.labMsg.setBounds(10, 10, 350, 19);
		this.mainPanel.add(this.labMsg);

		this.fileChooser = new JFileChooser();
		this.fileChooser.setDialogTitle("Excel");
		this.fileChooser.setAcceptAllFileFilterUsed(false);
		this.fileChooser.setFileFilter(new FileNameExtensionFilter(
				"Microsoft Office Excel (*.xls, *.xlsx)", "xls", "xlsx"));
		this.fileChooser.setApproveButtonText("");
		//this.fileChooser.setApproveButtonMnemonic(java.awt.event.KeyEvent.VK_C);

		setVisible(true); // the frame will visit
		//setResizable(false); // unable to change the frame size
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // The frame will dispose when the "Exit" button is pressed.
	}

	/**
	 * <code>main</code> : main entrence method
	 *
	 * @param args
	 *            console arguments
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JFileChooserDemo().setVisible(true);
			}

		});
	}

	class menuActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			JMenuItem menuItem = (JMenuItem) event.getSource();
			String menuItemName = menuItem.getName();
			if (menuItemName.equalsIgnoreCase(JFileChooserDemo.this.menuItemNames[0][0])) {
				int result = JFileChooserDemo.this.fileChooser.showOpenDialog(JFileChooserDemo.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = JFileChooserDemo.this.fileChooser.getSelectedFile();
					try {
						ExcelUtils.getInstance().getExcelsData(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String str;
					str = "The file you choosed is : " + f.getName() + "\n";
					JFileChooserDemo.this.labMsg.setText(str);
				}
				if (result == JFileChooser.CANCEL_OPTION) {
					String str = "You choose no files!";
					JFileChooserDemo.this.labMsg.setText(str);
				}
			} else if (menuItemName.equalsIgnoreCase(JFileChooserDemo.this.menuItemNames[0][1])) {

			} else if (menuItemName.equalsIgnoreCase(JFileChooserDemo.this.menuItemNames[0][2])) {

			}

		}

	}

	class toolbarActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton toolbarButton = (JButton) event.getSource();
			String toolbarButtonName = toolbarButton.getName();
			if (toolbarButtonName.equalsIgnoreCase(JFileChooserDemo.this.toolbarButtonNames[0])) {
				int result = JFileChooserDemo.this.fileChooser.showOpenDialog(JFileChooserDemo.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = JFileChooserDemo.this.fileChooser.getSelectedFile();
					try {
						ExcelUtils.getInstance().getExcelsData(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String str;
					str = "The file you choosed is : " + f.getName() + "\n";
					JFileChooserDemo.this.labMsg.setText(str);
				}
				if (result == JFileChooser.CANCEL_OPTION) {
					String str = "You choose no files!";
					JFileChooserDemo.this.labMsg.setText(str);
				}
			} else if (toolbarButtonName.equalsIgnoreCase(JFileChooserDemo.this.toolbarButtonNames[1])) {

			}

		}

	}

}