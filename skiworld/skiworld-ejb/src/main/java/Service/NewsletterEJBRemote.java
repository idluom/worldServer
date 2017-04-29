package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Newsletter;

@Remote
public interface NewsletterEJBRemote {
	public void addUserToList(Newsletter user);
	public List<Newsletter> getMailingList();
}
