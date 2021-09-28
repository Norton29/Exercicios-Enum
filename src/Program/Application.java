package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter client Data: ");
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birthday:(dd/mm/yyyy) ");
		Date birthDate = sdf.parse(sc.next());
		
		
		Client client = new Client(name, email, birthDate);
		
		
		System.out.println("Enter Order Data: ");
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + "Data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
		
			OrderItem orderitem = new OrderItem(quantity, productPrice, product);
			
			order.addItems(orderitem);
		}
		
		
		
		
		System.out.println("Order Summary: ");
		System.out.println(order);
		
		System.out.println("Have a nice day!");
		
		sc.close();
	}

}
