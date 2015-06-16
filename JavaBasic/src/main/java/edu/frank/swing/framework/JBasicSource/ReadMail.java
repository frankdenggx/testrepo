package edu.frank.swing.framework.JBasicSource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ReadMail extends JFrame implements ActionListener {
	private String smtphost;   //
	private String username;   //
	private String password;   //
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	private JLabel labels[] = new JLabel[3];
	private JTextField textFields[] = new JTextField[3];
	private JTextArea content;
	private JButton get,exit;

	private JPanel msgPanel, msgPanel2, messagePanel, buttonPanel;

	private static final String labelNames[] = {"Host Address:","User Name:", "PassWord:"};

	public ReadMail()
	{
		super("Read Mail");
                setSize(500,300);

		//
		Container container = getContentPane();

                //
        m_width = getWidth();
        m_height = getHeight();
        int x = (toolkit.getScreenSize().width-m_width)/2;
        int y = (toolkit.getScreenSize().height-m_height)/2;
        this.setBounds(x,y,m_width,m_height);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		//,
		for(int i = 0; i < labels.length; i++)
		{
			labels[i] = new JLabel(labelNames[i], SwingConstants.RIGHT);
			labels[i].setOpaque(true);
			labels[i].setBackground(new Color(200, 255, 255)); //

			textFields[i] = new JTextField(20);
		}
		//
		textFields[2] = new JPasswordField(20);

		content = new JTextArea(30, 30);
		content.setFont(new Font("Serif", Font.PLAIN, 14));
		content.setLineWrap(true);
		content.setWrapStyleWord(true);

		//,
		get= new JButton("Get");
                exit = new JButton("Exit");
		get.addActionListener(this);
                exit.addActionListener(this);


        //
		msgPanel = new JPanel(new GridLayout(3,1));
		msgPanel2 = new JPanel(new GridLayout(3,1));
		msgPanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
		msgPanel2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
		for(int i = 0; i < labels.length; i++)
		{
			msgPanel.add(labels[i]);
			msgPanel2.add(textFields[i]);
		}
        messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
        buttonPanel = new JPanel();

        //
        buttonPanel.add(get);
        buttonPanel.add(exit);
        messagePanel.add(msgPanel, BorderLayout.WEST);
        messagePanel.add(msgPanel2, BorderLayout.CENTER);

        container.add(messagePanel, BorderLayout.NORTH);
        container.add(new JScrollPane(content), BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	setVisible(true);
	}

	public static void main(String[] args)
	{
		ReadMail demo = new ReadMail();
	}
    //
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == get)
		{
			smtphost = textFields[0].getText().trim();
			username = textFields[1].getText().trim();
			password = new String(((JPasswordField)textFields[2]).getPassword());
			getMail();
		}
                else if(event.getSource() == exit)
                {
                    dispose();
                }
	}

	//
	private void getMail()
	{
		//
		Properties props = new Properties();
		//Session
		Session session = Session.getDefaultInstance(props, null);
		try
		{
			//Store
		    Store store = session.getStore("pop3");
		    store.connect(smtphost, username, password);
		    //
		    Folder folder = store.getFolder("inbox");
		    folder.open(Folder.READ_ONLY);
		    //
		    Message message[] = folder.getMessages();
		    for(int i = 0; i < message.length; i++){
		    	content.append((i+1) + ": " + message[i].getFrom()[0] + "\n");
		    	content.append(message[i].getSubject() + "\n");
		    	content.append(message[i].getContent().toString());
		    }
		}
		catch(MessagingException me)
		{
			me.printStackTrace(System.out);
		}
		catch(IOException ie){
			ie.printStackTrace(System.out);
		}
	}
}