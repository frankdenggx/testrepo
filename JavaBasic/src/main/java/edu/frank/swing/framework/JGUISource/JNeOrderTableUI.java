package edu.frank.swing.framework.JGUISource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ProgressMonitor;
import javax.swing.WindowConstants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.base.data.AbstractBaseInfo;
import edu.frank.base.data.CustomerInfo;
import edu.frank.base.data.EmployeeInfo;
import edu.frank.base.data.EnumCategory;
import edu.frank.base.data.SysenumInfo;
import edu.frank.common.db.DBConnectionManager;
import edu.frank.common.db.DbRegistryTypeEnum;
import edu.frank.log4j.Log4JConfig;
import edu.frank.swing.framework.util.SwingUtils;

public class JNeOrderTableUI extends javax.swing.JPanel {

	private static final long serialVersionUID = -299062996239873075L;

	private javax.swing.JFrame parentUI;

	private DBConnectionManager manager;

	private java.sql.Connection conn;

	private Object preObject;

	private javax.swing.ProgressMonitor progressMonitor;

	private javax.swing.Timer timer;

	private static final Logger logger = Log4JConfig
			.getLogger(JNeOrderTableUI.class);

	class TimerHandler implements ActionListener {
		String msg = null;
		java.util.List collection;

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == JNeOrderTableUI.this.timer) {
				if (JNeOrderTableUI.this.progressMonitor.isCanceled()) {
					JNeOrderTableUI.this.progressMonitor.close();
					JNeOrderTableUI.this.timer.stop();
					JNeOrderTableUI.this.btnImport.setEnabled(true);
					JNeOrderTableUI.this.progressMonitor = null;
					JNeOrderTableUI.this.timer = null;
				}
				if (this.collection == null) {
					try {
						this.collection = getDbData();
					} catch (SQLException ex) {
						logger.error(ex.getMessage(), ex);
					} catch (Exception ex) {
						logger.error(ex.getMessage(), ex);
					}
				} else {
					try {
						int size = this.collection.size();
						int index = 0;
						int progress = 45;
						java.util.Iterator<CustomerInfo> iterator = this.collection
								.iterator();
						while (iterator.hasNext()) {
							index++;
							AbstractBaseInfo customer = (CustomerInfo) iterator
									.next();
							if (customer != null) {
								progress = insertTable(customer, size, index,
										progress);
								logger.error("---------- progress : "
										+ progress + ", index : " + index);
							}
						}

						// add progress info
						JNeOrderTableUI.this.progressMonitor.setProgress(100);
						String msg = "";
						JNeOrderTableUI.this.progressMonitor.setNote(msg);
						Thread.sleep(500);
						JNeOrderTableUI.this.progressMonitor.close();
						JNeOrderTableUI.this.timer.stop();
						JNeOrderTableUI.this.btnImport.setEnabled(true);
						JNeOrderTableUI.this.progressMonitor = null;
						JNeOrderTableUI.this.timer = null;
					} catch (Exception ex) {
						logger.error(ex.getMessage(), ex);
					}
				}
			}
		}

	}

	/** Creates new form JNeOrderTableUI */
	public JNeOrderTableUI() {
		initComponents();

		SwingUtils.enterPressesWhenFocused(this.txtStockInNo, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logger.error("-----------------------------------------------------------------------------");
			}

		});

		this.preObject = this.measureUnit.getSelectedItem(); 
		try {
			initEnum(EnumCategory.MEASURE_UNIT);
		} catch (SQLException e1) {
			logger.error(e1.getMessage(), e1);
		} catch (Exception e2) {
			logger.error(e2.getMessage(), e2);
		}

		this.tabNeorder.setAutoCreateRowSorter(true);
		this.parentUI = new javax.swing.JFrame("");
		this.parentUI.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				logger.error("Window[edu.frank.swing.framework.JGUISource.JNeOrderTableUI] will be closed! ");
				try {
					Thread.sleep(1 * 1000);
				} catch (InterruptedException e1) {
					logger.error(
							"Fail to close Window[edu.frank.swing.framework.JGUISource.JNeOrderTableUI]",
							e1);
					//e1.printStackTrace();
				}
				if (JNeOrderTableUI.this.conn != null) {
					try {
						JNeOrderTableUI.this.conn.close();
						JNeOrderTableUI.this.manager.freeConnetion(
								"JavaBasicPool", JNeOrderTableUI.this.conn);
						JNeOrderTableUI.this.manager.release();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
				super.windowClosed(e);
			}
		});
		java.awt.Container container = this.parentUI.getContentPane();
		container.add(this);
		this.parentUI
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		this.btnImport = new javax.swing.JButton();
		this.jScrollPane1 = new javax.swing.JScrollPane();
		this.tabNeorder = new javax.swing.JTable();
		this.labMeasureUnit = new javax.swing.JLabel();
		this.measureUnit = new javax.swing.JComboBox();
		this.txtStockInNo = new javax.swing.JTextField();

		this.btnImport.setText("\u5bfc\u5165Excel\u6587\u4ef6");
		this.btnImport.setToolTipText("\u5bfc\u5165Excel\u6587\u4ef6");
		this.btnImport.setActionCommand("_IMP_EXCEL");
		this.btnImport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnImportActionPerformed(evt);
			}
		});

		this.jScrollPane1.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(255, 102, 51), 1, true));

		this.tabNeorder.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "", "", "", "", "", "",
						"", "", "", "", "", "" }) {
			Class[] types = new Class[] { java.lang.Integer.class,
					java.lang.Integer.class, java.lang.String.class,
					java.lang.Object.class, java.lang.Object.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false, false, false };

			@Override
			public Class getColumnClass(int columnIndex) {
				return this.types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return this.canEdit[columnIndex];
			}
		});
		this.tabNeorder.setToolTipText("\u5ba2\u6237\u4fe1\u606f");
		this.jScrollPane1.setViewportView(this.tabNeorder);

		this.labMeasureUnit.setText("\u8ba1\u91cf\u5355\u4f4d\uff1a");

		this.measureUnit.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " " }));
		this.measureUnit.setToolTipText("\u8ba1\u91cf\u5355\u4f4d");
		this.measureUnit.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				measureUnitItemStateChanged(evt);
			}
		});
		this.measureUnit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				measureUnitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														this.jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														806, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		this.btnImport)
																.addGap(57, 57,
																		57)
																.addComponent(
																		this.labMeasureUnit)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		this.measureUnit,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		205,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		this.txtStockInNo,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		150,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(this.btnImport)
												.addComponent(this.labMeasureUnit)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		this.measureUnit,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		this.txtStockInNo,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										389, Short.MAX_VALUE).addContainerGap()));
	}// </editor-fold>
	//GEN-END:initComponents

	private void measureUnitActionPerformed(java.awt.event.ActionEvent evt) {
		if (evt != null) {
			if (evt.getActionCommand().equalsIgnoreCase("comboBoxChanged")) {
				logger.debug("----------- action : " + evt.getID());
			}
		}
	}

	private void measureUnitItemStateChanged(java.awt.event.ItemEvent evt) {
		if (evt != null) {
			logger.debug("----------- state change : " + evt.getID());
			Object obj = evt.getItem();
			if (!obj.equals(this.preObject)) {
				this.preObject = obj;
				if (obj != null && obj instanceof SysenumInfo) {
					SysenumInfo sysenumInfo = (SysenumInfo) obj;
					logger.debug(sysenumInfo.getTotalString());
				}
			}

		}
	}

	private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO ...
		this.progressMonitor = new ProgressMonitor(JNeOrderTableUI.this,null,"", 0, 100);
		this.progressMonitor.setMillisToDecideToPopup(200);
		this.progressMonitor.setMillisToPopup(500);
		this.progressMonitor.setProgress(0);
		TimerHandler handler = new TimerHandler();
		this.timer = new javax.swing.Timer(0, handler);
		this.btnImport.setEnabled(false);
		this.timer.start();

		/*try {
					java.util.List collection = getDbData();
					if (collection != null) {
						java.util.Iterator<CustomerInfo> iterator = collection
								.iterator();
						while (iterator.hasNext()) {
							AbstractBaseInfo customer = (CustomerInfo) iterator.next();
							if (customer != null) {
								insertTable(customer);
							}
						}
					}
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}*/

	}

	public int insertTable(AbstractBaseInfo customer, int size, int index,
			int progress) throws Exception {
		CustomerInfo real = (CustomerInfo) customer;
		int seq = real.getSeq();
		String fid = real.getFid();
		int no = real.getNo();
		String name = real.getName();
		java.util.Date createTime = real.getCreateTime();
		String description = real.getDescription();
		EmployeeInfo custRep = real.getCustRep();
		EmployeeInfo custManager = real.getCustManager();

		String custContact = real.getCustContact();
		String custPhone = real.getCustPhone();
		String custTele = real.getCustTele();
		String custFax = real.getCustFax();
		String custEmail = real.getCustEmail();
		int custZip = real.getCustZip();
		String custAddr = real.getCustAddr();
		javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) this.tabNeorder
				.getModel();
		java.util.Vector<Object> v = new java.util.Vector<Object>();
		v.add(seq);
		v.add(no);
		v.add(name);
		v.add(custRep);
		v.add(custManager);
		v.add(custContact);
		v.add(custPhone);
		v.add(custTele);
		v.add(custFax);
		v.add(custEmail);
		v.add(custZip);
		v.add(custAddr);
		tableModel.addRow(v);

		int mill = (new java.util.Random()).nextInt(Math.max(index * 50 / size,
				1));
		progress += mill;
		// add progress info
		Thread.sleep(50L);
		JNeOrderTableUI.this.progressMonitor
				.setProgress(Math.min(progress, 95));
		String msg = "" + no + ", " + name + "]...";
		JNeOrderTableUI.this.progressMonitor.setNote(msg);
		return progress;
	}

	public void initEnum(EnumCategory enumCategory)
			throws java.sql.SQLException, Exception {
		if (enumCategory == null) {
			throw new Exception("Invalid parameter, enumeration is empty!");
		}
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM `sysenum` WHERE `sysenum`.`enum_cate`= ? ORDER BY (`sysenum`.`item_value` + 0)");
		if (this.conn == null) {
			this.manager = DBConnectionManager
					.getInstance(DbRegistryTypeEnum.PROPERTIES);
			this.conn = this.manager.getConnection("JavaBasicPool");
		}

		if (this.conn != null) {
			java.sql.PreparedStatement preStmt = this.conn.prepareStatement(sql
					.toString());
			preStmt.setString(1, enumCategory.getValue());
			java.sql.ResultSet rs = preStmt.executeQuery();
			if (rs != null) {
				this.measureUnit.removeAllItems();
				javax.swing.DefaultComboBoxModel comboBoxModel = (javax.swing.DefaultComboBoxModel) this.measureUnit
						.getModel();
				while (rs.next()) {
					int seq = rs.getInt("T_SEQ");
					String fid = rs.getString("T_FID");
					int no = rs.getInt("T_NO");
					String name = rs.getString("T_NAME");
					java.sql.Timestamp createTimeTimeStamp = rs
							.getTimestamp("T_CREATETIME");
					java.util.Date createTime = new java.util.Date(
							createTimeTimeStamp.getTime());
					String description = rs.getString("T_DESC");
					String enumCateValue = rs.getString("ENUM_CATE");
					EnumCategory enumCate = StringUtils.isBlank(enumCateValue) ? null
							: EnumCategory.getByValue(enumCateValue);
					String itemName = rs.getString("ITEM_NAME");
					String itemAlias = rs.getString("ITEM_ALIAS");
					String itemValue = rs.getString("ITEM_VALUE");
					SysenumInfo sysenumInfo = new SysenumInfo(seq, fid, no,
							name, createTime, description, enumCate, itemName,
							itemAlias, itemValue);
					comboBoxModel.addElement(sysenumInfo);

				}
				this.measureUnit.setModel(comboBoxModel);
				if (rs != null) {
					rs.close();
				}
				if (preStmt != null) {
					preStmt.close();
				}
			}
		}
	}

	public java.util.List getDbData() throws java.sql.SQLException, Exception {
		java.util.List collection = null;
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM customer WHERE `customer`.`t_seq` < ? ");
		int maxSeq = 50000;
		// add progress info
		JNeOrderTableUI.this.progressMonitor.setProgress(5);
		String msg = "";
		JNeOrderTableUI.this.progressMonitor.setNote(msg);
		this.manager = DBConnectionManager
				.getInstance(DbRegistryTypeEnum.PROPERTIES);
		this.conn = this.manager.getConnection("JavaBasicPool");
		if (this.conn != null) {
			// add progress info
			JNeOrderTableUI.this.progressMonitor.setProgress(10);
			msg = "";
			JNeOrderTableUI.this.progressMonitor.setNote(msg);
			java.sql.PreparedStatement preStmt = this.conn.prepareStatement(sql
					.toString());
			preStmt.setInt(1, maxSeq);
			java.sql.ResultSet rs = preStmt.executeQuery();
			if (rs != null) {
				// add progress info
				JNeOrderTableUI.this.progressMonitor.setProgress(35);
				msg = "";
				JNeOrderTableUI.this.progressMonitor.setNote(msg);
				collection = new java.util.ArrayList();
				while (rs.next()) {
					int seq = rs.getInt("T_SEQ");
					String fid = rs.getString("T_FID");
					int no = rs.getInt("T_NO");
					String name = rs.getString("T_NAME");
					java.sql.Timestamp createTimeTimeStamp = rs
							.getTimestamp("T_CREATETIME");
					java.util.Date createTime = new java.util.Date(
							createTimeTimeStamp.getTime());
					String description = rs.getString("T_DESC");
					String custRepFid = rs.getString("CUST_REP");
					String custManagerFid = rs.getString("CUST_MANAGER");
					String custContact = rs.getString("CUST_CONTACT");
					String custPhone = rs.getString("CUST_PHONE");
					String custTele = rs.getString("CUST_TELE");
					String custFax = rs.getString("CUST_FAX");
					String custEmail = rs.getString("CUST_EMAIL");
					int custZip = rs.getInt("CUST_ZIP");
					String custAddr = rs.getString("CUST_ADDR");

					CustomerInfo customer = new CustomerInfo(seq, fid, no,
							name, createTime, description, custPhone, custTele,
							custEmail, custFax, null, null, custContact,
							custZip, custAddr);

					collection.add(customer);

				}
				if (rs != null) {
					rs.close();
				}
				if (preStmt != null) {
					preStmt.close();
				}
				// add progress info
				JNeOrderTableUI.this.progressMonitor.setProgress(85);
				msg = "";
				JNeOrderTableUI.this.progressMonitor.setNote(msg);
			}
		}
		return collection;
	}


	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnImport;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel labMeasureUnit;
	private javax.swing.JComboBox measureUnit;
	private javax.swing.JTable tabNeorder;
	private javax.swing.JTextField txtStockInNo;
	// End of variables declaration//GEN-END:variables

}