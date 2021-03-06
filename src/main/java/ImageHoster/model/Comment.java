package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "comment")
public class Comment {

  @SuppressWarnings("JpaDataSourceORMInspection")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column(name = "text")
  private String text;

  @Column(name = "createdDate")
  private LocalDate createdDate;

//  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//   CascadeType.REFRESH}, fetch = FetchType.EAGER)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

//  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//   CascadeType.REFRESH}, fetch = FetchType.EAGER)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "image_id")
  private Image image;

  public Comment() {}

  public Comment(String text, LocalDate createdDate, User user, Image image) {
    this.text = text;
    this.createdDate = createdDate;
    this.user = user;
    this.image = image;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
