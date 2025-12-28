package section8.Challenges.Restaurant;

public class SideItem {

    private String type;
    private String size;
    private double basePrice;
    private double price;

    //  protecting constructors has lead to "funny" behaviours that I still cannot explain;
    protected SideItem(String type, double basePrice) {
        this.type = type;
        this.size = "M";
        this.basePrice = basePrice <= 0 ? 1D : basePrice;
        this.price = basePrice;
    }

    public static SideItem getSideItem(String type, double basePrice) {

        return new SideItem(type, basePrice);

    }

    public static SideItem getSideItem() {

        return new SideItem("Classic Fries", 1.50D);

    }

    private boolean validateSize(String size) {
        if (size == "S" || size == "s") {
            return true;
        }
        if (size == "M" || size == "m") {
            return true;
        }
        if (size == "L" || size == "l") {
            return true;
        }
        if (size == "XL" || size == "xl") {
            return true;
        }
        return false;
    }

    protected void setBasePrice(double basePrice) {
        this.basePrice = basePrice <= 0 ? 1D : basePrice;
        this.size = "M";
        this.price = basePrice;
    }

    private double setPrice() {
        return switch (this.size) {
            case "S", "s" -> this.basePrice * 0.5D;
            case "M", "m" -> this.basePrice;
            case "L", "l" -> this.basePrice * 1.5D;
            case "XL", "xl" -> this.basePrice * 2D;
            default -> this.basePrice;
        };
    }

    protected void setSize(String size) {
        this.size = validateSize(size) ? size : "M";
        this.price = setPrice();
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SideItem [type=" + type + ", size=" + size + ", price=" + price + "]";
    }
    
}
