package com.dbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.dao.VehiculoDAO;
import com.jdbc.model.Vehiculo;
//import com.rentacar.dao.AutoDAO;
//import com.rentacar.model.Auto;

/**
 * Servlet implementation class VehiculoController
 */
@WebServlet("/vehiculoController")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VehiculoDAO vehiculoDAO = new VehiculoDAO();
    
    public VehiculoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion = request.getParameter("opcion");
		
		
		if (opcion.equals("registro")) {
			RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			rd.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("crear")) {
			//AutoDAO autoDAO = new AutoDAO();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setPlaca(request.getParameter("placa"));
			vehiculo.setMarca(request.getParameter("marca"));
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setCilindraje(request.getParameter("cilindraje"));
			vehiculo.setAnio(request.getParameter("anio"));
			vehiculo.setConsumo(request.getParameter("consumo"));
			
			try {
				if(vehiculoDAO.save(vehiculo)) {
					System.out.println("regsitro guardado");
					
					
				}else {
					System.out.println("registro NO guardado");
				}
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			
			List<Vehiculo> lista = vehiculoDAO.getAll();
			request.setAttribute("vehículos", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			

		}
		
	}

}
