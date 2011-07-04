package fr.xebia.workshop.tdd.bugfix;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBookingService {

	private ShowDao showDao = new ShowDao();
	
	public Set<Show> retrieveShowsBelowOrEqualToPrice(double maximumPrice){
		List<Show> allShows = showDao.getAllShows();
		Set<Show> returnedShows = new HashSet<Show>();
		for (Show show : allShows) {
			if(show.getPrice() < maximumPrice){
				returnedShows.add(show);
			}
		}
		return returnedShows;
	}
	
	public double calculateBasket(Show... showsInBasket){
		double totalPrice = 0d;
		for (Show show : showsInBasket) {
			totalPrice = totalPrice + show.getPrice();
		}
		return addTax(totalPrice);
	}
	
	private double addTax(double price){
		return (0.10f*price) + price; 
	}
}
