package murach.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<LineItem> items = new ArrayList<>();

    public ArrayList<LineItem> getItems() { return items; }
    public int getCount() { 
        return items.size(); 
    }

    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (LineItem existingItem : items) {
            if (existingItem.getProduct().getCode().equals(code)) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        items.removeIf(existingItem -> existingItem.getProduct().getCode().equals(code));
    }

    public BigDecimal getTotal() {
        return items.stream().map(LineItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getTotalCurrencyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getTotal());
    }
}