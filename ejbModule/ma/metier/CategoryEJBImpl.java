package ma.metier;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ma.dao.CategoryOnPremise;
import ma.dao.CategoryServer;
import ma.entites.Category;

@Stateless(name = "Category")
public class CategoryEJBImpl<T extends Category> implements CategoryOnPremise<T>, CategoryServer<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public List<T> getAll() {
		TypedQuery<T> query = em.createQuery("SELECT r FROM Category r", (Class<T>) Category.class);
		return query.getResultList();
	}

	@Override
	@PermitAll
	public T add(T c) {
		// Persist the new category object using the EntityManager
		em.persist(c);
		// Return the newly-persisted category object
		return c;
	}

	@Override
	@PermitAll
	public T get(Integer code) {
		// Use the EntityManager to find the category with the specified code
		return em.find((Class<T>) Category.class, code);
	}

	@Override
	@PermitAll
	public int delete(Integer code) {
		// Use the EntityManager to find the category with the specified code
		T c = em.find((Class<T>) Category.class, code);
		// If the category was found, remove it and return 1 (indicating success)
		if (c != null) {
			em.remove(c);
			return 1;
		}
		// If the category
		return 0;
	}

	@Override
	@PermitAll
	public T edit(T c) {
		em.merge(c);
		// Return the newly-persisted category object
		return c;
	}

}
