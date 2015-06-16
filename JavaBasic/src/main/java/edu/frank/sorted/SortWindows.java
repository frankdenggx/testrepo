package edu.frank.sorted;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

@SuppressWarnings("serial")
public class SortWindows extends JFrame {

	private static Logger logger = Log4JConfig.getLogger(SortWindows.class);

	private int width;
	private int height;
	
	private JMenuBar menuBar;
	private JMenu simpleSortedMenu;
	private JMenu advanceSortedMenu;
	private JMenuItem bubbleSortedMenuItem;
	private JMenuItem selectedSortedMenuItem;
	private JMenuItem insertedSortedMenuItem;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JButton initBtn;
	private JButton stepBtn;
	private JButton drawBtn;
	private JButton runBtn;
	private JButton sizeBtn;
	
	private int arrLength;
	
	public SortWindows() {
		initComponents();
	}
	
	private void initComponents() {
		width = 800;
		height = 600;
		//java.awt.Dimension dimension = new java.awt.Dimension(width, height);
		
		setTitle("排序窗体");
		
		java.awt.Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		double screenHeight = screenDimension.getHeight();
		double screenWidth = screenDimension.getWidth();
		
		setBounds((int)(screenWidth-width)/2, (int) (screenHeight-height)/2, width, height);
		
		simpleSortedMenu = new JMenu("简单排序（S）");
		simpleSortedMenu.setMnemonic(KeyEvent.VK_S);
		advanceSortedMenu = new JMenu("高级排序（A）");
		advanceSortedMenu.setMnemonic(KeyEvent.VK_A);
		
		bubbleSortedMenuItem = new JMenuItem("冒泡排序（B）", KeyEvent.VK_B);
		selectedSortedMenuItem = new JMenuItem("选择排序（L）", KeyEvent.VK_L);
		insertedSortedMenuItem = new JMenuItem("插入排序（R）", KeyEvent.VK_R);
		
		simpleSortedMenu.add(bubbleSortedMenuItem);
		simpleSortedMenu.add(new JSeparator(SwingConstants.HORIZONTAL));
		simpleSortedMenu.add(selectedSortedMenuItem);
		simpleSortedMenu.add(new JSeparator(SwingConstants.HORIZONTAL));
		simpleSortedMenu.add(insertedSortedMenuItem);
		
		menuBar = new JMenuBar();
		menuBar.add(simpleSortedMenu);
		//menuBar.add(new JSeparator(SwingConstants.VERTICAL));
		menuBar.add(advanceSortedMenu);
		
		setJMenuBar(menuBar);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		initBtn = new JButton("新建");
		initBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initBtnActionPerform(e);
			}
		});
		stepBtn = new JButton("单步");
		drawBtn = new JButton("画线");
		runBtn = new JButton("运行");
		sizeBtn = new JButton("数组");
		sizeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sizeBtnActionPerform(e);
			}
		});
		
		
		buttonPanel.add(initBtn);
		buttonPanel.add(stepBtn);
		buttonPanel.add(runBtn);
		buttonPanel.add(drawBtn);
		buttonPanel.add(sizeBtn);
		
		
		Container container = getContentPane();
		container.add(mainPanel,BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.NORTH);
		//setPreferredSize(dimension);
	}
	
	private void initBtnActionPerform(ActionEvent e) {
		
	}
	private void stepBtnActionPerform(ActionEvent e) {
		
	}
	private void drawBtnActionPerform(ActionEvent e) {
		
	}
	private void runBtnActionPerform(ActionEvent e) {
		
	}
	private void sizeBtnActionPerform(ActionEvent e) {
		String input = JOptionPane.showInputDialog(this, "请输入数组大小");
		if (input != null && input.trim().length() > 0 && input.matches("\\D+")) {
			arrLength = new Integer(input).intValue();
		}
		
	}
	
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SortWindows().setVisible(true);
			}
		});
	}

}
