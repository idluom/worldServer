package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Newsletter;

/**
 * Session Bean implementation class NewsletterEJB
 */
@Stateless
@LocalBean
public class NewsletterEJB implements NewsletterEJBRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public NewsletterEJB() {
        
    }

	@Override
	public void addUserToList(Newsletter user) {
		em.persist(user);
	}

	@Override
	public List<Newsletter> getMailingList() {
		return em.createQuery("select m from Newsletter", Newsletter.class).getResultList();
	}

}
