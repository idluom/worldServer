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

import Service.TrackEJB;

@ManagedBean
@RequestScoped
public class TrackImageBean {
	
	private StreamedContent image;

	@ManagedProperty("#{param.trackTitle}")
	private String trackTitle;

	@ManagedProperty("#{helperBean.defaultPicture}")
	private byte[] defaultPicture;

	@EJB
	private TrackEJB trackEJB;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the view. Return a stub StreamedContent so
			// that it will generate right URL.
			image = new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			byte[] productPicture = trackEJB.findPictureByTrackTitle(trackTitle);
			if (productPicture == null) {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						defaultPicture));
			} else {
				image = new DefaultStreamedContent(new ByteArrayInputStream(
						productPicture));
			}
		}
	}
	// getters and setters
	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	public byte[] getDefaultPicture() {
		return defaultPicture;
	}

	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}

	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}
	
}
