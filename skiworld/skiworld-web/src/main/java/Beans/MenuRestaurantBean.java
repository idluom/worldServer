package Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Service.DayMenuEJB;
import Service.ProductEJB;
import Entity.DayMenu;
import Entity.Product;

@ManagedBean
public class MenuRestaurantBean {
	@EJB
	private ProductEJB productService;
	@EJB
	private DayMenuEJB dayMenuService;
	private Product product;
	private List<Product> products;
	private DayMenu daymenu;
	private float price;
	@PostConstruct
	public void init() {
		setProduct(new Product());
		setProducts(productService.findAllProduct());
		setDaymenu(dayMenuService.findMenuById(new Long(1)));
		setPrice(dayMenuService.dayMenuPrice(daymenu));
		}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public DayMenu getDaymenu() {
		return daymenu;
	}


	public void setDaymenu(DayMenu daymenu) {
		this.daymenu = daymenu;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
}
