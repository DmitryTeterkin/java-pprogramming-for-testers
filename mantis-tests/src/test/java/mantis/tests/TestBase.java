package mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;


public class TestBase {


  public static final ApplicationManager  app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php", "config_inc.php.bak");

  }


  boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException, ServiceException {
    MantisConnectPortType mc = new MantisConnectLocator().getMantisConnectPort(new URL(app.getProperty("mantis.connectUrl")));;
    IssueData issue = mc.mc_issue_get(app.getProperty("mantis.adminLogin"), app.getProperty("mantis.adminPassword"), BigInteger.valueOf(issueId));
    System.out.println("Статус задачи - " + issue.getStatus().getName()); // выводим имя статуса задачи.
    return !issue.getStatus().getName().equals("resolved"); // возвращаем true если у задачи любой статус кроме "решена" - тогда пропускаем тесты.
  }


  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }


  @AfterSuite (alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }


}
