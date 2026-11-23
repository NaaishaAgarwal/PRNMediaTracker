package mediaTracker;
import model.Book;
import model.Movie;
import model.TVShow;
import model.Media;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== MEDIA TRACKER TESTS ===");

        Book book = new Book(
            "The Hunger Games",
            "Dystopian",
            2008,
            "Suzanne Collins",
            374
        );

        Movie movie = new Movie(
            "Interstellar",
            "Sci-Fi",
            2014,
            Double.NaN,
            "Not Started",
            "Christopher Nolan",
            169
        );

        TVShow show = new TVShow(
            "Stranger Things",
            "Sci-Fi",
            2016,
            Double.NaN,
            "Not Started",
            "The Duffer Brothers",
            5,
            42
        );

        System.out.println("\n=== TEST 1: CONSTRUCTORS ===");

        System.out.println(book.displaySummary());
        System.out.println();
        System.out.println(movie.displaySummary());
        System.out.println();
        System.out.println(show.displaySummary());

        System.out.println("\n=== TEST 2: RATINGS ===");

        book.rate(4.5);
        movie.rate(5.0);

        System.out.println(book.displayRating());
        System.out.println(movie.displayRating());
        System.out.println(show.displayRating());

        System.out.println("Book rated? " + book.isRated());
        System.out.println("Show rated? " + show.isRated());

        System.out.println("\n=== TEST 3: RATING COMPARISON ===");

        System.out.println(
            "Book vs Movie: " + book.compareRatingTo(movie)
        );

        System.out.println("\n=== TEST 4: STATUS ===");

        book.start();
        System.out.println(
            "Book in progress? " + book.isInProgress()
        );

        book.finish();
        System.out.println(
            "Book completed? " + book.isCompleted()
        );

        System.out.println("\n=== TEST 5: SEARCH ===");

        System.out.println(
            "Matches title? "
            + book.matchesTitle("the hunger games")
        );

        System.out.println(
            "Matches genre? "
            + movie.matchesGenre("sci-fi")
        );

        System.out.println("\n=== TEST 6: TITLE COMPARISON ===");

        System.out.println(
            "Book vs Movie title: "
            + book.compareTitleTo(movie)
        );

        System.out.println("\n=== TEST 7: SUBCLASS METHODS ===");

        System.out.println(
            "Written by Suzanne Collins? "
            + book.writtenBy("Suzanne Collins")
        );

        System.out.println(
            "Directed by Christopher Nolan? "
            + movie.directedBy("Christopher Nolan")
        );

        show.watchEpisode();

        System.out.println(show.displaySummary());

        System.out.println("\n=== TEST 8: POLYMORPHISM ===");

        Media[] collection = {book, movie, show};

        for (Media item : collection) {
            System.out.println(item.displaySummary());
            System.out.println("--------------------");
        }

        System.out.println("\n=== TEST 9: EXCEPTION HANDLING ===");

        try {
            book.rate(10.0);
            System.out.println("FAIL: Invalid rating accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Invalid rating rejected");
        }

        System.out.println("\n=== TESTS FINISHED ===");
    }
}

