package Beans;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;


import org.apache.commons.io.IOUtils;


import Service.EquipementEJB;



@ManagedBean
@ApplicationScoped
public class HelperBeanImag {
	
	
	
	@EJB
	private EquipementEJB equipementEJB ;
	private byte[] defaultPicture;

	public HelperBeanImag() {

	}

	@PostConstruct
	public void init() {

		InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/ressources/images/default.jpg");

		try {
			defaultPicture = IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public byte[] getDefaultPicture() {
		return defaultPicture;
	}

	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}
	

}
