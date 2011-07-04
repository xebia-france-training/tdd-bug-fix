package fr.xebia.workshop.tdd.bugfix;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowDao {

	private static final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private static final List<Show> allShows = new ArrayList<Show>();
	
	static {
		allShows.add(new Show(parseDate("01/08/2011"), "Mamamia", 120.00));
		allShows.add(new Show(parseDate("01/08/2011"), "Notre Dame", 80.00));
		allShows.add(new Show(parseDate("02/08/2011"), "Prince", 220.00));
		allShows.add(new Show(parseDate("03/08/2011"), "Scorpions", 110.00));
		allShows.add(new Show(parseDate("04/08/2011"), "Sting", 180.00));
		allShows.add(new Show(parseDate("05/08/2011"), "Carmen", 90.00));
		allShows.add(new Show(parseDate("05/08/2011"), "Stomp", 90.00));
		allShows.add(new Show(parseDate("06/08/2011"), "Figaro", 120.00));
	}
	
	public List<Show> getAllShows() {
		return allShows;
	}
	
	private static Date parseDate(String dateAsString) {
		try {
			return formatter.parse(dateAsString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
