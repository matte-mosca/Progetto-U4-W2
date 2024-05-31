package matteomoscardini;

import com.github.javafaker.Faker;
import entities.Archive;
import entities.Book;
import entities.Magazine;
import entities.PublicationFrequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Scanner;

public class Application {

    private static final  Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        Faker faker = new Faker(Locale.ITALIAN);

        Scanner scanner = new Scanner(System.in);
        Archive archive = new Archive();



       int ISBN = 0;
       while (true) {
           if (scanner.hasNextInt()){
               ISBN = scanner.nextInt();
               break;
           }
           else {
               logger.info("Insert a valid code");
               scanner.next();
           }
       }
       logger.info("Digit true to add a book, false for a magazine");
       boolean choice = true;

       while(true){
           String input = scanner.next().trim().toLowerCase();
           if (input.equals("true") || input.equals("false")){
               choice = Boolean.parseBoolean(input);
               break;
           }
           else {logger.info("Wrong message please insert true or false");}
       }
       if (choice) {
           Book add = new Book(
                   ISBN,
                   faker.book().title(),
                   faker.random().nextInt(1600, 2024),
                   faker.random().nextInt(80, 900),
                   faker.book().author(),
                   faker.book().genre());

                   logger.info("Element to add");
                   logger.info(add.toString());
                   archive.addElement(add);
       }
       else {
           Magazine add = new Magazine(
                   ISBN,
                   faker.book().title(),
                   faker.random().nextInt(80, 900),
                   faker.random().nextInt(2000, 2024),
                   PublicationFrequency.values()[faker.random().nextInt(0, 2)]);

           logger.info("Element to add: ");
           logger.info(add.toString());
           archive.addElement(add);




       }
       logger.info(archive.toString());
    }


}
