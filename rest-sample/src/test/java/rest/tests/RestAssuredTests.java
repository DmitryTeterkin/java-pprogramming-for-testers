package rest.tests.tests;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import rest.tests.model.Issue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests {

  @BeforeClass
  public void init() {
   RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }


  @Test

  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssuesWithRestAssured();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssueWithRestAssured(newIssue);
    Set<Issue> newIssues = getIssuesWithRestAssured();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }


  private Set<Issue> getIssuesWithRestAssured() throws IOException {
    String json =  RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());        // тут точка останова, чтобы проверить как работает.
  }


  private int createIssueWithRestAssured(Issue newIssue) throws IOException {
    String json =  RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return  parsed.getAsJsonObject().get("issue_id").getAsInt();

  }

}
