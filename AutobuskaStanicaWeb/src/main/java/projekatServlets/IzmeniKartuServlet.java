package projekatServlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.JPAUtil;
import managers.KartaManager;
import model.Karta;

/**
 * Servlet implementation class IzmeniKartuServlet
 */
public class IzmeniKartuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmeniKartuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		String idKartaString = request.getParameter("idKarta");
		
		int idKarta = Integer.parseInt(idKartaString);
		
		Karta k = em.find(Karta.class, idKarta);
		
		
		if (k != null) {
			request.getSession().setAttribute("karta", k);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Karte.jsp");
			rd.forward(request, response);
			
		} else {
			String msg = "Greska";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Karte.jsp");
			rd.forward(request, response);
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Karta k = (Karta) request.getSession().getAttribute("karta");
		EntityManager em = JPAUtil.getEntityManager();
		String cenaKarte = request.getParameter("cenaKarte");
	
		String msg = "";
		
		Integer kr = new KartaManager().updateKarta(em, k.getIdKarta(), cenaKarte);
		if (kr > 0) {
			msg = "Uspesno smo izmenili cenu karte, sad je " + cenaKarte;
		} else {
			msg = "Nismo uspeli da izmenimo cenu karte";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Karte.jsp");
		rd.forward(request, response);
	}

}
