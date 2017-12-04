package helper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mailHelper {

        public static void main(String[] args) {
            //Set mail properties and configure accordingly
            String hostval = "pop.gmail.com";
            String mailStrProt = "pop3";
            String uname = "anothertestteacher@gmail.com";
            String pwd = "passwordqwerty";
            // Calling checkMail method to check received emails
            checkMail(hostval, uname, pwd);
        }
        public static void checkMail(String hostval, String uname,String pwd) {
            try {
                //Set property values
                Properties propvals = new Properties();
                propvals.put("mail.pop3.host", hostval);
                propvals.put("mail.pop3.port", "995");
                propvals.put("mail.pop3.starttls.enable", "true");
                Session emailSessionObj = Session.getDefaultInstance(propvals);
                //Create POP3 store object and connect with the server
                Store storeObj = emailSessionObj.getStore("pop3s");
                storeObj.connect(hostval, uname, pwd);
                //Create folder object and open it in read-only mode
                Folder emailFolderObj = storeObj.getFolder("INBOX");
                emailFolderObj.open(Folder.READ_ONLY);
                //Fetch messages from the folder and print in a loop
                Message[] messageobjs = emailFolderObj.getMessages();


                    Message indvidualmsg = messageobjs[messageobjs.length-1];
                    //System.out.println("Printing individual messages");

                    //System.out.println("Date " + indvidualmsg.getSentDate());
//                    System.out.println("Email Subject: " + indvidualmsg.getSubject());
//                    System.out.println("Sender: " + indvidualmsg.getFrom()[0]);
//                    System.out.println("Content: " + indvidualmsg.getContent().toString());
                   javax.mail.internet.MimeMultipart mmp = (javax.mail.internet.MimeMultipart) indvidualmsg.getContent();
                    for (int d = 0, s = mmp.getCount(); d < s; d++) {
                        Part part = mmp.getBodyPart(d);
                        if (mmp.getContentType().contains("image/")) {
                            break;
                        } else {
                            Pattern p = Pattern.compile("(https.*app-dev.classwallet([^>])*)+");
                            Matcher m = p.matcher(getText(part));
                            System.out.println(m.find(1));
                            System.out.println(m.start() + " "+ m.end());
                            System.out.println(getText(part).substring(m.start(), m.end()));



                        }

                    }



                //Now close all the objects
                emailFolderObj.close(false);
                storeObj.close();
            } catch (NoSuchProviderException exp) {
                exp.printStackTrace();
            } catch (MessagingException exp) {
                exp.printStackTrace();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }


    private static String getText(Part p) throws
            MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            String s = (String)p.getContent();
            boolean textIsHtml = p.isMimeType("text/html");
            return s;
        }else if(p.isMimeType("image/")){return null;}
        else{return null;}
    }
}


