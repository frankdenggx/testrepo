package edu.frank.headfirst.proxy.virtualproxy;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class ImageTestDrive extends JFrame {
	JMenuBar menuBar;
//	JToolBar toolBar;
	JMenu menu;
	//JMenuItem[] menuItems;  
	Container container;
	ImageComponent img;
	Hashtable<String, String> cds = new Hashtable<String, String>();
	public ImageTestDrive(){
		//super();
		cds.put("WESTLIFT", "http://img32.mtime.cn/up/2013/01/06/150231.16096216_o.jpg");
		initComponents();
	}
	
	private void initComponents() {
		Dimension dimension = new Dimension(800, 600);
		this.setTitle("动态代理测试");
		this.setSize(dimension);
		
		container = this.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("文件(F)");
		menu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem westLift = new JMenuItem("WESTLIFT(W)", KeyEvent.VK_W);
		JMenuItem exit = new JMenuItem("退出(X)", KeyEvent.VK_X);
		exit.addActionListener(new _ExitAction());
		westLift.addActionListener(new _WestliftAction());
		menu.add(westLift);
		menu.add(exit);
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		try {
			Icon icon = new ImageProxy(new URL("http://c.hiphotos.baidu.com/baike/w%3D268/sign=121b3f324e086e066aa8384d3a097b5a/730e0cf3d7ca7bcba0c4642cbc096b63f624a872.jpg"));
			img = new ImageComponent(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		container.add(img);
		
		this.setPreferredSize(dimension);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	URL getCDUrl(String name) {
		try {
			return new URL(cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		new ImageTestDrive();
	}
	
	class _ExitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e != null) {
				System.exit(1);
			}
		}
		
	}
	class _WestliftAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e != null) {
				Icon icon;
				try {
					icon = new ImageProxy(new URL("http://img32.mtime.cn/up/2013/01/06/150231.16096216_o.jpg"));
					img.setIcon(icon);
					ImageTestDrive.this.repaint();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

}
