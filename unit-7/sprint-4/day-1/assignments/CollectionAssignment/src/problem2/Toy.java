package problem2;

public class Toy {

    private final String toyNumber;
    private String toyName;
    private double price;
    private String category;

    public Toy(String toyNumber, String toyName, double price, String category) {
        this.toyNumber = toyNumber;
        this.toyName = toyName;
        this.price = price;
        this.category = category;
    }

    public String getToyNumber() {
        return toyNumber;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return
                "toyNumber='" + toyNumber + '\'' +
                ", toyName='" + toyName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'';
    }
}
