package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Hotel;

/**
 * Session Bean implementation class HotelEJB
 */
@Stateless
@LocalBean
public class HotelEJB implements HotelEJBRemote {
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public HotelEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void updateHotel(Hotel hotel) {
		em.merge(hotel);
		
	}

//	@Override
//	public void deleteHotel(Hotel hotel) {
//		Hotel h;
//		h=em.merge(hotel);// pour convertir en etat managed
//		em.remove(h);
//		
//	}

	@Override
	public Hotel findHotelById(Long id) {
		return em.find(Hotel.class, id);
	}

//	@Override
//	public List<Hotel> findAllHotel() {
//		return em.createQuery("SELECT r from Hotel r", Hotel.class).getResultList();
//	}

}
