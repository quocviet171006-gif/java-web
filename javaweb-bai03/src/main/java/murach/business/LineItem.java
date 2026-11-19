package murach.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class LineItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Product product;
    private int quantity;

    public LineItem() {}

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public BigDecimal getTotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
    public String getTotalCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getTotal());
    }
}