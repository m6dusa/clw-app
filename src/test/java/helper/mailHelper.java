package helper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import org.testng.Assert;

import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mailHelper {

            static String hostval = "pop.gmail.com";
        //for Google
        public static String getResetPasswordLink(String uname, String pwd) {
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
                Assert.assertEquals(indvidualmsg.getSubject(), "Reset Password");
                   MimeMultipart mmp = (MimeMultipart) indvidualmsg.getContent();
                        MimeBodyPart part = mmp.getBodyPart(0);
                            Pattern p = Pattern.compile("(https.*app-dev.classwallet([^>])*)+");
                            Matcher m = p.matcher((String)(part.getContent()));
                            System.out.println(m.find());
                            System.out.println(m.start() + " "+ m.end());
                            System.out.println(((String)(part.getContent())).substring(m.start(), m.end()));

                emailFolderObj.close(false);
                storeObj.close();
                return ((String)(part.getContent())).substring(m.start(), m.end());
            } catch (NoSuchProviderException exp) {
                exp.printStackTrace();
                return null;
            } catch (MessagingException exp) {
                exp.printStackTrace();
                return null;
            } catch (Exception exp) {
                exp.printStackTrace();
                return null;
            }

        }
}


