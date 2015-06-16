/**
 *JTabbedPane.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JGUISource;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

class JTabbedPaneDemo extends JFrame {
	private JTabbedPane tabbedpane;
	private Container container;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item1;
	private JPanel pan1,pan2,pan3;
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	/**
	 * Method JTabbedPaneDemo
	 *
	 *
	 */
	public JTabbedPaneDemo() {

		setTitle("JTabbedPane");
		setSize(350,300);

                //
                m_width = getWidth();
                m_height = getHeight();
                int x = (toolkit.getScreenSize().width-m_width)/2;
                int y = (toolkit.getScreenSize().height-m_height)/2;
                this.setBounds(x,y,m_width,m_height);

		container = getContentPane();
		container.setBackground(Color.white);

		menubar = new JMenuBar();
		menu = new JMenu("Option");
		item1 = new JMenuItem("Exit");
		menu.add(item1);
		menubar.add(menu);
		setJMenuBar(menubar);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JTabbedPaneDemo.this.dispose();
			}
		});

		pan1 = new JPanel();
		pan1.setBackground(Color.RED);
		pan2 = new JPanel();
		pan2.setBackground(Color.GREEN);
		pan3 = new JPanel();
		pan3.setBackground(Color.BLUE);

		tabbedpane = new JTabbedPane();
		tabbedpane.setBackground(Color.white);

		tabbedpane.addTab("Tab one",null,pan1,"First JPanel");
		tabbedpane.addTab("Tab two",null,pan2,"Second JPanel");
		tabbedpane.addTab("Tab three",null,pan3,"Third JPanel");

		container.add(tabbedpane);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// TODO: Add your code here
	}
}