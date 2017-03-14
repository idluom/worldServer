package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.DayMenu;
import Entity.Product;
import Entity.Training;

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

	@Override
	public DayMenu findMenuByDate(Date d) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateformat.format(d));
		try {
			Date dt = simpleDateformat.parse(simpleDateformat.format(d));
			return em.createQuery("select p from DayMenu p where p.dayMenuDate like '"+simpleDateformat.format(d)+"%'",DayMenu.class).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public void deleteMenu2(DayMenu menu) {
		
		for (Product produit : menu.getDayMenuList()) {
		produit.setMenu(null);
		
		}
		em.remove(em.merge(menu));
	}
	
}
