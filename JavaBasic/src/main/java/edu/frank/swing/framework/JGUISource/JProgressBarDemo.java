/**
 *JProgressBarDemo.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JGUISource;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/*
 *JProgressBarDemo
 *
 */

class JProgressBarDemo extends JFrame{

	private Timer timer;//
	private JProgressBar progreebar;//
	private Container container;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item1;
	private JButton btn1,btn2;
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();//Demosion

	/**
	 * Method JProgressBarDemo
	 *
	 *
	 */
	public JProgressBarDemo() {

		setTitle("JProgressBar");
		setSize(350,180);
		//
                m_width = getWidth();
                m_height = getHeight();
                int x = (toolkit.getScreenSize().width-m_width)/2;
                int y = (toolkit.getScreenSize().height-m_height)/2;
                this.setBounds(x,y,m_width,m_height);
		container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		container.setBackground(Color.orange);

		//
		menubar = new JMenuBar();
		menu = new JMenu("Option");
		item1 = new JMenuItem("Exit");
		menu.add(item1);
		menubar.add(menu);
		setJMenuBar(menubar);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				JProgressBarDemo.this.dispose();
			}
			});

		//
		progreebar = new JProgressBar();
		progreebar.setMaximum(100);
		progreebar.setMinimum(0);
		progreebar.setValue(0);
		progreebar.setStringPainted(true);
		progreebar.setBorderPainted(true);
		progreebar.setPreferredSize(new Dimension(300,30));
		progreebar.setBackground(Color.WHITE);
		progreebar.setForeground(Color.BLUE);
		container.add(progreebar);
		//
		btn1 = new JButton("");
		btn2 = new JButton("");
		btn1.setFont(new Font("Serif",Font.PLAIN,14));
		btn2.setFont(new Font("Serif",Font.PLAIN,14));
		btn2.setEnabled(false);

		TimerHandler handler = new TimerHandler();
		btn1.addActionListener(handler);
		btn2.addActionListener(handler);
		container.add(btn1);
		container.add(btn2);
		timer = new Timer(50,handler);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// TODO: Add your code here
	}

	class TimerHandler implements ActionListener
	{
		private int value = 0;
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == timer)
			{
				value = progreebar.getValue();
				if(value < 100)
				{
					value++;
				    progreebar.setValue(value);
				}
				else{
					timer.stop();
					btn1.setEnabled(true);
					btn2.setEnabled(false);
				}
			}
			else if(event.getSource() == btn1)
			{
				if(progreebar.getValue() >= 100) {
					progreebar.setValue(0);
				}
				timer.start();
				btn1.setEnabled(false);
				btn2.setEnabled(true);
			}
			else if(event.getActionCommand().equals(""))
			{
				timer.stop();
				btn2.setText("");
			}
			else if(event.getActionCommand().equals(""))
			{
				timer.restart();
				btn2.setText("");
			}
		}
	}
}