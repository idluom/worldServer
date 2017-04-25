package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entity.Track;
import Service.TrackEJBRemote;

@ManagedBean
@ApplicationScoped
public class TrackBean {
	@EJB
	private TrackEJBRemote trackEJBRemote ;
	private boolean formDisplayed=false;
	private Track track = new Track();
	private List<Track> listTrack = new ArrayList<Track>();
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public List<Track> getListTrack() {
		return listTrack;
	}
	public void setListTrack(List<Track> listTrack) {
		this.listTrack = listTrack;
	}
	
	public List<Track> doAfficherListTrack(){
		return trackEJBRemote.findAll();
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public String doNew(){
		String navTo="";
		setFormDisplayed(true);
		return navTo;
	}
	
}
