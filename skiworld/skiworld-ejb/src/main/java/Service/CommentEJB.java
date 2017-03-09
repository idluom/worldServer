package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Comment;

/**
 * Session Bean implementation class CommentEJB
 */
@Stateless
public class CommentEJB implements CommentEJBRemote {

	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CommentEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deleteComment(Comment comment) {
		
		em.remove(em.merge(comment));
	}

	@Override
	public Comment findCommentById(Long id) {
		
		return em.find(Comment.class, id);
	}

	@Override
	public void addComment(Comment comment) {
		em.persist(comment);
	}

	@Override
	public List<Comment> findAllComments() {
		
		return em.createQuery("SELECT c FROM Comment c",Comment.class).getResultList();
	}

}
