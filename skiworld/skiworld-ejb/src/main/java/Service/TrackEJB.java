package Service;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
