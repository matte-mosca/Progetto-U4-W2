public class Book extends Item{
    private String author;
    private String genre;

    public Book (int ISBN, String title, int pubblicationYear, int pagesNumber){
        super(ISBN, title, pubblicationYear, pagesNumber);
    }
    public Book(int ISBN, String title, int pubblicationYear, int pagesNumber, String author, String genre){
        super(ISBN, title, pubblicationYear, pagesNumber);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return  this.getISBN() + " - Author: " + this.getAuthor()+" - Title: "+this.getTitle() + " - Genre: " + this.getGenre() + " - Pubblication year: "+ this.getPubblicationYear() + " - Lenght: " +this.getPagesNumber() + " pages";
    }


}
