package rest.tests;


import com.jayway.restassured.RestAssured;
import rest.model.Issue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase {

  @BeforeClass
  public void init() {
   RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }


  @Test

  public void testCreateIssue() throws IOException {
    skipIfNotFixed(1);
    Set<Issue> oldIssues = getIssuesWithRestAssured();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssueWithRestAssured(newIssue);
    Set<Issue> newIssues = getIssuesWithRestAssured();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

}
