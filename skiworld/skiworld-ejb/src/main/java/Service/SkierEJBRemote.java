package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Events;
import Entity.Skier;

@Remote
public interface SkierEJBRemote {
public void addSkier(Skier S);
public void updateSkier(Skier S);
public Skier findSkierById(Long id);
public void delete(Skier S);
public List<Skier> findSkiersByEvent(Events event);
}
