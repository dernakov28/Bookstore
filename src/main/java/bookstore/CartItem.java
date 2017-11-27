package bookstore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //    public Order getOrder() {
//        return order;
//    }
//
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    @ManyToOne
    private Book book;

    public void setId(long id) {
        this.id = id;
    }

//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Column(name = "amount")

    private int amount;

    protected CartItem() {
    }

    public long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return book.toString() + ": " + amount;
    }
}
