package Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entity.DayMenu;


@Remote
public interface DayMenuEJBRemote {
	public void addMenu(DayMenu menu);
	public void deleteMenu(DayMenu menu);
	public void updateMenu(DayMenu menu);
	public List<DayMenu> displayMeanTransport();
	public DayMenu findMenuById (Long idMenu);
	public DayMenu findMenuByDate (Date d);
	void deleteMenu2(DayMenu menu);
}
