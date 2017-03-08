package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Room;

/**
 * Session Bean implementation class RoomEJB
 */
@Stateless
@LocalBean
public class RoomEJB implements RoomEJBRemote {
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RoomEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRoom(Room room) {
		em.persist(room);
		
	}

	@Override
	public void updateRoom(Room room) {
		em.merge(room);
		
	}

	@Override
	public void deleteRoom(Room room) {
		Room p=new Room();
		p=em.merge(room);// pour convertir en etat managed
		em.remove(p);
	}

	@Override
	public Room findRoomById(Long id) {
		
		return em.find(Room.class, id);
	}

	@Override
	public List<Room> findAllRoom() {
		
		return em.createQuery("SELECT r from Room r", Room.class).getResultList();
	}

}
