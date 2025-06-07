
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String location;
    private ArrayList<MenuItem> menu;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(String itemName, double price) {
        menu.add(new MenuItem(itemName, price));
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public String toString() {
        return name + " - " + location;
    }
}
