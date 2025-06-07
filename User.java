import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<String> orderHistory;

    public User(String name) {
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public void addToOrderHistory(String order) {
        orderHistory.add(order);
    }

    public void viewOrderHistory() {
        System.out.println("Order History for " + name + ":");
        for (String order : orderHistory) {
            System.out.println("- " + order);
        }
    }
}

