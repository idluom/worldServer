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

import Service.TripEJB;
import Service.TripEJBRemote;

@ManagedBean
@RequestScoped
public class TripImageBean {
	private StreamedContent image;

	@ManagedProperty("#{param.productName}")
	private String productName;

	@ManagedProperty("#{helperBean.defaultPicture}")
	private byte[] defaultPicture;

	@EJB
	private TripEJBRemote tripEJB;
	
	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			image = new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			byte[] productPicture = tripEJB.findPictureByProductName(productName);
			if (productPicture == null) {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						defaultPicture));
				System.out.println("mahouchhhhhhhhhhhhhhhhhhhh");
			} else {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						productPicture));
				System.out.println("mawjouddddddddddddddddddddd");
			}
		}
	}
	
	
	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public byte[] getDefaultPicture() {
		return defaultPicture;
	}


	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}
	

	
	
}
