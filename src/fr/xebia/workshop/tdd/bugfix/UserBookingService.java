package fr.xebia.workshop.tdd.bugfix;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Exercise:
 * --------
 * 
 * Fix the bugs in this order using TDD. Always write a test first before touching the code.
 * 
 * Bug 1. When I tried to retrieve the shows that are below or equal to 100 I get only 2 shows
 * when there should be 3 shows.
 * 
 * Bug 2. When I tried to retrieve the shows that are below or equal to 110 I get only 2 shows
 * when I expect 4 shows.
 * 
 * Bug 3. When I calculate the basket price I get numbers with lot of decimals 
 * when I expect a price with a format as following 256.00 (i.e. 2 decimals) 
 */
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
