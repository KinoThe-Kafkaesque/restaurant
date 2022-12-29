package ma.entites;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@JsonbTransient
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Restaurant> restaurants;

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

	public Category(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Category() {
		super();

	}

}
