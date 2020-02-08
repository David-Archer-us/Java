

public final class Product {
	private final String productName;
	private final String productDescription;
	private final double price;
	private final double maxToBeOrdered;
	
	public Product(String name, String description, double dPrice, double max) {
		productName = name;
		productDescription = description;
		price = dPrice;
		maxToBeOrdered = max;
	}
	
	public String getProductName() {
		return productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public double getPrice() {
		return price;
	}
	public double getMaxToBeOrdered() {
		return maxToBeOrdered;
	}
	
	public String toString() {
		String s = "\nProduct Name: " + productName +
				"\nProduct Description: " + productDescription +
				"\nPrice: $" + price +
				"\nMaximum quantity allowed to be ordered: " + maxToBeOrdered;
		return s;
	}

}
