package Service;

import javax.ejb.Remote;

import Entity.Admin;

@Remote
public interface AdminEJBRemote {

	public void addAdmin(Admin a);
	public void updateAdmin(Admin a);
	public void deleteAdmin(Admin a);
	public boolean deleteAdmin(int a);
}
