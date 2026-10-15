public class Item {
    private String name;
    private double price;
    private int quantity;
    private double total;

    public Item(String name, double price, int quantity) {
        this(name, price, quantity, price * quantity);
    }

    public Item(String name, double price, int quantity, double total) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }
}
