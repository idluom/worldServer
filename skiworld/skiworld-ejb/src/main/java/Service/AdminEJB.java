package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Admin;
import Entity.HotelManager;
import Entity.Member;
import Entity.RestaurantOwner;
import Entity.ShopOwner;

/**
 * Session Bean implementation class AdminEJB
 */
@Stateless
@LocalBean
public class AdminEJB implements AdminEJBRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AdminEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAdmin(Member member) {
		if (member instanceof Admin) {
			Admin admin = (Admin) member;
			em.persist(admin);
		} else if (member instanceof RestaurantOwner) {
			RestaurantOwner admin = (RestaurantOwner) member;
			em.persist(admin);
		} else if (member instanceof ShopOwner) {
			ShopOwner admin = (ShopOwner) member;
			em.persist(admin);
		} else if (member instanceof HotelManager) {
			HotelManager admin = (HotelManager) member;
			em.persist(admin);
		}
	}

	@Override
	public void updateAdmin(Member member) {
		if (member instanceof Admin) {
			Admin admin = (Admin) member;
			em.merge(admin);
		} else if (member instanceof RestaurantOwner) {
			RestaurantOwner admin = (RestaurantOwner) member;
			em.merge(admin);
		} else if (member instanceof ShopOwner) {
			ShopOwner admin = (ShopOwner) member;
			em.merge(admin);
		} else if (member instanceof HotelManager) {
			HotelManager admin = (HotelManager) member;
			em.merge(admin);
		}
		
	}

	@Override
	public void deleteAdmin(Admin a) {
		em.remove(em.merge(a));
	}

	@Override
	public boolean deleteAdmin(int a) {
		try {
			em.remove(a);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Member> displayAll() {
		
		return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
	}
	
	@Override
	public Admin getAdmin() {
		return em.createQuery("select a from Admin a", Admin.class).getSingleResult();
				
	}

	@Override
	public HotelManager getHotelManager() {
		return em.createQuery("select h from HotelManager h",HotelManager.class).getSingleResult();
	}

	@Override
	public ShopOwner getShopOwner() {
		return em.createQuery("select s from ShopOwner s", ShopOwner.class).getSingleResult();
	}

	@Override
	public RestaurantOwner getRestaurantOwner() {
		return em.createQuery("select r from RestaurantOwner r",RestaurantOwner.class).getSingleResult();
	}
	
	


}
