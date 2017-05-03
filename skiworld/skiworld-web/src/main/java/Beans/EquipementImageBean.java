package Beans;

import java.io.ByteArrayInputStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import Service.EquipementEJB;


@ManagedBean
@RequestScoped
public class EquipementImageBean {
	
	private StreamedContent image;
	
	@ManagedProperty("#{param.equipementName}") 
	private String equipementName;
	
	@ManagedProperty("#{helperBeanImag.defaultPicture}")
	private byte[] defaultPicture;
	
	@EJB
	private EquipementEJB equipementEJB ;
	
	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			image = new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			System.out.println(equipementName);
			byte[] picture = equipementEJB.FindByName(equipementName).getPhoto();
					System.out.println(picture);
			if (picture == null) {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						defaultPicture));
			} else {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						picture));
			}
		}
	}
	public StreamedContent getImage() {
		return image;
	}
	public void setImage(StreamedContent image) {
		this.image = image;
	}
	
	
	

	public String getEquipementName() {
		return equipementName;
	}
	public void setEquipementName(String equipementName) {
		this.equipementName = equipementName;
	}
	public EquipementEJB getEquipementEJB() {
		return equipementEJB;
	}
	public void setEquipementEJB(EquipementEJB equipementEJB) {
		this.equipementEJB = equipementEJB;
	}
	public byte[] getDefaultPicture() {
		return defaultPicture;
	}
	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}
	
	

	
}
