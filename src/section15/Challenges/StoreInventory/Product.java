package section15.Challenges.StoreInventory;

enum Category {DAIRY, VEGETABLES}

public class Product implements Comparable<Product> {
    
    //  Product information is defined by manufacturer;
    //  Assume information on product is immutable;

    // sku              (stock keeping unit; behaves as a unique ID)
    // name
    // manufacturer
    // category         (should be a defined set of categories, e.g. dairy, vegetables, etc.)

    private static int skuInit = 1;
    private int sku;
    private String name;
    private String manufacturer;
    private Category category;

    public Product(String name, String manufacturer, Category category) {
        this.sku = skuEncoder(category) + skuInit++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public int getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    private static int skuEncoder(Category category) {
        String s = category.toString().toUpperCase();
        int c1 = (int) s.charAt(0);
        int c2 = (int) s.charAt(1);
        int c3 = (int) s.charAt(2);

        int sku = c1 * 10_000_000 + 
                    c2 * 100_000 +
                    c3 * 100;
        
        return sku;

    }

    @Override
    public String toString() {
        return "[%010d]    %-16s %-16s %-8s".formatted(sku, name, manufacturer, category);
    }

    @Override
    public int hashCode() {
        return sku;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (sku != other.sku)
            return false;
        return true;
    }

    @Override
    public int compareTo(Product o) {
        
        int c = this.category.compareTo(o.category);
        if (c != 0) {
            return c;
        }

        int m = this.manufacturer.compareTo(o.manufacturer);
        if (m != 0) {
            return m;
        }

        return Integer.compare(this.sku, o.sku);

    }

    

}
