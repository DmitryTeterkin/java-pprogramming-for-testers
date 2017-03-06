package addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  // пременные
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName = "";

  @Expose
  @Column(name = "lastname")
  private String secondName = "";

  @Transient
  private String nickName = "";

  @Expose
  @Transient
  private String group = "[none]"; // or transient before private

  @Column(name = "address")
  @Type(type = "text")
  private String address = "";

  @Column(name = "email")
  @Type(type = "text")
  private String email = "";

  @Column(name = "email2")
  @Type(type = "text")
  private String email2 = "";

  @Column(name = "email3")
  @Type(type = "text")
  private String email3 = "";

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone = "";

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone = "";

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone = "";

  @Transient
  private String allPhones = "";

  @Transient
  private String allEmales = "";

  @Transient
  private String Information;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo = null;


  // setters
  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withSecondName(String secondName) {
    this.secondName = secondName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAllEmales(String allEmales) {
    this.allEmales = allEmales;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withInformation(String information) {
    Information = information;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  // getters
  public int getId() {
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

  public String getAllEmales() {
    return allEmales;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getInformation() {
    return Information;
  }

  public File getPhoto() {
    return new File(photo);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", group='" + group + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmales='" + allEmales + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    return allEmales != null ? allEmales.equals(that.allEmales) : that.allEmales == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allEmales != null ? allEmales.hashCode() : 0);
    return result;
  }
}
