package model;

import interfaces.Rateable;

public abstract class Media implements interfaces.Rateable {
    // Data

    private String title;
    private String genre;
    private int releaseYear;
    private double rating = Double.NaN;
    private String status;
    
    protected Media (String title, String genre, int releaseYear, double rating, String status) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.status = status;
    }

    public void start() {
        status = "In Progress";
    }

    public void finish() {
        status = "Completed";
    }

    public boolean isCompleted() {
        return status.equals("Completed");
    }

    public boolean isInProgress() {
        return status.equals("In Progress");
    }

    public boolean isNotStarted() {
        return status.equals("Not Started");
    }

    public boolean matchesTitle(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    public boolean matchesGenre(String genre) {
        return this.genre.equalsIgnoreCase(genre);
    }

    public int compareTitleTo(Media other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    protected String describeBasicInfo() {
        String ratingText;

        if (isRated()) {
            ratingText = rating + "/5";
        } else {
            ratingText = "Not rated";
        }

        return "Title: " + title
            + "\nGenre: " + genre
            + "\nYear: " + releaseYear
            + "\nRating: " + ratingText
            + "\nStatus: " + status;
    }

    public abstract String displaySummary();

    
    @Override
    public void rate(double stars) {
        if (!Double.isFinite(stars) || stars < 0 || stars > 5) {
            throw new IllegalArgumentException(
                "Rating must be between 0 and 5."
            );
        }

        this.rating = stars;
    }

    @Override
    public boolean isRated() {
        return !Double.isNaN(rating);
    }

    @Override
    public String displayRating() {
        if (isRated()) {
            return("Rating: " + rating + "/5");
        } else {
            return("Not rated yet.");
        }
    }

    @Override
    public int compareRatingTo(Rateable other) {
        if (!(other instanceof Media)) {
            throw new IllegalArgumentException(
                "Can only compare ratings with other media."
            );
        }

        Media otherMedia = (Media) other;

        if (!isRated() && !otherMedia.isRated()) {
            return 0;
        }

        if (!isRated()) {
            return -1;
        }

        if (!otherMedia.isRated()) {
            return 1;
        }

        return Double.compare(this.rating, otherMedia.rating);
    }


}