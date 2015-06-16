/**
 *JTreeDemo.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JGUISource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

class JTreeDemo extends JFrame implements TreeSelectionListener{

	private JTree tree;
	private Container container;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item1;
	private JLabel lab;
	private int m_height,m_width;
        private Toolkit toolkit =getToolkit();
	/**
	 * Method JTreeDemo
	 *
	 *
	 */
	public JTreeDemo() {
		setTitle("JTree");
		setSize(350,300);

                //
                m_width = getWidth();
                m_height = getHeight();
                int x = (toolkit.getScreenSize().width-m_width)/2;
                int y = (toolkit.getScreenSize().height-m_height)/2;
                this.setBounds(x,y,m_width,m_height);

		container = getContentPane();

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
				JTreeDemo.this.dispose();
			}
			});
		//
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("");
		//TreeModel
        DefaultTreeModel treemode = new DefaultTreeModel(root);
        //node1node2
        treemode.insertNodeInto(node1,root,root.getChildCount());
        treemode.insertNodeInto(node2,root,root.getChildCount());

        //node1
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("(C:)");
        treemode.insertNodeInto(leafnode,node1,node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("(D:)");
        treemode.insertNodeInto(leafnode,node1,node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("(E:)");
        treemode.insertNodeInto(leafnode,node1,node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("(F:)");
        treemode.insertNodeInto(leafnode,node1,node1.getChildCount());

        //node2
        leafnode = new DefaultMutableTreeNode("DVD(G:)");
        treemode.insertNodeInto(leafnode,node2,node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("DVD(H:)");
        treemode.insertNodeInto(leafnode,node2,node2.getChildCount());

        //
        tree = new JTree(treemode);
        //Tree
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        //
        tree.addTreeSelectionListener(this);
        tree.setRowHeight(20);
        //
        DefaultTreeCellRenderer cellrenderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
        cellrenderer.setFont(new Font("Serif",Font.PLAIN,14));
        cellrenderer.setBackgroundNonSelectionColor(Color.white);
        cellrenderer.setBackgroundSelectionColor(Color.yellow);
        cellrenderer.setBorderSelectionColor(Color.red);

		//,
		cellrenderer.setTextNonSelectionColor(Color.black);
		cellrenderer.setTextSelectionColor(Color.green);

		container.add(new JScrollPane(tree));
		//

		lab = new JLabel(":",SwingConstants.CENTER);
		lab.setFont(new Font("Serif",Font.PLAIN,14));
		container.add(lab,BorderLayout.SOUTH);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// TODO: Add your code here
	}
	public void valueChanged(TreeSelectionEvent event)
	{
		JTree tree = (JTree) event.getSource();
		DefaultMutableTreeNode selectionnode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		String nodeName = selectionnode.toString();
		lab.setText(":"+nodeName);
	}

}