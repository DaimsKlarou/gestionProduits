package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Operations;
import metier.Products;

public class Product extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private Operations op ;
	private ProductsBeans pb;
	
	@Override
	public void init() throws ServletException {
		op = new Operations();
		pb = new ProductsBeans();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("action") != null) {
			String id = req.getParameter("id");
			op.removeProduct(Long.parseLong(id));
			
		} else {
		
			//get the product informations
			String nom = req.getParameter("nom");
			String desc = req.getParameter("description");
			String prix = req.getParameter("prix");
			String etat = req.getParameter("etat");
			
			Products product = new Products(1L, nom, desc, Integer.parseInt(prix), Integer.parseInt(etat));
			
			op.addProduct(product);
			
		}
		
		pb.setListProduct(op.getAllProducts());
		req.setAttribute("modele", pb);
		req.getRequestDispatcher("Produits.jsp").forward(req, resp);	
		
	}
}
