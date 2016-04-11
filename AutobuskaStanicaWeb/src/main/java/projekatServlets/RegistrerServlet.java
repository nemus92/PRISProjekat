package projekatServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KorisnikManager;
import model.Korisnik;

/**
 * Servlet implementation class RegistrerServlet
 */
public class RegistrerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ime = request.getParameter("imeKorisnika");
		String prezime = request.getParameter("prezimeKorisnika");
		String adresa = request.getParameter("adresaKorisnika");
		String jmbg = request.getParameter("jmbgKorisnika");
		String user = request.getParameter("userKorisnika");
		String pass = request.getParameter("passKorisnika");
		String msg = "";
		
		Korisnik korisnik = KorisnikManager.registerKorisnik(ime, prezime, adresa, jmbg, user, pass);
		
		if (korisnik != null) {
			msg = "Ulogovani ste kao" + korisnik.getIdKorisnik();
			request.setAttribute("msg", msg);
			request.getSession().setAttribute("korisnik", korisnik);

		} else {
		request.getSession().setAttribute("korisnik", korisnik);
			
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Login.jsp");
		rd.forward(request, response);
		}
	
		
	}

}
