package appModules;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import utility.Constant;
import utility.ExcelUtils;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Sendmail
{  
   
	public static void  send() throws Exception{
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_SendMail,"Sheet1");
		
	    String TO = ExcelUtils.getCellData(Constant.mail_ID_Row,Constant.to);
      // Recipient's email ID needs to be mentioned.
      String to = TO;
     
       final String username = ExcelUtils.getCellData(Constant.mail_ID_Row,Constant.from);
     
       final String password = ExcelUtils.getCellData(Constant.mail_ID_Row,Constant.pass);
      Properties props = new Properties();
      props.put("mail.smtp.auth", true);
      props.put("mail.smtp.starttls.enable", true);
      props.put("mail.smtp.host", "smtp-mail.outlook.com");
      props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
                  }
              });
      try{
    	  
    	//  String percentage = sendmail1.percentage().getText();
    	  
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session );
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(username));
         // Set To: header field of the header.
     //    message.addRecipient(Message.RecipientType.TO,new InternetAddress("manishajadhav740@gmail.com, manisha.vtest@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
         // Set Subject: header field
         String subject = ExcelUtils.getCellData(Constant.mail_ID_Row,Constant.subject); 
         
	     Date date = new Date();
	     String dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
	
         message.setSubject(subject +" "+ dateFormat );
        
         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();
         // Fill the message
         messageBodyPart.setText("Hi,\n Below attached is the Test Report \n\n\n Regards, \n manisha.vtest");
 
         messageBodyPart.setText("<Html> <head>"+ "<title>This is not usually displayed</title>"+"</head>n"+"<body><div><strong>Hi there!</strong></div>"+"</body></html>"+"US-ASCII"+ "html");
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
        /* messageBodyPart = new MimeBodyPart();
         String filename = "Integra\\RESULT_OUTPUT\\Result.xls";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);*/
         
      //  addAttachment(multipart, "src\\Screenshots\\Result.jpg");
       // addAttachment(multipart, "src\\Screenshots\\Result1.png");
       addAttachment(multipart, "E:\\Workspace\\flightSpeak\\testng-xslt\\index.html");

         // Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
       
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
   
   
   private static void addAttachment(Multipart multipart, String filename) throws MessagingException
   {
       DataSource source = new FileDataSource(filename);
       BodyPart messageBodyPart = new MimeBodyPart();        
       messageBodyPart.setDataHandler(new DataHandler(source));
       messageBodyPart.setFileName(filename);
       multipart.addBodyPart(messageBodyPart);
   }
   
  
}