package ma.metier;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ma.dao.RestaurantOnPremise;
import ma.dao.RestaurantServer;
import ma.entites.Restaurant;

@Stateless(name = "Restaurant")
public class RestaurantEJBImpl<T extends Restaurant> implements RestaurantOnPremise<T>, RestaurantServer<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public List<T> getAll() {
		TypedQuery<T> query = em.createQuery("SELECT r FROM Restaurant r", (Class<T>) Restaurant.class);
		return query.getResultList();
	}

	@Override
	@PermitAll
	public T add(T c) {
		// Persist the new restaurant object using the EntityManager
		em.persist(c);
		// Return the newly-persisted restaurant object
		return c;
	}

	@Override
	@PermitAll
	public T get(Integer code) {
		// Use the EntityManager to find the restaurant with the specified code
		return em.find((Class<T>) Restaurant.class, code);
	}

	@Override
	@PermitAll
	public int delete(Integer code) {
		// Use the EntityManager to find the restaurant with the specified code
		T c = em.find((Class<T>) Restaurant.class, code);
		// If the restaurant was found, remove it and return 1 (indicating success)
		if (c != null) {
			em.remove(c);
			return 1;
		}
		// If the restaurant
		return 0;
	}

	@Override
	@PermitAll
	public T edit(T c) {
		em.merge(c);
		// Return the newly-persisted restaurant object
		return c;
	}

}
