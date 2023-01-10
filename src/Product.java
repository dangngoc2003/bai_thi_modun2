import java.util.Comparator;

public class Product implements Comparator<Product> {
    String code;
    String name;
    double price;
    int quantity;
   String description;

    public Product() {
    }

    public Product(String code, String name, double price, int quantity, String description) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void display() {
        System.out.printf("%-15s%-15s%-15s%-30s%s",
                code, name, price, quantity, description + "\n");
    }

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }

    @Override
    public String toString() {
        return code+","+name+","+price+","+quantity+","+description;
    }
}

