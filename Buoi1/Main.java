package Buoi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        // Đặt encoding cho output
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in, StandardCharsets.UTF_8);
        String msg = """
                Chương trình quản lý sách
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin
                5. Tìm sách theo tên
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm theo tác giả
                0. Thoát
                Chọn chức năng: """;
        
        int chon = 0;
        do {
            System.out.printf(msg);
            try {
                chon = Integer.parseInt(x.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
                System.out.println("Vui lòng nhập số!");
                continue;
            }
            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input(x);
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhập vào mã sách cần xóa:");
                    int bookId = Integer.parseInt(x.nextLine());
                    // Tìm và xóa sách
                    Book find = listBook.stream().filter(p -> p.getId() == bookId).findFirst().orElse(null);
                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Đã xóa sách thành công");
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                }
                case 3 -> {
                    System.out.print("Nhập vào mã sách cần điều chỉnh:");
                    int bookId = Integer.parseInt(x.nextLine());
                    Book find = listBook.stream().filter(p -> p.getId() == bookId).findFirst().orElse(null);
                    if (find != null) {
                        find.input(x);
                        System.out.println("Đã cập nhật sách thành công");
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                }
                case 4 -> {
                    System.out.println("In xuất thông tin danh sách:");
                    listBook.forEach(p -> p.output());
                }
                case 5 -> {
                    System.out.print("Nhập từ khóa tìm kiếm trong tên sách:");
                    String keyword = x.nextLine();
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                            .toList();
                    if (list5.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list5.forEach(Book::output);
                    }
                }
                case 6 -> {
                    System.out.print("Nhập số lượng sách muốn lấy:");
                    int limit = Integer.parseInt(x.nextLine());
                    System.out.print("Nhập giá tối thiểu:");
                    double minPrice = Double.parseDouble(x.nextLine());
                    List<Book> list6 = listBook.stream()
                            .filter(p -> p.getPrice() >= minPrice)
                            .limit(limit)
                            .toList();
                    if (list6.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list6.forEach(Book::output);
                    }
                }
                case 7 -> {
                    Set<String> authorSet = new HashSet<>();
                    System.out.print("Nhập tên các tác giả (cách nhau bởi dấu phẩy):");
                    String authorsInput = x.nextLine();
                    String[] authors = authorsInput.split(",");
                    for (String author : authors) {
                        authorSet.add(author.trim().toLowerCase());
                    }
                    List<Book> list7 = listBook.stream()
                            .filter(p -> authorSet.contains(p.getAuthor().toLowerCase()))
                            .toList();
                    if (list7.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào!");
                    } else {
                        list7.forEach(Book::output);
                    }
                }
            }
        } while (chon != 0);
    }
}