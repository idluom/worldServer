package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.DayMenu;

/**
 * Session Bean implementation class DayMenuEJB
 */
@Stateless
@LocalBean
public class DayMenuEJB implements DayMenuEJBRemote {
	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public DayMenuEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMenu(DayMenu menu) {
		em.persist(menu);
	}

	@Override
	public void deleteMenu(DayMenu menu) {
		DayMenu m = em.merge(menu);
		em.remove(m);

	}

	@Override
	public void updateMenu(DayMenu menu) {
		em.merge(menu);
	}

	@Override
	public List<DayMenu> displayMeanTransport() {

		return em.createQuery("SELECT p from Menu p", DayMenu.class).getResultList();

	}

	@Override
	public DayMenu findMenuById(Long idMenu) {

		return em.find(DayMenu.class, idMenu);
	}

}
