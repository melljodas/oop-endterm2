import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private String condition;
    private double price;
    private int number;
    private String sellerName;
    private String sellerContact;

    public Item(String name, String condition, double price, int number, String sellerName, String sellerContact) {
        this.name = name;
        this.condition = condition;
        this.price = price;
        this.number = number;
        this.sellerName = sellerName;
        this.sellerContact = sellerContact;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerContact() {
        return sellerContact;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", sellerName='" + sellerName + '\'' +
                ", sellerContact='" + sellerContact + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Search Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Choose operation (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter item condition: ");
                    String condition = scanner.next();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item number: ");
                    int number = scanner.nextInt();
                    System.out.print("Enter seller's name: ");
                    String sellerName = scanner.next();
                    System.out.print("Enter seller's contact: ");
                    String sellerContact = scanner.next();
                    items.add(new Item(name, condition, price, number, sellerName, sellerContact));
                    break;
                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.next().toLowerCase();
                    System.out.println("Search results:");
                    boolean found = false;
                    for (Item item : items) {
                        if (item.getName().toLowerCase().contains(keyword) || item.getCondition().toLowerCase().contains(keyword)) {
                            System.out.println(item);
                            System.out.println("Seller's Name: " + item.getSellerName());
                            System.out.println("Seller's Contact: " + item.getSellerContact());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No items found with the given keyword.");
                    }
                    break;
                case 3:
                    System.out.print("Enter item number to remove: ");
                    int removeNumber = scanner.nextInt();
                    boolean removed = false;
                    for (Item item : items) {
                        if (item.getNumber() == removeNumber) {
                            items.remove(item);
                            System.out.println("Item removed successfully.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Item with the given number not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Sorry, such action is not available. Please try again.");
            }
        }
    }
}
