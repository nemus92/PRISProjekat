package projekatServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.AdminManager;
import managers.KorisnikManager;
import model.Admin;
import model.Korisnik;

/**
 * Servlet implementation class LoginAdminServlet
 */
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
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
		
		String user = request.getParameter("userAdmin");
		String pass = request.getParameter("passAdmin");
		String msg = "";
		
		Admin admin = AdminManager.login(user, pass);
		
		if (admin != null) {
			msg = "Ulogovali ste se kao :" + admin.getUserAdmin()	+ 
					" <a href=" + "/AutobuskaStanicaWeb/LogoutServlet" + ">Logout.</a>";
		
		request.setAttribute("msg", msg);
		request.getSession().setAttribute("admin", admin);
			
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/Karte.jsp");
		rd.forward(request, response);

		} else {
			msg = "Pogresan username i password! Pokusajte ponovo.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu/LoginAdmin.jsp");
			rd.forward(request, response);

		}
	}

}
