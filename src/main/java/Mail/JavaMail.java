package Mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class JavaMail {

    private static Properties setProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",  "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "mail.gmx.net");
        properties.put("mail.smtp.port", "587");

        return properties;
    }

    private static String myAccount = "instrumentenverleih@gmx.de";
    private static String myPassword = "MarslStinktNachMaggi";

    public static void sendTicketConformationMail(String empfaenger, String instrument, String vorname) {

        Properties properties = setProperties();

        empfaenger.trim();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, myPassword);
            }
        });

        // Message-Objekt erzeugen und senden!

        Message message = Ausleihbestätigung.prepareMessage(session, myAccount, empfaenger, instrument, vorname);
        try {
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		} // E-Mail senden!
    }

    /*
    public static void sendMailAdressConformationLink(String empfaenger, String conformationLink) throws MessagingException {
        Properties properties = setProperties();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, myPassword);
            }
        });

        // Message-Objekt erzeugen und senden!

        Message message = MailBestätigen.prepareMessag(session, myAccount, empfaenger);
        Transport.send(message); // E-Mail senden!
    }

     */
}
