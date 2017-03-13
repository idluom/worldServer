package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Room;

@Remote
public interface RoomEJBRemote {
	public void addRoom(Room room);
	public void updateRoom(Room room);
	public void deleteRoom(Room room);
	public Room findRoomById(Long id);
	public List<Room> findAllRoom();

}
