package ma.metier;

import java.util.List;
import javax.ejb.Remote;
import ma.entites.Restaurant;
@Remote
public interface RestaurantRemote {
	Restaurant addRestaurant(Restaurant c);
	Restaurant getRestaurant(Integer code);
	List<Restaurant> listRestaurants();
	public int deleteRestaurant(Integer code) ;
}
