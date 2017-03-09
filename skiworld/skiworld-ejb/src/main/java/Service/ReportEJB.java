package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Report;

/**
 * Session Bean implementation class ReportEJB
 */
@Stateless
@LocalBean
public class ReportEJB implements ReportEJBRemote {

	@PersistenceContext(unitName = "skiworld-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReportEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Report> findAllReports() {
		
		return em.createQuery("SELECT r FROM Report r", Report.class).getResultList();
	}

}
