package ma.metier;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ma.entites.Restaurant;

@Stateless(name = "Restaurant")
public class RestaurantEJBImpl implements RestaurantLocal, RestaurantRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public List<Restaurant> listRestaurants() {
		// Use the EntityManager to create a TypedQuery for restaurants
		TypedQuery<Restaurant> query = em.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
		// Execute the query and return the results
		return query.getResultList();
	}

	@Override
	@PermitAll
	public Restaurant addRestaurant(Restaurant c) {
		// Persist the new restaurant object using the EntityManager
		em.persist(c);
		// Return the newly-persisted restaurant object
		return c;
	}

	@Override
	@PermitAll
	public Restaurant getRestaurant(Integer code) {
		// Use the EntityManager to find the restaurant with the specified code
		return em.find(Restaurant.class, code);
	}

	@Override
	@PermitAll
	public int deleteRestaurant(Integer code) {
		// Use the EntityManager to find the restaurant with the specified code
		Restaurant c = em.find(Restaurant.class, code);
		// If the restaurant was found, remove it and return 1 (indicating success)
		if (c != null) {
			em.remove(c);
			return 1;
		}
		// If the restaurant
		return 0;
	}

	@Override
	public Restaurant editRestaurant(Restaurant c) {
		em.merge(c);
		// Return the newly-persisted restaurant object
		return c;
	}
}