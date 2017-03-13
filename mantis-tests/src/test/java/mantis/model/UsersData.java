package mantis.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Table(name = "mantis_user_table")
public class UsersData {

  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column(name = "username")
  @Type(type = "text")
  private String userName;

  @Expose
  @Column(name = "realname")
  @Type(type = "text")
  private String realName;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

//  setters
  public UsersData withId(int id) {
    this.id = id;
    return this;
  }

  public UsersData WithUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public UsersData withRealName(String realName) {
    this.realName = realName;
    return this;
  }

  public UsersData withEmail(String email) {
    this.email = email;
    return this;
  }

// getters
  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getRealName() {
    return realName;
  }

  public String getEmail() {
    return email;
  }

// toString
  @Override
  public String toString() {
    return "UsersData{" +
            "id=" + id +
            ", username='" + userName + '\'' +
            ", realname='" + realName + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  // equals
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UsersData usersData = (UsersData) o;

    if (id != usersData.id) return false;
    if (userName != null ? !userName.equals(usersData.userName) : usersData.userName != null) return false;
    if (realName != null ? !realName.equals(usersData.realName) : usersData.realName != null) return false;
    return email != null ? email.equals(usersData.email) : usersData.email == null;
  }

  // hashCode
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userName != null ? userName.hashCode() : 0);
    result = 31 * result + (realName != null ? realName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}