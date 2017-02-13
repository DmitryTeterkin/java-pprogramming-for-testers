package addressbook.model;

public class ContactData {
  private final String id;
  private final String firstName;
  private final String secondName;
  private final String nickName;
  private final String group;
  private final String address;
  private final String email;
  // конструктор без ID
  public ContactData(String firstName, String secondName, String nickName, String address, String email, String group) {
    this.id = null;
    this.firstName = firstName;
    this.secondName = secondName;
    this.nickName = nickName;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public ContactData(String id, String firstName, String secondName, String nickName, String address, String email, String group) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.nickName = nickName;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return secondName != null ? secondName.equals(that.secondName) : that.secondName == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
    return result;
  }
}
