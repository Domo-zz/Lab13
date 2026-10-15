import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2SalesReport {
    public static void main(String[] args) {
        ArrayList<Item> items;
        try {
            items = ItemFile.load();
        } catch (IOException e) {
            System.out.println("Cannot read " + ItemFile.FILE_NAME + " (run Task1Shopping first): " + e.getMessage());
            return;
        }

        ArrayList<String> names = getDistinctNames(items);
        Scanner sc = new Scanner(System.in);

        System.out.println("Products in sales data:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
        System.out.print("Select product number: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice < 1 || choice > names.size()) {
            System.out.println("Invalid choice");
            return;
        }
        showSales(items, names.get(choice - 1));
    }

    private static ArrayList<String> getDistinctNames(ArrayList<Item> items) {
        ArrayList<String> names = new ArrayList<>();
        for (Item item : items) {
            if (!names.contains(item.getName())) {
                names.add(item.getName());
            }
        }
        return names;
    }

    private static void showSales(ArrayList<Item> items, String name) {
        System.out.println("\nSales of " + name);
        System.out.printf("%-12s %-9s %-9s %s%n", "Name", "Price", "Quantity", "Sales");
        for (Item item : items) {
            if (item.getName().equals(name)) {
                System.out.printf("%-12s $%-8.2f %-9d $%.2f%n",
                        item.getName(), item.getPrice(), item.getQuantity(), item.getTotal());
            }
        }
    }
}
