/*
 * JBasic.java
 *
 * Created on 2007616, 1:17
 */

package edu.frank.swing.framework.JBasicSource;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import edu.frank.swing.framework.JSwingMain;
/**
 *
 * @author  yoyudenghihi
 */
public class JBasic extends javax.swing.JFrame {

    /** Creates new form JBasic */
    public JBasic() {
        initComponents();
        //
        this.m_width = getWidth();
        this.m_height = getHeight();
        int x = (this.toolkit.getScreenSize().width-this.m_width)/2;
        int y = (this.toolkit.getScreenSize().height-this.m_height)/2;
        this.setBounds(x,y,this.m_width,this.m_height);
        //
        getContentPane().setBackground(Color.GRAY);
        //
        this.flag1 = true;
        this.flag2 = true;
        this.flag3 = true;
        this.flag4 = true;
        this.flag5 = true;
        this.flag6 = true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="  ">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.jLabel1 = new javax.swing.JLabel();
        this.jScrollPane1 = new javax.swing.JScrollPane();
        this.jTextArea1 = new javax.swing.JTextArea();
        this.jMenuBar1 = new javax.swing.JMenuBar();
        this.jMenu1 = new javax.swing.JMenu();
        this.jMenuItem1 = new javax.swing.JMenuItem();
        this.jMenu2 = new javax.swing.JMenu();
        this.jMenuItem2 = new javax.swing.JMenuItem();
        this.jSeparator1 = new javax.swing.JSeparator();
        this.jMenuItem3 = new javax.swing.JMenuItem();
        this.jMenu3 = new javax.swing.JMenu();
        this.jMenuItem4 = new javax.swing.JMenuItem();
        this.jMenuItem5 = new javax.swing.JMenuItem();
        this.jSeparator2 = new javax.swing.JSeparator();
        this.jMenuItem6 = new javax.swing.JMenuItem();
        this.jMenu4 = new javax.swing.JMenu();
        this.jMenuItem7 = new javax.swing.JMenuItem();
        this.jMenu5 = new javax.swing.JMenu();
        this.jMenuItem8 = new javax.swing.JMenuItem();
        this.jMenu6 = new javax.swing.JMenu();
        this.jMenuItem9 = new javax.swing.JMenuItem();
        this.jMenuItem10 = new javax.swing.JMenuItem();
        this.jSeparator3 = new javax.swing.JSeparator();
        this.jMenuItem11 = new javax.swing.JMenuItem();
        this.jMenu7 = new javax.swing.JMenu();
        this.jMenuItem12 = new javax.swing.JMenuItem();
        this.jSeparator4 = new javax.swing.JSeparator();
        this.jMenuItem13 = new javax.swing.JMenuItem();
        this.jSeparator5 = new javax.swing.JSeparator();
        this.jMenuItem14 = new javax.swing.JMenuItem();
        this.jSeparator6 = new javax.swing.JSeparator();
        this.jMenuItem15 = new javax.swing.JMenuItem();
        this.jSeparator7 = new javax.swing.JSeparator();
        this.jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAVA\u8bed\u8a00\u57fa\u7840");
        this.jLabel1.setFont(new java.awt.Font("Serif", 1, 12));
        this.jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        this.jLabel1.setText("\u4ee3\u7801\u67e5\u770b\u7a97\u53e3:");

        this.jTextArea1.setColumns(20);
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setFont(new java.awt.Font("Courier", 0, 15));
        this.jTextArea1.setRows(5);
        this.jScrollPane1.setViewportView(this.jTextArea1);

        this.jMenu1.setMnemonic('O');
        this.jMenu1.setText("\u64cd\u4f5c(O)");
        this.jMenuItem1.setMnemonic('X');
        this.jMenuItem1.setText("\u9000\u51fa(X)");
        this.jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        this.jMenu1.add(this.jMenuItem1);

        this.jMenuBar1.add(this.jMenu1);

        this.jMenu2.setMnemonic('S');
        this.jMenu2.setText("\u8bed\u6cd5\u57fa\u7840(S)");
        this.jMenuItem2.setMnemonic('T');
        this.jMenuItem2.setText("\u8fd0\u7b97\u7b26(T)");
        this.jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        this.jMenu2.add(this.jMenuItem2);

        this.jMenu2.add(this.jSeparator1);

        this.jMenuItem3.setMnemonic('J');
        this.jMenuItem3.setText("\u8df3\u8f6c\u8bed\u53e5(J)");
        this.jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        this.jMenu2.add(this.jMenuItem3);

        this.jMenuBar1.add(this.jMenu2);

        this.jMenu3.setMnemonic('C');
        this.jMenu3.setText("\u9762\u5411\u5bf9\u8c61(C)");
        this.jMenuItem4.setMnemonic('C');
        this.jMenuItem4.setText("\u7c7b\u57fa\u7840(C)");
        this.jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        this.jMenu3.add(this.jMenuItem4);

        this.jMenuItem5.setMnemonic('N');
        this.jMenuItem5.setText("\u5185\u90e8\u7c7b\u4e0e\u533f\u540d\u7c7b(N)");
        this.jMenu3.add(this.jMenuItem5);

        this.jMenu3.add(this.jSeparator2);

        this.jMenuItem6.setMnemonic('P');
        this.jMenuItem6.setText("\u63a5\u53e3\u4e0e\u5305(P)");
        this.jMenu3.add(this.jMenuItem6);

        this.jMenuBar1.add(this.jMenu3);

        this.jMenu4.setMnemonic('E');
        this.jMenu4.setText("\u5f02\u5e38\u5904\u7406(E)");
        this.jMenuItem7.setMnemonic('E');
        this.jMenuItem7.setText("\u5f02\u5e38\u5904\u7406(E)");
        this.jMenu4.add(this.jMenuItem7);

        this.jMenuBar1.add(this.jMenu4);

        this.jMenu5.setMnemonic('R');
        this.jMenu5.setText("\u53cd\u5c04(R)");
        this.jMenuItem8.setMnemonic('R');
        this.jMenuItem8.setText("\u53cd\u5c04(R)");
        this.jMenu5.add(this.jMenuItem8);

        this.jMenuBar1.add(this.jMenu5);

        this.jMenu6.setMnemonic('V');
        this.jMenu6.setText("\u6d41\u7c7b&\u7ebf\u7a0b&\u7ed3\u6784(V)");
        this.jMenuItem9.setMnemonic('S');
        this.jMenuItem9.setText("\u6d41\u7c7b(S)");
        this.jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });

        this.jMenu6.add(this.jMenuItem9);

        this.jMenuItem10.setMnemonic('T');
        this.jMenuItem10.setText("\u7ebf\u7a0b(T)");
        this.jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });

        this.jMenu6.add(this.jMenuItem10);

        this.jMenu6.add(this.jSeparator3);

        this.jMenuItem11.setMnemonic('F');
        this.jMenuItem11.setText("\u7ed3\u6784(F)");
        this.jMenu6.add(this.jMenuItem11);

        this.jMenuBar1.add(this.jMenu6);

        this.jMenu7.setText("\u9ad8\u7ea7\u5e94\u7528(H)");
        this.jMenuItem12.setMnemonic('I');
        this.jMenuItem12.setText("\u56fd\u9645\u5316\u548c\u672c\u5730\u5316(I)");
        this.jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });

        this.jMenu7.add(this.jMenuItem12);

        this.jMenu7.add(this.jSeparator4);

        this.jMenuItem13.setMnemonic('N');
        this.jMenuItem13.setText("\u7f51\u7edc\u7a0b\u5e8f(N)");
        this.jMenu7.add(this.jMenuItem13);

        this.jMenu7.add(this.jSeparator5);

        this.jMenuItem14.setMnemonic('M');
        this.jMenuItem14.setText("JavaMail(M)");
        this.jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });

        this.jMenu7.add(this.jMenuItem14);

        this.jMenu7.add(this.jSeparator6);

        this.jMenuItem15.setMnemonic('F');
        this.jMenuItem15.setText("\u6cdb\u5f62(F)");
        this.jMenu7.add(this.jMenuItem15);

        this.jMenu7.add(this.jSeparator7);

        this.jMenuItem16.setMnemonic('G');
        this.jMenuItem16.setText("\u83b7\u53d6XML\u6570\u636e(G)");
        this.jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });

        this.jMenu7.add(this.jMenuItem16);

        this.jMenuBar1.add(this.jMenu7);

        setJMenuBar(this.jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(this.jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(this.jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(this.jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(this.jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
// TODO 

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
    // TODO 
         this.jTextArea1.setText("");
        try{
        File file = new File("src/org/yoyudeng/JBasicSource/JGetXML.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
    }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
        if(this.flag6)
    {
        this.frm6 = new JGetXML();
        this.frm6.setVisible(true);
        this.flag6 = false;
    }
    else
    {
            this.frm6.setVisible(true);
            this.frm6.setExtendedState(NORMAL);
    }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
// TODO 
        this.jTextArea1.setText("");
        try{
        File file = new File("src/org/yoyudeng/JBasicSource/JJavaMail.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
    }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
        if(this.flag5)
    {
        this.frm5 = new JJavaMail();
        this.frm5.setVisible(true);
        this.flag5 = false;
    }
    else
    {
            this.frm5.setVisible(true);
            this.frm5.setExtendedState(NORMAL);
    }

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    // TODO 
        this.jTextArea1.setText("");
        try{
        File file = new File("src/org/yoyudeng/JBasicSource/JLocale.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
    }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
        if(this.flag4)
    {
        this.frm4 = new JLocale();
        this.frm4.setVisible(true);
        this.flag4 = false;
    }
    else
    {
            this.frm4.setVisible(true);
            this.frm4.setExtendedState(NORMAL);
    }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    // TODO 
        this.jTextArea1.setText("");
        try{
        File file = new File("src/org/yoyudeng/JBasicSource/JJump.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
    }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
        if(this.flag3)
    {
        this.frm3 = new JJump();
        this.frm3.setVisible(true);
        this.flag3 = false;
    }
    else
    {
            this.frm3.setVisible(true);
            this.frm3.setExtendedState(NORMAL);
    }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    this.jTextArea1.setText("");
    try{
        File file = new File("src/org/yoyudeng/JBasicSource/JOperator.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
    }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
    if(this.flag2)
    {
        this.frm2 = new JOperator();
        this.frm2.setVisible(true);
        this.flag2 = false;
    }
      else
    {
            this.frm2.setVisible(true);
            this.frm2.setExtendedState(NORMAL);
    }
   // TODO 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

    // TODO 
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
     this.jTextArea1.setText("");
     try{
         File file = new File("src/main/java/edu/frank/swing/framework/JBasicSource/AnimatorDemo.java");
         FileReader fr = new FileReader(file);
         this.jTextArea1.read(fr,null);
     }catch(Exception e){JOptionPane.showMessageDialog(this,",!");}
     if(this.flag1)
     {
         this.frm1 = new AnimatorDemo();
         this.frm1.setVisible(true);
         this.flag1 = false;
     }
      else
    {
            this.frm1.setVisible(true);
            this.frm1.setExtendedState(NORMAL);
    }
     // TODO 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    if(!this.flag1) {
		this.frm1.dispose();
	}
    if(!this.flag2) {
		this.frm2.dispose();
	}
    if(!this.flag3) {
		this.frm3.dispose();
	}
    if(!this.flag4) {
		this.frm4.dispose();
	}
    if(!this.flag5) {
		this.frm5.dispose();
	}
    if(!this.flag6) {
		this.frm6.dispose();
	}
    JSwingMain frm = new JSwingMain();
    frm.setVisible(true);
    dispose();
    // TODO 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JBasic().setVisible(true);
            }
        });
    }

    //  - //GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextArea jTextArea1;
    // //GEN-END:variables
   private int m_height,m_width;
   private Toolkit toolkit =getToolkit();
   AnimatorDemo frm1;
   JOperator frm2;
   JJump frm3;
   JLocale frm4;
   JJavaMail frm5;
   JGetXML frm6;
   boolean flag1,flag2,flag3,flag4,flag5,flag6;
}