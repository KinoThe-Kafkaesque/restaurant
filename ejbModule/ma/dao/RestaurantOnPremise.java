package ma.dao;
import java.util.List;
import javax.ejb.Local;
@Local
public interface RestaurantOnPremise<T> {
    T add(T c);
    T get(Integer code);
    int delete(Integer code);
    T edit(T c);
    List<T> getAll();
}