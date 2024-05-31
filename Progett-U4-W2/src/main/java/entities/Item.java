package entities;

public class Item {
    private int ISBN;
    private String title;
    private int pubblicationYear;
    private int pagesNumber;

    public Item(int ISBN, String title, int pubblicationYear, int pagesNumber){
        this.ISBN = 1111;
        this.title = title;
        this.pubblicationYear = pubblicationYear;
        this.pagesNumber = pagesNumber;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPubblicationYear() {
        return pubblicationYear;
    }

    public void setPubblicationYear(int pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

}
