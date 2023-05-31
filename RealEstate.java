import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Property {
    private String address;
    private double price;

    public Property(String address, double price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class RealEstateAgency {
    private List<Property> properties;

    public RealEstateAgency() {
        properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }

    public void displayProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            System.out.println("Properties:");
            for (Property property : properties) {
                System.out.println("Address: " + property.getAddress() + ", Price: $" + property.getPrice());
            }
        }
    }
}

public class RealEstateBusiness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstateAgency realEstateAgency = new RealEstateAgency();

        while (true) {
            System.out.println("1. Add Property");
            System.out.println("2. Remove Property");
            System.out.println("3. Display Properties");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Property property = new Property(address, price);
                    realEstateAgency.addProperty(property);
                    System.out.println("Property added.");
                    break;
                case 2:
                    System.out.print("Enter address: ");
                    String removeAddress = scanner.nextLine();
                    Property removeProperty = null;

                    for (Property p : realEstateAgency.getProperties()) {
                        if (p.getAddress().equals(removeAddress)) {
                            removeProperty = p;
                            break;
                        }
                    }

                    if (removeProperty != null) {
                        realEstateAgency.removeProperty(removeProperty);
                        System.out.println("Property removed.");
                    } else {
                        System.out.println("Property not found.");
                    }
                    break;
                case 3:
                    realEstateAgency.displayProperties();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
