package metier;

import java.util.Iterator;

public class TestMetier {
	
	public static void main(String[] args) {
		Operations op = new Operations();
		
		op.addProduct(new Products(1L, "PC", "Laptop Computer", 8000, 1));
		op.addProduct(new Products(2L, "Mobile Phone", "Phone that you can move on", 3000, 1));
		op.addProduct(new Products(3L, "Smart Watch", "Watch for connected with phone", 500, 1));
		op.addProduct(new Products(4L, "Mouse", "Laptop Computer Tools", 200, 0));
		op.addProduct(new Products(5L, "KeyBoard", "Laptop ComputerTools", 600, 0));
		
		Iterator<Products> products = op.getAllProducts().iterator();	
		
		while(products.hasNext()) {
			Products p = products.next();
			p.show();
		}
	}
}
