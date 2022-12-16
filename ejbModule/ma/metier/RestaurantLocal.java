package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Restaurant;

@Local
public interface RestaurantLocal {
	Restaurant addRestaurant(Restaurant c);
	Restaurant getRestaurant(Integer code);
	int deleteRestaurant(Integer code);
	Restaurant editRestaurant(Restaurant c);

}
