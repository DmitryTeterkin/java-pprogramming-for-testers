package addressbook.appmanager;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by dteterkin on 26.01.2017.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  // возврат на список групп
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  // подтверждение создания группы
  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  // заполнение группы
  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  // создание новой группы
  public void initGroupCreation() {
    click(By.name("new"));
  }

  // удаление выбранных групп
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  // выбор группы
  public void selectGroup() {
    click(By.name("selected[]"));
  }

  // нажатие кнопки редактирования группы
  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }
}
