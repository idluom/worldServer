package Beans;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

import Service.ReservationTransportCart;

@ServerEndpoint("/TransportServlet")
public class TransportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "transportCart";

	public TransportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReservationTransportCart cartBean = (ReservationTransportCart) request.getSession()
				.getAttribute(CART_SESSION_KEY);

		if (cartBean == null) {
			try {
				InitialContext ic = new InitialContext();
				cartBean = (ReservationTransportCart) ic.lookup(
						"/skiworld-ear/skiworld-ejb/ReservationTransportCart!"
						+ "Service.ReservationTransportCartRemote");

				request.getSession().setAttribute(CART_SESSION_KEY, cartBean);
				System.out.println("transportCart created");

			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}
	}
}
