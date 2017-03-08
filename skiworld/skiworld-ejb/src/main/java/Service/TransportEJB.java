package Service;

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
	

}
