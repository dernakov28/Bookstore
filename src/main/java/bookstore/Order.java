package bookstore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {


    public Order(Order order) {
        this.cartItems = order.getCartItems();
        this.customerName = order.getCustomerName();
        this.customerEmail = order.getCustomerEmail();
        this.customerPhone = order.getCustomerPhone();
        this.notes = order.getNotes();
        this.datetime = order.getDatetime();
    }

    protected Order() {}
    public long getId() {
        return id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getNotes() {
        return notes;
    }

    public String getDatetime() {
        return datetime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            this.cartItems.add(item);
        }
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "notes")
    private String notes;

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "processed")
    private Boolean processed = false;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Column(name = "sum")
    private int sum;
}
