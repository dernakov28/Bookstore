package bookstore;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @SequenceGenerator(name = "gen", sequenceName = "books_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;

    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "language")
    private String language;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "cover")
    private String cover;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "sales")
    private int sales;

    @Column(name = "image_url")
    private String imageUrl;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    protected Book() {
    }

    public Book(Book book) {
        this.name = book.getName();
        this.description = book.getDescription();
        this.author = book.getAuthor();

        this.year = book.getYear();
        this.genreId = book.genreId;
        this.language = book.getLanguage();
        this.publishingHouse = book.getPublishingHouse();

        this.cover = book.getCover();
        this.price = book.getPrice();
        this.amount = book.getAmount();
        this.sales = book.getSales();

        this.imageUrl = book.getImageUrl();

    }

    @Override
    public String toString() {
        return "Book: " + this.name + " " + this.description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getLanguage() {
        return language;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getCover() {
        return cover;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSales() {
        return sales;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId() {
        return id;
    }
}