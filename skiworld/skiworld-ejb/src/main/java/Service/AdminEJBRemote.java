package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Admin;
import Entity.Member;

@Remote
public interface AdminEJBRemote {

	public void addAdmin(Member member);
	public void updateAdmin(Admin a);
	public void deleteAdmin(Admin a);
	public boolean deleteAdmin(int a);
	public List<Member> displayAll();
}
