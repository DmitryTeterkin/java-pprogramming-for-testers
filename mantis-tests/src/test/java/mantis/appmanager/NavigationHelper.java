package mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }
  public void loginPage(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.xpath(".//*[@id='loginPage-form']/fieldset/input[2]"));
  }

  public void UsersManagmentPage() {
  wd.findElement(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i")).click();
    wd.findElement(By.xpath(".//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a")).click();
 // wd.findElement(By.linkText("Управление пользователями")).click();
  }

  public void resetUserPassword(String username) {
    wd.findElement(By.linkText(username)).click();
    wd.findElement(By.xpath(".//*[@id='manage-user-reset-form']/fieldset/span/input")).click();
  }
}
