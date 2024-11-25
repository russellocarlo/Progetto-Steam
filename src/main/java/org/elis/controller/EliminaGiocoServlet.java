package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;


public class EliminaGiocoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_gioco = request.getParameter("id_gioco");
		//String id_libreria = request.getParameter("id_gioco");
		long idGioco = Long.parseLong(id_gioco);
		
		if(id_gioco == null || id_gioco.isEmpty()){
			request.getRequestDispatcher("ServletPerHomePage").forward(request, response);
			return;
		}
		
		
		/*if(id_gioco != null && id_libreria != null) {
			long idLibreria = Long.parseLong(id_libreria);
			BusinessLogic.deleteGiocoLibreria(idLibreria, idGioco);
			request.getRequestDispatcher("ServletPerPaginaLibrerie").forward(request, response);
			return;
		}*/
		
		
		BusinessLogic.deleteGiocoById(idGioco);
		request.getRequestDispatcher("ServletPerHomePage").forward(request, response);
	}

}
