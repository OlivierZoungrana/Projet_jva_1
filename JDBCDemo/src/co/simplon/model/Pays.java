package co.simplon.model;

public class Pays {
	
	public int id;
	public String nom;
	
	public Pays() {
		super();
	}

	public Pays(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	

}
