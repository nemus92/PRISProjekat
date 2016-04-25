package projekatServlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.JPAUtil;
import managers.RezervacijaManager;
import model.Korisnik;

/**
 * Servlet implementation class RezervacijaServlet
 */
public class RezervacijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezervacijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		String idKartaString = request.getParameter("idKarta");
		Korisnik k = (Korisnik) request.getSession().getAttribute("korisnik");
		
		String msg = "";
		
		int idKarta = Integer.parseInt(idKartaString);
		
		int idRezervacije = new RezervacijaManager().rezervisiKartu(em, idKarta, k.getIdKorisnik());    
		
		if (idRezervacije > 0) {
			
			msg = "Uspesno ste rezervisali kartu, id rezervacije je " + idRezervacije;
			
		} else {
			msg = "Niste uspeli da rezervisete, probajte ponovo";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Rezervacija.jsp");
		rd.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
