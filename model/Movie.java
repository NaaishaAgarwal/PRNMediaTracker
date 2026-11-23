
package model;

public class Movie extends Media {

    private final String director;
    private final int durationMinutes;

    public Movie(String title, String genre,
                 int releaseYear, double rating,
                 String status, String director,
                 int durationMinutes) {

        super(title, genre, releaseYear, rating, status);

        if (director == null || director.isBlank()) {
            throw new IllegalArgumentException(
                "Director cannot be empty."
            );
        }

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                "Duration must be positive."
            );
        }

        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public boolean directedBy(String name) {
        return name != null
            && director.equalsIgnoreCase(name);
    }

    public boolean isLongerThan(int minutes) {
        return durationMinutes > minutes;
    }

    @Override
    public String displaySummary() {
        return "MOVIE\n"
            + describeBasicInfo()
            + "\nDirector: " + director
            + "\nDuration: " + durationMinutes
            + " minutes";
    }
}
