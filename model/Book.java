package model;

public class Book extends Media {

    private final String author;
    private final int pageCount;

    public Book(String title, String genre,
                int releaseYear, double rating,
                String status, String author,
                int pageCount) {

        super(title, genre, releaseYear, rating, status);

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(
                "Author cannot be empty."
            );
        }

        if (pageCount <= 0) {
            throw new IllegalArgumentException(
                "Page count must be positive."
            );
        }

        this.author = author;
        this.pageCount = pageCount;
    }

    
    public Book(String title, String genre,
                int releaseYear, String author,
                int pageCount) {
    
        this(title, genre, releaseYear,
             Double.NaN, "Not Started",
             author, pageCount);
    }
    

    public boolean writtenBy(String name) {
        return name != null
            && author.equalsIgnoreCase(name);
    }

    public boolean isLongerThan(int pages) {
        return pageCount > pages;
    }

    @Override
    public String displaySummary() {
        return "BOOK\n"
            + describeBasicInfo()
            + "\nAuthor: " + author
            + "\nPages: " + pageCount;
    }

}
