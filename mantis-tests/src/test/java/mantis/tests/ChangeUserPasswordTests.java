package mantis.tests;

import mantis.model.MailMessage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import mantis.model.UsersData;
import mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangeUserPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
      String newpassword = "newpassword";
      String username = app.getProperty("web.adminLogin");
      String password = app.getProperty("web.adminPassword");
      Users users = app.db().users();
      app.goTo().loginPage(username, password);
      app.goTo().UsersManagmentPage();
      //Users users = app.db().users();
      UsersData user = users.iterator().next();
      app.goTo().resetUserPassword(user.getUserName());
      List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
      String LFCP = linkForCleanPassword(mailMessages);
      boolean newLogin = app.newSession().loginByLink(LFCP, user.getUserName(), newpassword);
      assertTrue(newLogin);
    }

    private String linkForCleanPassword(List<MailMessage> mailMessages) {
      MailMessage mailMessage = mailMessages.stream().findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
      app.mail().stop();
    }

}