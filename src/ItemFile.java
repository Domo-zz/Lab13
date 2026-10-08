import java.io.*;
import java.util.ArrayList;

public class ItemFile {
    public static final String FILE_NAME = "sell.txt";

    public static void save(ArrayList<Item> items) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                out.println(item.getName() + " , " + item.getPrice() + " , " + item.getQuantity());
            }
        }
    }

    public static ArrayList<Item> load() throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                int quantity = Integer.parseInt(parts[2].trim());
                items.add(new Item(name, price, quantity));
            }
        }
        return items;
    }
}
