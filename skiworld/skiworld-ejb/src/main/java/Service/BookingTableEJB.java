package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BookingTableEJB
 */
@Stateless
@LocalBean
public class BookingTableEJB implements BookingTableEJBRemote, BookingTableEJBLocal {

    /**
     * Default constructor. 
     */
    public BookingTableEJB() {
        // TODO Auto-generated constructor stub
    }
    

}
