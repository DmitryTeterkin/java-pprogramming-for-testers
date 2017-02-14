package addressbook.appmanager;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


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
  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click(); // выбираем по какому элементу (номеру элемента) нам нужно кликнуть
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
  public void modify(int index, GroupData group) {
    selectGroup(index);// выбираем для модификации последнюю группу
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  // метод удаления группы
  public void delete(int index) {
    selectGroup(index); // выбираем для удаления последнюю группу
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

  // метод получения списка групп через множество
  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();                              // определяем множество элементов
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));        // заполняем его по цсс
    for (WebElement element : elements) {                                             // создаем цикл прохода по всем элементам
    String name = element.getText();     // из каждого элемента получаем текст - имя группы
    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
    GroupData group = new GroupData(id, name, null, null);                                                    // создаем объект типа групдата
    groups.add (group);                                                                                                 //добавляем созданный объект в список
    }
    return groups;
  }
}
