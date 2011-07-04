package fr.xebia.workshop.tdd.bugfix;

import java.util.Date;

public class Show {

	private Date date;
	private String name;
	private boolean full;
	private double price;
	
	public Show(Date date, String name, double price) {
		this.date = date;
		this.name = name;
		this.price = price;
		this.full = false;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public boolean isFull() {
		return full;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	
	
	
	
}
