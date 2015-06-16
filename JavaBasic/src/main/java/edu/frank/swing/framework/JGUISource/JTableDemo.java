/**
 *JTableDemo.java
 *
 *@author:yoyudeng
 *
 *2007-6-16
 */
package edu.frank.swing.framework.JGUISource;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

class JTableDemo extends JFrame implements TableModelListener{
	private JTable table;
	private MyTable mytable;
	private Container container;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem item1;
	private JLabel lab;
	private JComboBox c;
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	/**
	 * Method JTableDemo
	 *
	 *
	 */
	public JTableDemo() {
		setTitle("JTable");
		setSize(400,300);

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
				JTableDemo.this.dispose();
			}
			});
		mytable = new MyTable();
		mytable.addTableModelListener(this);
		table = new JTable(mytable);
		c = new JComboBox();
		c.addItem("03A01");
		c.addItem("03A02");
		c.addItem("03A03");

		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(c));
		container.add(new JScrollPane(table));

		lab = new JLabel("Message:",SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(400,30));
		lab.setFont(new Font("Serif",Font.PLAIN,14));
		container.add(lab,BorderLayout.SOUTH);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// TODO: Add your code here
	}
	public void tableChanged(TableModelEvent event)
	{
		int row = event.getFirstRow();
		String fullName = ((String)(mytable.getValueAt(row,1)));
		String className = ((String)(mytable.getValueAt(row,2)));
		lab.setText("Message:"+fullName+""+className+" ");
	}
}

class MyTable extends AbstractTableModel
{
	private Object[][] data =
	{
	{"032520","","03A01",new Integer(50),new Integer(50),new Integer(50),new Integer(50+50+50)},
	{"032521","","03A02",new Integer(45),new Integer(46),new Integer(48),new Integer(45+46+48)}
	};
	private String[] header = {"","","","","","",""};
	public int getColumnCount()
	{
		return header.length;
	}
	public int getRowCount()
	{
		return data.length;
	}
	@Override
	public String getColumnName(int col)
	{
		return header[col];
	}
	public Object getValueAt(int row,int col)
	{
		return data[row][col];
	}
	@Override
	public Class getColumnClass(int cc)
	{
		return getValueAt(0,cc).getClass();
	}
	@Override
	public boolean isCellEditable(int rowIndex,int columnIndex)
	{
		return true;
	}
	@Override
	public void setValueAt(Object value,int row,int col)
	{
		if(col != 2) {
			return;
		}
		data[row][col] = value;
		fireTableCellUpdated(row,col);
	}

}