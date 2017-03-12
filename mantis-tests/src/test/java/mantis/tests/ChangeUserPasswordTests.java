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
    public void startMailServer() {
      app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
      String newpassword = "newpassword";
      String username = app.getProperty("web.adminLogin");
      String password = app.getProperty("web.adminPassword");
      app.user().login(username, password);
      app.user().gotoUsersManagmentPage();
      Users users = app.db().users();
      UsersData user = users.iterator().next();
      app.user().resetUserPassword(user.getId());
      List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
      String resetLink = findResetLink(mailMessages);
      app.registration().finish(user.getRealName(), resetLink, newpassword);
      assertTrue(app.newSession().login(user.getUserName(), newpassword));

    }

    private String findResetLink(List<MailMessage> mailMessages) {
      MailMessage mailMessage = mailMessages.stream().findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
      app.mail().stop();
    }

}