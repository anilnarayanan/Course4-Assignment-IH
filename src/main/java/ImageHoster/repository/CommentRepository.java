package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class CommentRepository {

  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  public void addComment(Comment newComment) {
    System.out.println(
        newComment.getText()
            + "\n"
            + newComment.getCreatedDate()
            + "\n"
            + newComment.getImage().getTitle()
            + "\n"
            + newComment.getUser().getUsername());
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
      transaction.begin();
      em.persist(newComment);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    }
  }
}
