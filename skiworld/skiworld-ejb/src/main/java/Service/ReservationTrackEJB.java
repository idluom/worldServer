package Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Track;
import Entity.TrackSkier;
import Entity.Training;
/**
 * Session Bean implementation class ReservationTrackEJB
 */
@Stateless
@LocalBean
public class ReservationTrackEJB implements ReservationTrackEJBRemote{
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
	
	
	 /**
     * Default constructor. 
     */
    public ReservationTrackEJB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addReservationTrack(TrackSkier reservation) {
		
		em.persist(reservation);
	}
	/*
	 * Methode pour verifier si a une date données,il ya des place pour la track ou pas
	 */
	@Override
	public List<TrackSkier> checkReservation(long idTrack,Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		Long i;
//		i = (Long) em.createQuery("Select count(*) from Events e where e.date like '" + sdf.format(date) + "%'")
//				.getSingleResult();
		return em.createQuery("select p from TrackSkier p where p.dateReservation like '" +sdf.format(date)+"'",TrackSkier.class ).getResultList();
		
	}
	
}
