package Service;

import javax.ejb.Remote;

import Entity.Hotel;


@Remote
public interface HotelEJBRemote {
	public void updateHotel(Hotel hotel);
	public Hotel findHotelById(Long id);
}
