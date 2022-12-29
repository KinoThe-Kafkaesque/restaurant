package ma.metier;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ma.dao.AlbumOnPremise;
import ma.dao.AlbumServer;
import ma.entites.Album;

@Stateless(name = "Album")
public class AlbumEJBImpl<T extends Album> implements AlbumOnPremise<T>, AlbumServer<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public List<T> getAll() {
		TypedQuery<T> query = em.createQuery("SELECT a FROM Album a", (Class<T>) Album.class);
		return query.getResultList();
	}

	@Override
	@PermitAll
	public T add(T c) {
		// Persist the new album object using the EntityManager
		em.persist(c);
		// Return the newly-persisted album object
		return c;
	}

	@Override
	@PermitAll
	public T get(Integer code) {
		// Use the EntityManager to find the album with the specified code
		return em.find((Class<T>) Album.class, code);
	}

	@Override
	@PermitAll
	public int delete(Integer code) {
		// Use the EntityManager to find the album with the specified code
		T c = em.find((Class<T>) Album.class, code);
		// If the album was found, remove it and return 1 (indicating success)
		if (c != null) {
			em.remove(c);
			return 1;
		}
		// If the album
		return 0;
	}

	@Override
	@PermitAll
	public T edit(T c) {
		em.merge(c);
		// Return the newly-persisted album object
		return c;
	}

}
