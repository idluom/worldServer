package Service;

import javax.ejb.Remote;

import Entity.Member;

@Remote
public interface MemberEJBRemote {
	public Member authentication(String username, String password);
}
