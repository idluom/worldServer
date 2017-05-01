package Beans;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entity.Training;
import Service.TrainingEJB;
import Service.TrainingEJBRemote;

@ManagedBean
@SessionScoped
public class TrainingBean {
	@EJB
	private TrainingEJB trainingEJBRemote ;
	
	private List<Training> list;
	
	private Training training = new Training();
	private List<Training> listTraining = new ArrayList<Training>();
	
	// Fontion pour afficher tout les Training session
	
	public List<Training> DoAfficher(){
		return trainingEJBRemote.findAllTraining();
	}
	
	
	
	//Getters et setters
	public TrainingEJBRemote getTrainingEJBRemote() {
		return trainingEJBRemote;
	}
	public void setTrainingEJBRemote(TrainingEJB trainingEJBRemote) {
		this.trainingEJBRemote = trainingEJBRemote;
	}
	public List<Training> getList() {
		return list;
	}
	public void setList(List<Training> list) {
		this.list = list;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public List<Training> getListTraining() {
		return listTraining;
	}
	public void setListTraining(List<Training> listTraining) {
		this.listTraining = listTraining;
	}
}
