package ma.entites;

import java.io.Serializable;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
public class Quartier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@JsonbTransient
	@ManyToOne
	private Ville ville;
	@JsonbTransient
	@OneToMany(mappedBy="quartier" , fetch = FetchType.EAGER , cascade = CascadeType.ALL )
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public Quartier(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Quartier() {
		super();
	}
}
