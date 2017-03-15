package mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static mantis.tests.TestBase.app;


public class ApplicationManager {

  private final Properties properties;
  WebDriver wd;

  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper MailHelper;
  private UserHelper UserHelper;
  private DbHelper dbHelper;
  private NavigationHelper NavigationHelper;
  private HttpSession HttpSession;
  private JamesHelper jamesHelper;
  private SoapHelper soapHelper;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
    NavigationHelper = new NavigationHelper(app);

  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public HttpSession newSession(){
    if (HttpSession == null) {
      return new HttpSession(this);
    }
    return HttpSession;
  }

  public String getProperty(String key){
  return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public FtpHelper ftp(){
   if (ftp == null) {
     ftp = new FtpHelper(this);
   }
   return ftp;
  }

  public MailHelper mail() {
    if (MailHelper == null) {
      MailHelper = new MailHelper(this);
    }
    return MailHelper;
  }
  public UserHelper user() {
    if (UserHelper == null){
      UserHelper = new UserHelper(this);
    }
    return UserHelper;
  }

  public NavigationHelper goTo() {
    if (NavigationHelper == null)
    {
      NavigationHelper = new NavigationHelper(this);
    }
    return NavigationHelper;
  }

  public DbHelper db (){
    return dbHelper;
  }

  public WebDriver getDriver() {
    if (wd == null){
      if (Objects.equals(browser, BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (Objects.equals(browser, BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (Objects.equals(browser, BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

  public JamesHelper james() {
    if (jamesHelper == null){
      jamesHelper = new JamesHelper(this);
    }
    return jamesHelper;
  }

  public SoapHelper soap(){

    if (soapHelper == null){
      soapHelper = new SoapHelper(this);
    }
    return soapHelper;
  }

}
