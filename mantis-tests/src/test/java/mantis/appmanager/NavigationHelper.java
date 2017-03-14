package mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class navigationHelper extends HelperBase {

  public navigationHelper(ApplicationManager app) {
    super(app);
  }

  public void resetUserPassword(String adminname, String password, String username) {
    String loginlink = app.getProperty("web.baseUrl") + "/login_page.php";
    System.out.println(loginlink);
    wd.get(loginlink);
    type(By.name("username"), adminname);
    type(By.name("password"), password);
    wd.findElement(By.cssSelector("input[type = 'submit']")).click();   //By.xpath(".//*[@id='resetUserPassword-form']/fieldset/input[2]")).click();
    wd.findElement(By.xpath(".//div[@id='sidebar']/ul/li[6]/a/i")).click();
    wd.findElement(By.xpath(".//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a")).click();
    wd.findElement(By.linkText(username)).click();
    wd.findElement(By.xpath(".//*[@id='manage-user-reset-form']/fieldset/span/input")).click();
  }

  public void loginWithNewPassword(String link, String username, String password) {
    wd.get(link);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    wd.findElement(By.xpath(".//*[@id='account-update-form']/fieldset/span/button")).click();
  }

}
