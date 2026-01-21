package Buoi1;

import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book() {
    }

    // Constructor with parameters
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Input method
    public void input(Scanner x) {
        System.out.print("Nhập mã sách:");
        this.id = Integer.parseInt(x.nextLine());
        System.out.print("Nhập tên sách:");
        this.title = x.nextLine();
        System.out.print("Nhập Tác giả:");
        this.author = x.nextLine();
        System.out.print("Nhập Đơn giá:");
        this.price = Double.parseDouble(x.nextLine());
    }

    // Output method
    public void output() {
        System.out.println("========================================");
        System.out.println("Mã sách: " + id);
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Đơn giá: " + String.format("%,.0f", price) + " VNĐ");
        System.out.println("========================================");
    }
}
