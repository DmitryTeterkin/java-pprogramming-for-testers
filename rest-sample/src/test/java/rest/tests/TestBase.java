package rest.tests;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;
import rest.appmanager.ApplicationManager;
import rest.model.Issue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager();
  String status = "";


  boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException{
    String json = RestAssured.get("http://demo.bugify.com/api/issues/" + issueId + ".json").getBody().asString();
    JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
    JsonArray issues = parsed.getAsJsonArray("issues");
    for (JsonElement state_name : issues) {
      JsonObject statuses = state_name.getAsJsonObject();
      status = statuses.get("state_name").toString().replaceAll("\"", "");
      System.out.println("Статус задачи - " + status); // выводим имя статуса задачи.
    }
    return !status.equals("Resolved");
  }

  
  public void skipIfNotFixed(int issueId) throws RemoteException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }


  public Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
  }


  public int createIssue(Issue newIssue) throws IOException {

    String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return  parsed.getAsJsonObject().get("issue_id").getAsInt();
  }


  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }


  public Set<Issue> getIssuesWithRestAssured() throws IOException {
    String json =  RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }


  public int createIssueWithRestAssured(Issue newIssue) throws IOException {
    String json =  RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("http://demo.bugify.com/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return  parsed.getAsJsonObject().get("issue_id").getAsInt();
  }


  public int createIssueWithRestAssured1testdlaAppmanager(Issue newIssue) throws IOException {
    String json =  RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post(System.getProperty("Path")).asString();
    JsonElement parsed = new JsonParser().parse(json);
    return  parsed.getAsJsonObject().get("issue_id").getAsInt();
  }


}
