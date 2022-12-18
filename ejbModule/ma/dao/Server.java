package ma.dao;

import java.util.List;

import javax.ejb.Remote;
import ma.entites.Restaurant;
@Remote
public interface Server<T> {
    T add(T c);
    T get(Integer code);
    int delete(Integer code);
    T edit(T c);
    List<T> getAll();
}