/**
 *JColorChooserDemo.java
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

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class JColorChooserDemo extends JFrame implements ActionListener{

	private JButton btn1,btn2;
	private JColorChooser colorchooser;
	private Container container;
	private JPanel pan1;
	private Color color;
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	/**
	 * Method JColorChooserDemo
	 *
	 *
	 */
	public JColorChooserDemo() {

		setTitle("JColorChooser");
		setSize(350,200);

                //
                m_width = getWidth();
                m_height = getHeight();
                int x = (toolkit.getScreenSize().width-m_width)/2;
                int y = (toolkit.getScreenSize().height-m_height)/2;
                this.setBounds(x,y,m_width,m_height);

		container = getContentPane();
		color = Color.WHITE;

		pan1 = new JPanel();
		pan1.setBackground(color);
		container.add(pan1);

		btn1 = new JButton("ChangeColor");
		btn1.addActionListener(this);
		btn2 = new JButton("Exit");
		btn2.addActionListener(this);

		pan1.add(btn1);
		pan1.add(btn2);

		colorchooser = new JColorChooser();


		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// TODO: Add your code here
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == btn1)
		{
			color  = JColorChooser.showDialog(JColorChooserDemo.this,"",color);

			if(color == null) {
				color = pan1.getBackground();
			}
			pan1.setBackground(color);
		}
		else if(event.getSource() == btn2) {
			dispose();
		}

	}
}