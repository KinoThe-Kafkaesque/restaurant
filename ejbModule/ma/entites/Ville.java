package ma.entites;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
public class Ville implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@OneToMany(mappedBy="ville" , fetch = FetchType.EAGER , cascade = CascadeType.ALL )
	private Set<Quartier> quartiers;
	public Set<Quartier> getQuartiers() {
		return quartiers;
	}
	public void setQuartiers(Set<Quartier> quartiers) {
		this.quartiers = quartiers;
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
	public Ville(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Ville() {
		super();
	}
	
}
