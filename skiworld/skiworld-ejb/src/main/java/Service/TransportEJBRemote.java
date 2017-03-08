package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Transport;

@Remote
public interface TransportEJBRemote {
	public void addMeanTransport(Transport transport);
	public void deleteMeanTransport(Transport transport);
	public void updateMeanTransport(Transport transport);
	public List<Transport> displayMeanTransport();
}
