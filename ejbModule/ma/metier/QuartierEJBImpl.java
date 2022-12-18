package ma.metier;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ma.dao.OnPremise;
import ma.dao.Server;
import ma.entites.Quartier;

@Stateless(name = "Quartier")
public class QuartierEJBImpl<T extends Quartier> implements OnPremise<T>, Server<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public List<T> getAll() {
		TypedQuery<T> query = em.createQuery("SELECT r FROM Quartier r", (Class<T>) Quartier.class);
		return query.getResultList();
	}

	@Override
	@PermitAll
	public T add(T c) {
		// Persist the new quartier object using the EntityManager
		em.persist(c);
		// Return the newly-persisted quartier object
		return c;
	}

	@Override
	@PermitAll
	public T get(Integer code) {
		// Use the EntityManager to find the quartier with the specified code
		return em.find((Class<T>) Quartier.class, code);
	}

	@Override
	@PermitAll
	public int delete(Integer code) {
		// Use the EntityManager to find the quartier with the specified code
		T c = em.find((Class<T>) Quartier.class, code);
		// If the quartier was found, remove it and return 1 (indicating success)
		if (c != null) {
			em.remove(c);
			return 1;
		}
		// If the quartier
		return 0;
	}

	@Override
	@PermitAll
	public T edit(T c) {
		em.merge(c);
		// Return the newly-persisted quartier object
		return c;
	}

}
