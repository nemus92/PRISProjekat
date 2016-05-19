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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		String user = request.getParameter("userKorisnika");
		String pass = request.getParameter("passKorisnika");
		String msg = "";
		
		Korisnik korisnik = KorisnikManager.login(user, pass);
		
		if (korisnik != null) {
			msg = "Ulogovali ste se kao :" + korisnik.getImeKorisnika() + " " + korisnik.getPrezimeKorisnika() + 
					" <a href=" + "/AutobuskaStanicaWeb/LogoutServlet" + ">Logout.</a>";
			System.out.println("Korisnik je nadjen");
		request.setAttribute("msg", msg);
		request.getSession().setAttribute("korisnik", korisnik);
			
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/AutobuskaStanica.jsp");
		rd.forward(request, response);

		} else {
			System.out.println("Korinsik je null");
			msg = "Pogresan username i password! Pokusajte ponovo.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Login.jsp");
			rd.forward(request, response);

		}
	}

}
