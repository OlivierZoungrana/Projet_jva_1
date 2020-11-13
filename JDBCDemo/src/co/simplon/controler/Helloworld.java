package co.simplon.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.model.*;
import co.simplon.dao.*;


@WebServlet(urlPatterns = "/Helloworld", loadOnStartup=1)
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   private PaysDAO paysDao;
   
   public void init() throws ServletException{
	   DAOContext daoContext = new DAOContext();
	   this.paysDao = daoContext.getPaysDao();
   }
	
    public Helloworld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("Lpays", paysDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String action = request.getServletPath();
		
		switch(action){
		
		
		case "modifier":
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			
			Pays pays = new Pays(id, nom);
			paysDao.modifier(pays);
			
			break;
		case "supprimer":
			int id1 = Integer.parseInt(request.getParameter("id"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(request, response);
			break;
		}
		
		
		
		Pays pays = new Pays();
		pays.setNom(request.getParameter("nom"));
		paysDao.ajouter(pays);
		request.setAttribute("Lpays", paysDao.lister());
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(request, response);
		
	}
	
	
				
				
			}


