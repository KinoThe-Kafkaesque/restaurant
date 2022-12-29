package ma.entites;

import java.io.Serializable;
import java.lang.Long;
import java.time.LocalDate;
import java.util.Date;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String photo;
	@JsonbTransient
	@ManyToOne
	private Restaurant restaurant;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Album(int id, String photo) {
		super();
		this.id = id;
		this.photo = photo;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Album() {
		super();
	}
	
   
}
