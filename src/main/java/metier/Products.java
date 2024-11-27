package metier;

public class Products {

	private Long id;
	private String nom, description;
	private int prix, etat;
	
	//Id getter
	public Long getId() {
		return id;
	}
	
	//Id setter
	public void setId(Long id) {
		this.id = id;
	}
	
	//Name getter
	public String getNom() {
		return nom;
	}
	
	//Name setter
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Description getter
	public String getDescription() {
		return description;
	}
	
	//Description Setter
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Etat getter
	public int getEtat() {
		return etat;
	}
	
	//Etat setter
	public void setEtat(int etat) {
		this.etat = etat;
	}
	

	//Prix getter
	public int getPrix() {
		return prix;
	}
	
	//Prix setter
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	//Product constructor without fields
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//product constructor without id
	public Products(String nom, String description, int prix, int etat) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.etat = etat;
	}

	//products constructor with ID
	public Products(Long id, String nom, String description, int prix, int etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.etat = etat;
	}
	
	//format to show for the product in the product list
	private String ToString() {	
		return nom + " - " + description + " - " + prix + " - " + etat + " .";
	}

	//show the product
	public void show() {
		System.out.println(ToString());
	}

	
	
}
