package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Transport;

/**
 * Session Bean implementation class TransportEJB
 */
@Stateless
@LocalBean
public class TransportEJB implements TransportEJBRemote {
	@PersistenceContext(unitName="skiworld-ejb")
	EntityManager em;
	@Override
	public void addMeanTransport(Transport transport) {
		em.persist(transport);
	}

	@Override
	public void deleteMeanTransport(Transport transport) {
		Transport user =em.merge(transport);
		em.remove(user);
	}

	@Override
	public void updateMeanTransport(Transport transport) {
		em.merge(transport);		
	}

	@Override
	public List<Transport> displayMeanTransport() {
		return  em.createQuery("SELECT p from Transport p",Transport.class).getResultList();
	}
	
	public Transport findTransportById(Long id) {
		return em.createQuery("SELECT t FROM Transport t WHERE t.idTransport="+id, Transport.class).getSingleResult();
	}
	
	public List<Transport> upcomingTransport() {
		Date date = new Date();
		return  em.createQuery("SELECT p from Transport p WHERE p.departureDate > :date AND p.numberPlaces > 0",Transport.class).setParameter("date", date).getResultList();
	}
}
