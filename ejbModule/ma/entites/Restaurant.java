package ma.entites;

import java.io.Serializable;
import java.lang.Long;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
public class Restaurant implements Serializable {

	   
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nom;
		private double x;
		private double y;
		private LocalTime heureOuverture;
		private LocalTime heureFemeture;
		private static final long serialVersionUID = 1L;
		@OneToMany(mappedBy="restaurant")
		private List<Album> albums;
		public List<Album> getAlbums() {
			return albums;
		}
		public void setAlbums(List<Album> albums) {
			this.albums = albums;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		public LocalTime getHeureOuverture() {
			return heureOuverture;
		}
		public void setHeureOuverture(LocalTime heureOuverture) {
			this.heureOuverture = heureOuverture;
		}
		public LocalTime getHeureFemeture() {
			return heureFemeture;
		}
		public void setHeureFemeture(LocalTime heureFemeture) {
			this.heureFemeture = heureFemeture;
		}
		public Restaurant(int id ,String nom, double x, double y, LocalTime heureOuverture, LocalTime heureFemeture) {
			super();
			this.id = id;
			this.nom = nom;
			this.x = x;
			this.y = y;
			this.heureOuverture = heureOuverture;
			this.heureFemeture = heureFemeture;
		}


	public Restaurant() {
		super();
	}
   
}
