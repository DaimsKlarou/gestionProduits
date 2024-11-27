package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operations {
	
	private ArrayList<Products> products = new ArrayList<Products>() ;
	private String url = "jdbc:mysql://localhost:3306/gestionProduct";
    private String username = "daims";
    private String password = "Daims";
	
	//array_list products getter
	public ArrayList<Products> getProducts() {
		return products;
	}

	//array_list products setter
	public void setProducts(ArrayList<Products> products) {
		this.products = products;
	}
	
	//add a product in the product list
	public void addProduct(Products produit) {
	    String sql = "INSERT INTO products (nom, description, prix, etat) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = DriverManager.getConnection(url, username, password);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, produit.getNom());
	        stmt.setString(2, produit.getDescription());
	        stmt.setInt(3, produit.getPrix());
	        stmt.setInt(4, produit.getEtat());

	        int rowsInserted = stmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Le produit a été ajouté avec succès !");
	            products.add(produit);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//remove a product in the product list
	public void removeProduct(Long idProduit) {
	    String sql = "DELETE FROM products WHERE id = ?";

	    try (Connection conn = DriverManager.getConnection(url, username, password);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setLong(1, idProduit);

	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Le produit a été supprimé avec succès !");
	            for(Products p:products) {
	            	if(p.getId() == idProduit) {
	            		products.remove(p.getId());
	            	}
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//to update the product in the list product
	public void updateProduct(Products produit, int idProduit) {
	    String sql = "UPDATE products SET nom = ?, description = ?, prix = ?, etat = ? WHERE id = ?";

	    try (Connection conn = DriverManager.getConnection(url, username, password);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, produit.getNom());
	        stmt.setString(2, produit.getDescription());
	        stmt.setInt(3, produit.getPrix());
	        stmt.setInt(4, produit.getEtat());
	        stmt.setInt(5, idProduit);

	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Le produit a été modifié avec succès !");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//return the products list
	public ArrayList<Products> getAllProducts() {
	    ArrayList<Products> produits = new ArrayList<>();
	    String sql = "SELECT * FROM products";  // Modifier la requête en fonction des colonnes que vous souhaitez récupérer

	    try (Connection conn = DriverManager.getConnection(url, username, password);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            // Récupérer les données pour chaque produit
	        	Long id = (long) rs.getInt("id");
	            String nom = rs.getString("nom");
	            String description = rs.getString("description");
	            int prix = rs.getInt("prix");
	            int etat = rs.getInt("etat");

	            // Créer un objet Produit et l'ajouter à la liste
	            Products produit = new Products(id, nom, description, prix, etat);
	            produits.add(produit);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produits;
	}
}
