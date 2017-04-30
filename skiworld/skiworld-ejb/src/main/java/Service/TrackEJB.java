package Service;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entity.Track;

/**
 * Session Bean implementation class TrackEJB
 */
@Stateless
@LocalBean
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
	@Override
	public void deleteTrack(Track t) {
		em.remove(em.merge(t));
	}
	@Override
	public void updateTrack(Track t) {
		em.merge(t);
	}
	@Override
	public Track findTrackById(Long idTrack) {
		return em.find(Track.class, idTrack);
		
	}
	
	@Override
	public List<Track> findAll() {
		return em.createQuery("select p from Track p ",Track.class).getResultList();
	}
	@Override
	public Track findTrackByDiff(String diff) {
		
		return em.createQuery("select p from Track p where p.difficulty=?1",Track.class).setParameter(1,diff).getSingleResult();
	}
	@Override
	public byte[] findPictureByTrackTitle(String trackTitle) {
		byte[] picture = null;
		
		TypedQuery<byte[]> query = em.createQuery("select p.image from Track p where p.title=:x", byte[].class);
		query.setParameter("x", trackTitle);
		try {
			picture = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no picture");
		}
		return picture;

	}
}
