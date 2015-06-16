/**
 *JSliderDemo.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JGUISource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class JSliderDemo extends JFrame implements ChangeListener{

	private Container container;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item1;
	private JSliderEx sliderRed,sliderGreen,sliderBlue;
	private JPanel pan1,pan2;
	private Color color;
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();
	/**
	 * Method JSliderDemo
	 *
	 *
	 */
	public JSliderDemo() {

		setTitle("JSlider");
		setSize(400,350);

                //
                m_width = getWidth();
                m_height = getHeight();
                int x = (toolkit.getScreenSize().width-m_width)/2;
                int y = (toolkit.getScreenSize().height-m_height)/2;
                this.setBounds(x,y,m_width,m_height);

		container = getContentPane();

		menubar = new JMenuBar();
		menu = new JMenu("Option");
		item1 = new JMenuItem("Exit");
		menu.add(item1);
		menubar.add(menu);
		setJMenuBar(menubar);
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JSliderDemo.this.dispose();
			}
		});

		pan1 = new JPanel();
		pan1.setBackground(Color.BLACK);
		container.add(pan1,BorderLayout.CENTER);

		pan2 = new JPanel();
	    pan2.setBackground(Color.YELLOW);
	    pan2.setPreferredSize(new Dimension(400,150));
	    pan2.setLayout(new GridLayout(3,1,5,5));

	    sliderRed = new JSliderEx(this,0,255,0);
	    sliderGreen = new JSliderEx(this,0,255,0);
	    sliderBlue = new JSliderEx(this,0,255,0);

	    sliderRed.setBackground(Color.RED);
	    sliderGreen.setBackground(Color.GREEN);
	    sliderBlue.setBackground(Color.BLUE);

	    pan2.add(sliderRed);
	    pan2.add(sliderGreen);
	    pan2.add(sliderBlue);

	    container.add(pan2,BorderLayout.SOUTH);


		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// TODO: Add your code here
	}
	public void stateChanged(ChangeEvent event)
	{
		color = new Color(sliderRed.getValue(),sliderGreen.getValue(),sliderBlue.getValue());
		pan1.setBackground(color);
	}
	class JSliderEx extends JSlider
	{
		public JSliderEx(ChangeListener listener,int min,int max,int value)
		{
			super(min,max,value);
			setPaintTicks(true);
			setMajorTickSpacing(15);
			setMinorTickSpacing(3);
			setPaintLabels(true);
			addChangeListener(listener);
		}
	}
}