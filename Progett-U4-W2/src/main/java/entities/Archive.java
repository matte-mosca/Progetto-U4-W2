package entities;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Archive {
    private Faker faker = new Faker(Locale.ITALIAN);
    private Map<Integer, Item> content;

    public Archive(){
        content = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Item newItem = faker.random().nextBoolean() ?
                    new Book(
                            faker.random().nextInt(0 ,1111),
                            faker.book().title(),
                            faker.random().nextInt(1600, 2024),
                            faker.random().nextInt(80, 900),
                            faker.book().author(),
                            faker.book().genre()
                    )
                    : new Magazine(
                            faker.random().nextInt(0, 1111),
                            faker.book().title(),
                    faker.random().nextInt(2000, 2024),
                    faker.random().nextInt(80, 900),
                    PublicationFrequency.values()[faker.random().nextInt(0, PublicationFrequency.values().length - 1)]);
            content.put(newItem.getISBN(), newItem);
        }
    }

    @Override
    public String toString(){
        return content.values().stream()
                .map(Item::toString)
                .collect(Collectors.joining("\n", "Archive:\n", " "));
    }

    //ADD and Remove element from archive.

    public void  addElement (Item element) {
        if (!content.containsKey(element.getISBN())){
            content.put(element.getISBN(), element);
            System.out.println("Element " +element.getISBN()+" added to archive");
        }
        else {
            System.out.println("There is already an element with this ISBN code");
        }
    }

    public void removeElement(Item element) {
        if (content.containsKey(element.getISBN())) {
            content.remove(element.getISBN());
            System.out.println(element.getClass().getSimpleName() + " removed from archive.");
        }
        else {
            System.out.println("There are no elements with this code.");
        }
    }

    public ArrayList<Item> searchByPubYear (int year) {
        return (ArrayList<Item>) content.values().stream()
                .filter(item -> item instanceof Book && ((Book) item).getPubblicationYear() == year)
                .collect(Collectors.toList());
    }
    public ArrayList<Item> searchByAuthor (String author){
        return (ArrayList<Item>) content.values().stream()
                .filter(item -> item instanceof Book && ((Book) item).getAuthor().equals(author))
                .collect(Collectors.toList());
    }
    public Item searchByISBN(int isbn) {
        return content.get(isbn);
    }
    

}
