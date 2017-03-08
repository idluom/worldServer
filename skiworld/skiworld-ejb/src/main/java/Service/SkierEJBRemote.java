package Service;

import javax.ejb.Remote;

import Entity.Skier;

@Remote
public interface SkierEJBRemote {
public void addSkier(Skier S);
public void updateSkier(Skier S);
public Skier findSkierById(Long id);
public void delete(Skier S);
}
