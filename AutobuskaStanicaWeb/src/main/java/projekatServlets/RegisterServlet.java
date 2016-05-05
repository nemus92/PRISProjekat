package projekatServlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.JPAUtil;
import managers.KorisnikManager;
import model.Korisnik;

/**
 * Servlet implementation class RegistrerServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
			
			EntityManager em = JPAUtil.getEntityManager();
			String ime = request.getParameter("imeKorisnika");
			String prezime = request.getParameter("prezimeKorisnika");
			String adresa = request.getParameter("adresaKorisnika");
			String jmbg = request.getParameter("jmbgKorisnika");
			String user = request.getParameter("userKorisnika");
			String pass = request.getParameter("passKorisnika");
			
		
			String msg = "";
			
			Integer idKorisnika = new KorisnikManager().registerKorisnik(em, ime, prezime, adresa, jmbg, user, pass);
			if (idKorisnika > 0) {
				msg = "Uspesno ste se registrovali: " + idKorisnika;
			} else {
				msg = "Niste uspeli da se registrujete";
			}
			
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/unos/Register.jsp");
			rd.forward(request, response);
			
		}

	}
