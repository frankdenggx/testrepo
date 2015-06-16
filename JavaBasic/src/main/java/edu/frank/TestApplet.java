package edu.frank;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

import netscape.javascript.JSObject;

public class TestApplet extends JApplet{
	int size = 1;
	  JTextField inpText=new JTextField(2);
	  private static final long serialVersionUID = 1L;
	  public TestApplet() throws HeadlessException {
	  }
	  
	  public void init() {
	    JPanel p1=new JPanel();
	    p1.setBackground(new Color(0xFFFFFF));
	    this.getContentPane().add(p1);
	    inpText.setText(String.valueOf(size));
	    JButton btn=new JButton("exe");
	    btn.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            execute();
	        }
	    });
	    p1.add(new JTextArea("size : "));
	    p1.add(inpText);
	    p1.add(new JTextArea("M  "));
	    p1.add(btn);

	  }

	  public void execute() {
	        JSObject win = JSObject.getWindow(this);
	        int sizeWrite = Integer.valueOf(inpText.getText()).intValue();

	        size = sizeWrite * 1048576;
	        StringBuffer stringBuffer = new StringBuffer(size);
	        for (int i1 = 0; i1 < size; i1++) {
	          stringBuffer.append('a');
	        }
	        System.out.println("Write size : " + size +" byte");
	        System.out.println("Start : " + new Date());
	        win.call("setResultXml", new Object[]{stringBuffer.toString()});
	        System.out.println("Done  : " + new Date());
	  }
}