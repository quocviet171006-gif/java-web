package murach.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private BigDecimal price;

    public Product() {
        this("", "", BigDecimal.ZERO);
    }

    public Product(String code, String description, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public String getPriceCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }
}