package section15.Challenges.StoreInventory;

public class InventoryItem implements Comparable<InventoryItem> {
    
    //  InventoryItem is the store's information specific to the product;

    // product
    // qtyTotal         (qtyWareHouse + qtyAisles + qtyCarts)
    // qtyReserved      (qtyCarts not yet sold)
    // qtyReorder       (qty to order from manufacturer when qtyLow is hit)
    // qtyLow           (trigger to order product from manufacturer)
    // salesPrice

    private Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReordered;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, double salesPrice, int qtyReordered, int qtyLow) {
        this.product = product;
        this.qtyReordered = qtyReordered;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;
        this.qtyTotal = 0;
        this.qtyReserved = 0;
    }

    public Product getProduct() {
        return product;
    }
    
    public double getSalesPrice() {
        return salesPrice;
    }

    //  reserveItem
    boolean reserveItem(int qtyOrder) {
        int qtyAvailable = qtyTotal - qtyReserved;
        String productName = this.product.getName();
        if (qtyOrder <= qtyAvailable) {
            qtyReserved+=qtyOrder;
            System.out.println("Reserved #%d units of %s. SUCCESS".formatted(qtyOrder, productName));
            return true;
        }
        else {
            System.out.println("Cannot reserve #%d of %s. Insufficient inventory: only #%d available units! FAILURE"
                    .formatted(qtyOrder, productName, qtyAvailable)
            );
        }
        return false;
    }

    //  releaseItem
    boolean releaseItem(int qtyOrder) {
        String productName = this.product.getName();
        if (qtyOrder <= qtyReserved && qtyOrder <= qtyTotal) {
            qtyReserved-=qtyOrder;
            System.out.println("#%d units of %s have had their reservation canceled. SUCCESS"
                    .formatted(qtyOrder, productName)
            );
            return true;
        }
        else {
            System.out.println("Something went wrong. FAILURE");
        }
        return false;
    }

    //  sellItem
    boolean sellItem(int qtyOrder) {
        String productName = this.product.getName();
        if (qtyOrder <= qtyReserved && qtyOrder <= qtyTotal) {
            qtyReserved-=qtyOrder;
            qtyTotal-=qtyOrder;
            System.out.println("Sold #%d units of %s for %.2f each. SUCCESS"
                    .formatted(qtyOrder, productName, salesPrice)
            );
            return true;
        }
        else {
            System.out.println("Something went wrong. FAILURE");
        }
        return false;
    }

    //  placeInventoryOrder 
    boolean placeInventoryOrder() {
        String productName = this.product.getName();
        if (qtyTotal <= qtyLow) {
            qtyTotal+=qtyReordered;
            System.out.println("Low stocks of %s. Ordering %d more units from %s. SUCCESS"
                    .formatted(productName, qtyReordered, product.getManufacturer())
            );
            return true;
        }
        else {
            System.out.println("%s is still in stock with #%d units."
                    .formatted(productName, qtyTotal)
            );
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "%-12s [%d]  %-12s %-4.2f$    %-12s %6d %6d"
            .formatted(
                product.getCategory(),
                product.getSku(),
                product.getName(),
                salesPrice,
                product.getManufacturer(),
                qtyTotal,
                qtyReserved
            );
    }

    @Override
    public int hashCode() {
        return this.product.getSku();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryItem other = (InventoryItem) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public int compareTo(InventoryItem o) {

        return this.getProduct().compareTo(o.getProduct());

    }

    

}
