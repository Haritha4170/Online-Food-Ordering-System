import java.util.*;

public class FoodOrderingSystem {
    private ArrayList<Restaurant> restaurants;
    private Scanner scanner;
    private User user;

    public FoodOrderingSystem() {
        restaurants = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        user = new User(name);

        while (true) {
            System.out.println("\n--- Food Ordering System ---");
            System.out.println("1. Admin - Add Restaurant/Menu");
            System.out.println("2. User - Browse & Order");
            System.out.println("3. View Order History");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: adminSection(); break;
                case 2: userSection(); break;
                case 3: user.viewOrderHistory(); break;
                case 4: System.out.println("Thank you!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void adminSection() {
        System.out.print("Restaurant Name: ");
        String rName = scanner.nextLine();
        System.out.print("Location: ");
        String rLoc = scanner.nextLine();
        Restaurant res = new Restaurant(rName, rLoc);

        while (true) {
            System.out.print("Add Menu Item (name or 'done'): ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("done")) break;
            System.out.print("Price: ");
            double price = scanner.nextDouble(); scanner.nextLine();
            res.addMenuItem(item, price);
        }
        restaurants.add(res);
        System.out.println("Restaurant added successfully.");
    }

    private void userSection() {
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants available.");
            return;
        }

        System.out.println("Available Restaurants:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i));
        }

        System.out.print("Choose restaurant: ");
        int index = scanner.nextInt() - 1; scanner.nextLine();

        if (index < 0 || index >= restaurants.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Restaurant selected = restaurants.get(index);
        ArrayList<MenuItem> menu = selected.getMenu();
        if (menu.isEmpty()) {
            System.out.println("No items in this restaurant.");
            return;
        }

        System.out.println("Menu of " + selected.getName() + ":");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        System.out.print("Choose item to order: ");
        int itemIndex = scanner.nextInt() - 1; scanner.nextLine();

        if (itemIndex < 0 || itemIndex >= menu.size()) {
            System.out.println("Invalid item.");
            return;
        }

        MenuItem selectedItem = menu.get(itemIndex);
        user.addToOrderHistory(selectedItem.getName() + " from " + selected.getName());
        System.out.println("Order placed for " + selectedItem);
    }
}
