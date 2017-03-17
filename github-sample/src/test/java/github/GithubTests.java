package github;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

@Test
  public void testCommits() throws IOException {
  Github github = new RtGithub("63593e9179115ff417b13e500ebf5e6b5ccf60e6");
  RepoCommits commits = github.repos().get(new Coordinates.Simple("DmitryTeterkin", "java-programming-for-testers")).commits();
  for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
    System.out.println(new RepoCommit.Smart(commit).message());
  }
}


}
