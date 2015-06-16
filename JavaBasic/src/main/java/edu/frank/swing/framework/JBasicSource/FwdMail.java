package edu.frank.swing.framework.JBasicSource;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class FwdMail
{
	public static void main(String[] args)
	{
		//
		Properties props = new Properties();
		//
		Session session = Session.getInstance(props, null);

		//
		Message message = new MimeMessage(session);

		//
		Message forward = new MimeMessage(session);
		try
		{
			//
		    forward.setSubject(": " + message.getSubject());
		    forward.setFrom(new InternetAddress("xxx@somenet.com"));
		    forward.addRecipient(Message.RecipientType.TO,
		    		                           new InternetAddress("yyy@anothernet.com"));
            //
			Multipart multipart = new MimeMultipart();
		    //
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("original message:\n");
			//
			multipart.addBodyPart(messageBodyPart);
			//
			messageBodyPart = new MimeBodyPart();
		      //messageBodyPart.setDataHandler(message.getDataHandler());
			//
			multipart.addBodyPart(messageBodyPart);

			forward.setContent(multipart);

            //
			Transport.send(forward);

		}
		catch(MessagingException me)
		{
			me.printStackTrace(System.out);
		}
	}
}