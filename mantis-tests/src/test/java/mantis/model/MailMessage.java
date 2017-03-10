package mantis.model;

/**
 * Created by dteterkin on 10.03.2017.
 */
public class MailMessage {
  public String to;
  public String text;

  public MailMessage (String to, String text){
    this.to = to;
    this.text = text;
  }
}
