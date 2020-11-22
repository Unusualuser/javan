package Practice_3;

public class Book {
    String author;
    String name;
    int theYearOfPublishing;
    int pages;

    public Book(String author, String name, int theYearOfPublishing, int pages) {
        this.author = author;
        this.name = name;
        this.theYearOfPublishing = theYearOfPublishing;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTheYearOfPublishing() {
        return theYearOfPublishing;
    }

    public void setTheYearOfPublishing(int theYearOfPublishing) {
        this.theYearOfPublishing = theYearOfPublishing;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + getAuthor() + '\'' +
                ", name='" + getName() + '\'' +
                ", theYearOfPublishing=" + getTheYearOfPublishing() +
                ", pages=" + getPages() +
                '}';
    }
}
