package ru.mirea.t3.p3;

class Book {
    String name;
    int pages;
    int year;
    String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String name, int pages, int year, String author) {
        this.name = name;
        this.pages = pages;
        this.year = year;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void ShowStats() {
        System.out.println();
        System.out.print("Name of the book: ");
        System.out.println(name);
        System.out.print("Author of the book: ");
        System.out.println(author);
        System.out.print("Year of the book's creation: ");
        System.out.println(year);
        System.out.print("Number of pages in the book: ");
        System.out.println(pages);
    }
}
