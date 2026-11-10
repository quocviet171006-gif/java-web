package murach.business;

import java.io.Serializable;
import java.util.List;

public class Survey implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String source;
    private final boolean announcements;
    private final boolean newProducts;
    private final List<String> contactMethods;

    public Survey(String source, boolean announcements,
                  boolean newProducts, List<String> contactMethods) {
        this.source = source;
        this.announcements = announcements;
        this.newProducts = newProducts;
        this.contactMethods = List.copyOf(contactMethods);
    }

    public String getSource() { return source; }
    public boolean isAnnouncements() { return announcements; }
    public boolean isNewProducts() { return newProducts; }
    public List<String> getContactMethods() { return contactMethods; }
    public String getContactMethodsDisplay() {
        return contactMethods.isEmpty() ? "None selected" : String.join(", ", contactMethods);
    }
}