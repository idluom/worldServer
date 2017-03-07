package Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Track;
/**
 * Session Bean implementation class TrackEJB
 */
@Stateless
public class TrackEJB implements TrackEJBRemote{
	@PersistenceContext(unitName="skiworld-ejb") // persistance.xml src/main/resources
	EntityManager em;
    /**
     * Default constructor. 
     */
    public TrackEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addTrack(Track t) {
		em.persist(t);
	}
	
	

}
