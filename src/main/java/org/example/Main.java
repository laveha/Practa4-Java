import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String brand;
    String company;

    public Product(String brand, String company) {
        this.brand = brand;
        this.company = company;
    }

    @Override
    public String toString() {
        return brand + " (" + company + ")";
    }
}

class Client {
    String name;
    String email;
    String phoneNumber;
    ArrayList<Product> products;
    int quantity;

    public Client(String name, String email, String phoneNumber, ArrayList<Product> products, int quantity) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.products = products;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Client: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nProduct: " + products.toString() + "\nQuantity: " + quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] companies = {"Company A", "Company B", "Company C"};
        String[][] items = {{"Item1", "Brand1"}, {"Item2", "Brand2"}, {"Item3", "Brand3"}};
        ArrayList<Client> clients = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Client client = createClient(companies, items);
            clients.add(client);
        }

        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));
            System.out.println("-----------------------");
        }
    }

    public static Client createClient(String[] companies, String[][] items) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client name:");
        String name = scanner.nextLine();
        System.out.println("Enter client email:");
        String email = scanner.nextLine();
        System.out.println("Enter client phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Available items:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ". " + items[i][0] + " - " + items[i][1]);
        }

        System.out.println("Enter item index:");
        int itemIndex = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(items[itemIndex][0], items[itemIndex][1]));

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        return new Client(name, email, phoneNumber, productList, quantity);
    }
}
