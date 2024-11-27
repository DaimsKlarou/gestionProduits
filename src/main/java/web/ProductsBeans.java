package web;

import java.util.ArrayList;

import metier.Products;

public class ProductsBeans {
	
	private Products product = new Products();
	private ArrayList<Products> listProduct = new ArrayList<Products>();
	
	//product getter
	public Products getProduct() {
		return product;
	}
	
	//product setter
	public void setProduct(Products product) {
		this.product = product;
	}
	
	//Products List getter
	public ArrayList<Products> getListProduct() {
		return listProduct;
	}
	
	//Products List setter
	public void setListProduct(ArrayList<Products> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
