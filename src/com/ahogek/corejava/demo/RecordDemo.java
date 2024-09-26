package ahogek.corejava.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-09-26 12:06:10
 */
public class RecordDemo {

    public static void main(String[] args) {
        PersonRecord personRecord = new PersonRecord("Peter", 30);
        System.out.println(personRecord);
        System.out.println(personRecord.getUpperCaseName());
        System.out.println(personRecord.name());
        System.out.println(personRecord.age());

        PersonRecord personRecord2 = new PersonRecord("Paul", 25);
        Stream.of(personRecord, personRecord2)
                .sorted()
                .forEach(System.out::println);

        // ------

        Library.Book.Review review1 = new Library.Book.Review("Alice", 5, "Great book!");
        Library.Book.Review review2 = new Library.Book.Review("Bob", 4, "Good book!");

        Library.Book book1 = new Library.Book("1984", "George Orwell", 1949, List.of(review1, review2));

        Library library = new Library("City Library", new ArrayList<>(List.of(book1)));

        System.out.println("Average rating for 1984: " + book1.getAverageRating());

        Library.Book newBook = new Library.Book("To Kill a Mockingbird", "Harper Lee", 1960, new ArrayList<>());
        library = library.addBook(newBook);

        library.findBook("To Kill a Mockingbird").ifPresent(book -> System.out.println("Found book: " + book.title() + " by " + book.author()));
    }
}

record PersonRecord(String name, int age) implements Comparable<PersonRecord> {
    // custom constructor
    public PersonRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    // custom method
    public String getUpperCaseName() {
        return name.toUpperCase();
    }

    @Override
    public int compareTo(PersonRecord o) {
        return Integer.compare(age, o.age);
    }
}

record Library(String name, List<Book> books) {
    public Optional<Book> findBook(String title) {
        return books.stream().filter(book -> book.title().equalsIgnoreCase(title)).findFirst();
    }

    public Library addBook(Book newBook) {
        List<Book> updateBooks = new ArrayList<>(books);
        updateBooks.add(newBook);
        return new Library(name, updateBooks);
    }

    record Book(String title, String author, int year, List<Review> reviews) {
        public double getAverageRating() {
            return reviews.stream().mapToInt(Review::rating).average().orElse(0.0);
        }

        record Review(String reviewer, int rating, String comment) {
            public Review {
                if (rating < 1 || rating > 5) {
                    throw new IllegalArgumentException("Rating must be between 1 and 5.");
                }
            }

            public boolean isPositive() {
                return rating > 4;
            }
        }
    }
}