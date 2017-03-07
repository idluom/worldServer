package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Admin;

/**
 * Session Bean implementation class AdminEJB
 */
@Stateless
@LocalBean
public class AdminEJB implements AdminEJBRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AdminEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAdmin(Admin a) {
		em.persist(a);
		
	}

	@Override
	public void updateAdmin(Admin a) {
		em.merge(a);
	}

	@Override
	public void deleteAdmin(Admin a) {
		em.remove(em.merge(a));
	}

	@Override
	public boolean deleteAdmin(int a) {
		try {
			em.remove(a);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
