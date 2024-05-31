package entities;

public class Magazine extends Item {
    private PublicationFrequency publicationFrequency;

    public Magazine (int ISBN, String title, int pagesNumber, int publicationYear,  PublicationFrequency publicationFrequency) {
        super (ISBN, title, pagesNumber, publicationYear);
        this.publicationFrequency = publicationFrequency;
    }

    public PublicationFrequency getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(PublicationFrequency publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    public String toString() {
        return this.getISBN() + " - Title: "+this.getTitle() + " - Pubblication year: "+ this.getPubblicationYear() + " - Publication Frequency: " +this.getPublicationFrequency() +" - Lenght: " +this.getPagesNumber() + " pages";

    }
}
