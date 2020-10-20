package com.example.SpringProject.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;
    //author_book ce biti ime tabele koja je nastala spajanjem tabela book i author
    //kolone se spajaju po book_id-to na serveru tj u browseru vidimo kao atribut tabele book
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns =@JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<>();

    public Book(){

    }
    public Book(String title, String isbn, String publisher){
        this.title=title;
        this.isbn=isbn;
        this.publisher=publisher;
    }

    public Book(String title, String isbn, String publisher, Set<Author> authors){
        this.title=title;
        this.isbn=isbn;
        this.publisher=publisher;
        this.authors=authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
