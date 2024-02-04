package sof03.bookstore.domain;

public class Book {

    String title;
    String author;
    String publicationYear;
    String isbn;
    double price;




    

    // kontruktorit
    public Book(String title, String author, String publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // getterit
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public double getPrice() {
        return price;
    }

    // setterit
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

    
    
}
