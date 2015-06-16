/**
 *AnimatorDemo.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JBasicSource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class AnimatorDemo extends JFrame implements ActionListener
{
	private AnimatorPanel animatorPanel;   //
	private JButton startButton, stopButton,exitButton;
	private JPanel buttonPanel;      //
	private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	public AnimatorDemo()
	{
	    super("");
	    setSize(400, 400);

            //
        this.m_width = getWidth();
        this.m_height = getHeight();
        int x = (this.toolkit.getScreenSize().width-this.m_width)/2;
        int y = (this.toolkit.getScreenSize().height-this.m_height)/2;
        this.setBounds(x,y,this.m_width,this.m_height);


	    //
	    Container container = getContentPane();

	    //
	    this.animatorPanel = new AnimatorPanel();
	    container.add(this.animatorPanel, BorderLayout.CENTER);

	    //
	    this.startButton = new JButton("");
	    this.stopButton = new JButton("");
            this.exitButton = new JButton("");
	    this.stopButton.setEnabled(false);
	    //
	    Font font = new Font("Serif", Font.PLAIN, 14);
	    this.startButton.setFont(font);
	    this.stopButton.setFont(font);
            this.exitButton.setFont(font);
	    //
	    this.startButton.addActionListener(this);
	    this.stopButton.addActionListener(this);
            this.exitButton.addActionListener(this);
	    //
	    this.buttonPanel = new JPanel();
	    this.buttonPanel.add(this.startButton);
	    this.buttonPanel.add(this.stopButton);
            this.buttonPanel.add(this.exitButton);

	    container.add(this.buttonPanel, BorderLayout.SOUTH);

            setResizable(false);
	    setVisible(true);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	//
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.startButton) {
			this.animatorPanel.start();
		} else if(event.getSource() == this.stopButton) {
			this.animatorPanel.stop();
		} else if(event.getSource() == this.exitButton) {
					dispose();
				}
	}

    class AnimatorPanel extends JPanel implements ActionListener
    {
    	private ImageIcon images[];
    	private int currentImage = 0;     //
    	private Timer timer;              //
    	private int x = -100, y;                 //

        public AnimatorPanel()
        {
        	super();
        	setBackground(Color.WHITE);
        	this.images = new ImageIcon[4];    //
        	for(int i = 0; i < this.images.length; i++)
        	{        //
        		this.images[i] = new ImageIcon("src/main/resources/edu/frank/swing/picture/boy0" + (i+1) + ".png");
        	}
        }

        @Override
		public void paintComponent(Graphics g)
        {
            Graphics2D g2d=(Graphics2D)g;
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            //,
            this.y = (getHeight() - this.images[this.currentImage].getIconHeight())/2;
            this.images[this.currentImage].paintIcon(this, g, this.x, this.y);
            //
            this.currentImage = (++this.currentImage)%4;
        }
        //
        public void start()
        {
        	if(this.timer == null)
        	{
        		this.currentImage = 0;
        		this.timer = new Timer(100, this);      //
        		this.timer.start();
        	}
        	else if(!this.timer.isRunning()) {
				this.timer.restart();
			}
        	AnimatorDemo.this.startButton.setEnabled(false);
        	AnimatorDemo.this.stopButton.setEnabled(true);
        }
        //
        public void stop()
        {
        	this.timer.stop();
        	AnimatorDemo.this.startButton.setEnabled(true);
        	AnimatorDemo.this.stopButton.setEnabled(false);
        }

        //
        public void actionPerformed(ActionEvent event)
        {
        	this.x += 10;
        	if(this.x >= 450) {
				this.x = -100;
			}
        	repaint();
        }
    }
}