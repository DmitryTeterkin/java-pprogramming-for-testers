package addressbook.appmanager;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

   // выбор группы по Id
  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); // выбираем по какому элементу (номеру элемента) нам нужно кликнуть
  }
  // нажатие кнопки редактирования группы
  public void initGroupModification() {
    click(By.name("edit"));
  }

  // подтверждение изменения группы
  public void submitGroupModification() {
    click(By.name("update"));
  }

  // метод создания группы
  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  // метод модификации группы
  public void modify(GroupData group) {
    selectGroupById(group.getId());// выбираем для модификации последнюю группу
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  // метод удаления группы (новый)
  public void delete(GroupData group) {
    selectGroupById(group.getId()); // выбираем для удаления последнюю группу
    deleteSelectedGroups();
    returnToGroupPage();
  }

// метод который определяет, есть ли группа по чекбоксу
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  // метод, который считает количество групп по количеству чекбоксов
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

 // метод, который возвращает множество
  public Groups all() {
    Groups groups = new Groups();                              // определяем множество элементов
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));        // заполняем его по цсс
    for (WebElement element : elements) {                                             // создаем цикл прохода по всем элементам
      String name = element.getText();     // из каждого элемента получаем текст - имя группы
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add (new GroupData().withId(id).withName(name));  // создаем объект типа групдата добавляем созданный объект в список
    }
    return groups;
  }
}
