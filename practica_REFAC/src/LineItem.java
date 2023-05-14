public class LineItem { //REFACT: Changed class name from OrderLineItem to LineItem
    private String productName;
    private int quantity;
    private double price;

    public LineItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public double getPrice() {
        return price * quantity;
    }
}
