package edu.frank.swing.framework.JBasicSource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

public class SendMail extends JFrame implements ActionListener {
	private String host;       //
	private String username;   //
	private String password;   //
	private String from;       //
	private String to;         //
	private String subject;    //
	private String body;       //
        private int m_height,m_width;
        private Toolkit toolkit =getToolkit();

	private JLabel labels[] = new JLabel[6];
	private JTextField textFields[] = new JTextField[6];
	private JTextArea content;
	private JButton send,cancel,exit;
    private JPanel buttonPanel, messagePanel, msgPanel, msgPanel2;

    private static final String labelNames[] = {"Host Address:",
    	     "User Name:", "PassWord:", "From:", "To:", "Subject:"};

	public SendMail()
	{
		super("Send Mail");
                setSize(400,400);

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
		for(int i = 0; i < labelNames.length; i++){
		   labels[i] = new JLabel(labelNames[i], SwingConstants.RIGHT);
		   labels[i].setOpaque(true);
		   labels[i].setBackground(new Color(200, 255, 255));

		   textFields[i] = new JTextField(20);
		}
		textFields[2] = new JPasswordField(20);
		content = new JTextArea(30, 30);
		content.setFont(new Font("Serif", Font.PLAIN, 14));
		content.setLineWrap(true);
		content.setWrapStyleWord(true);

		//,
		send= new JButton("Send");
		cancel = new JButton("Cancel");
                exit = new JButton("Exit");
		send.addActionListener(this);
		cancel.addActionListener(this);
                exit.addActionListener(this);

        //
		msgPanel = new JPanel(new GridLayout(6,1));
		msgPanel2 = new JPanel(new GridLayout(6,1));
		msgPanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
		msgPanel2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
		for(int i = 0; i < labels.length; i++)
		{
			msgPanel.add(labels[i]);
			msgPanel2.add(textFields[i]);
		}
        messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(200,255,255)));
        buttonPanel = new JPanel(new GridLayout(1,2,5,5));

        //
        buttonPanel.add(send);
        buttonPanel.add(cancel);
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
		SendMail demo = new SendMail();
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == cancel)
		{
			body = "";
			content.setText("");
		}
		else if(event.getSource() == send)
		{
			host = textFields[0].getText().trim();
			username = textFields[1].getText().trim();
			password = new String(((JPasswordField)textFields[2]).getPassword());
			from = textFields[3].getText().trim();
			to = textFields[4].getText().trim();
			subject = textFields[5].getText().trim();
			body = content.getText().trim();
			send();
		}
                else if(event.getSource() == exit)
                {
                    dispose();

                }
	}

	//
	private void send()
	{
		Properties props;
		Session sendMailSession;
		Message newMessage;
	    Transport transport;
		try
		{
			props = new Properties();
			sendMailSession = Session.getInstance(props, null);
			props.put("mail.smtp.host", host);
			//
			newMessage = new MimeMessage(sendMailSession);
			//
			newMessage.setFrom(new InternetAddress(from));
			newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress (to));
			newMessage.setSubject(subject);
			newMessage.setSentDate(new Date());
			newMessage.setText(body);
			//
			transport = sendMailSession.getTransport("smtp");
			transport.connect(host, username, password);
			Transport.send(newMessage);
		}
		catch(MessagingException me)
		{
			me.printStackTrace(System.out);
		}
	}
}