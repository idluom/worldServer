package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationTransportID implements Serializable {
	private Long idSkier;
	private Long idTransport;
	private static final long serialVersionUID = 1L;
	
	public ReservationTransportID() {
		
	}

	public Long getIdSkier() {
		return idSkier;
	}

	public void setIdSkier(Long idSkier) {
		this.idSkier = idSkier;
	}

	public Long getIdTransport() {
		return idTransport;
	}

	public void setIdTransport(Long idTransport) {
		this.idTransport = idTransport;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
