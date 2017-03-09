package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Member;

/**
 * Session Bean implementation class MemberEJB
 */
@Stateless
@LocalBean
public class MemberEJB implements MemberEJBRemote {
	
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public MemberEJB() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public Member authentication(String username, String password) {
		
		try {
			return em.createQuery("SELECT m FROM Member m WHERE m.login = ?1 AND m.password= ?2", Member.class)
					.setParameter(1, username).setParameter(2, password).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

}
