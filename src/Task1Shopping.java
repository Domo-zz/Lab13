import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<>();

        String again;
        do {
            System.out.print("Enter the name of the item: ");
            String name = sc.nextLine();
            System.out.print("Enter the unit price: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Enter the quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            cart.add(new Item(name, price, quantity));

            System.out.print("Continue shopping (y/n)? ");
            again = sc.nextLine();
        } while (again.equalsIgnoreCase("y"));

        printCart(cart);

        try {
            ItemFile.save(cart);
            System.out.println("Saved to " + ItemFile.FILE_NAME);
        } catch (IOException e) {
            System.out.println("Cannot write file: " + e.getMessage());
        }
    }

    private static void printCart(ArrayList<Item> cart) {
        double sum = 0;
        System.out.println("\nFinal Shopping Cart totals");
        for (Item item : cart) {
            System.out.printf("%-12s $%-8.2f %-4d $%.2f%n",
                    item.getName(), item.getPrice(), item.getQuantity(), item.getTotal());
            sum += item.getTotal();
        }
        System.out.printf("Total $ Amount in Cart: $%.2f%n", sum);
    }
}
