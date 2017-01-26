package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by dteterkin on 26.01.2017.
 */
public class TestBase {


  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
