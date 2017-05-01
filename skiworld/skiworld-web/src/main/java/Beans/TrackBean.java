package Beans;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import Entity.Track;
import Service.TrackEJBRemote;

@ManagedBean
@Named
@SessionScoped
public class TrackBean {
	@EJB
	private TrackEJBRemote trackEJBRemote ;
	
	private List<Track> list;
//	private RepeatPaginator paginator;
	private Track track = new Track();
	private List<Track> listTrack = new ArrayList<Track>();
	private List<Track> list2 = new ArrayList<Track>();


	
	public String diff;
	
	
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
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
	//@PostConstruct
	public List<Track> doAfficherListTrack(){
		
		list2 = trackEJBRemote.findAll();
		return list2;
		
	}
	public String DoReservation(){
		FacesContext fc = FacesContext.getCurrentInstance();
		this.diff = getCountryParam(fc);
		return "Reservation";
		
	}
	
	public String chat(){
		return "index2";
	}
	//get value from "f:param"
	public String getCountryParam(FacesContext fc){

		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("country");

	}
	
//	public RepeatPaginator getPaginator() {
//		return paginator;
//	}


	public List<Track> getList() {
		return list;
	}
	public void setList(List<Track> list) {
		this.list = list;
	}
	public List<Track> getList2() {
		return list2;
	}
	public void setList2(List<Track> list2) {
		this.list2 = list2;
	}
//	public void setPaginator(RepeatPaginator paginator) {
//		this.paginator = paginator;
//	}
	
}
