package com.example.book;

public class Book {
    private int bookid;
    private String title;
    private String author;

    public Book(int bookid, String title, String author) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return bookid;
    }

    public void setId(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", bookid=" 
                + bookid + ", title=" + title + "]";
    }
}
