<%@page import="metier.Products"%>
<%@page import="java.util.Iterator"%>
<%@page import="web.ProductsBeans" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Gestion Produits -> Add Product</title>
		<link rel="stylesheet" href="style.css" />
	</head>
	<body>
		<% 
			ProductsBeans products;
			if(request.getAttribute("modele") != null){
				products = (ProductsBeans) request.getAttribute("modele");
			} else {
				products = new ProductsBeans();
			}
		%>

		<div class="container">
			<h3>Gestion de Produits Tutoriel Java JEE</h3>
			<h5>Ajouter un nouveau produit</h5>
			
			<!-- Formulaire d'ajout de produit -->
			<form action="prodserv" method="post">
				<table class="form-table">
					<tr>
						<td>Name :</td>
						<td><input type="text" name="nom" placeholder="Exemple: Orange" required /></td>
					</tr>
					<tr>
						<td>Description :</td>
						<td><input type="text" name="description" placeholder="Exemple: Orange est un fruit" required /></td>
					</tr>
					<tr>
						<td>Price :</td>
						<td><input type="number" name="prix" placeholder="Exemple: 250 CFA" required /></td>
					</tr>
					<tr>
						<td>State :</td>
						<td><input type="text" name="etat" placeholder="Exemple: Visible" required /></td>
					</tr>
					<tr>
						<td colspan="2" class="submit-btn">
							<input type="submit" name="valider" value="Valider" />
						</td>
					</tr>
				</table>
			</form>
			
			<!-- Tableau des produits -->
			<table class="product-table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>State</th>
						<th>Option</th>
					</tr>
				</thead>
				<tbody>
					<% 
						Iterator<Products> liste = products.getListProduct().iterator();
						while(liste.hasNext()){
							Products p = liste.next();
					%>
					<tr>
						<td><%= p.getId() %></td>
						<td><%= p.getNom() %></td>
						<td><%= p.getDescription() %></td>
						<td><%= p.getPrix() %></td>
						<td><%= p.getEtat() %></td>
						<td>
							<form action="prodserv" method="post">
								<input type="hidden" name="id" value="<%= p.getId() %>" />
								<input type="hidden" name="action" value="remove" />
								<input type="submit" value="Delete" class="delete-btn" />
							</form>
						</td>
					</tr>
					<% 
						}
					%>
				</tbody>
			</table>
		</div>
	</body>
</html>
