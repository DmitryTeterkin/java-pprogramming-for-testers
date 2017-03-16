package model;


public class Issue {

  private int id;
  private String subject;
  private String description;

// setters
  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }
  // getters
  public int getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

}
