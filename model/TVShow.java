
package model;

public class TVShow extends Media {

    private final String creator;
    private final int totalSeasons;
    private final int totalEpisodes;

    private int episodesWatched;

    public TVShow(String title, String genre,
                  int releaseYear, double rating,
                  String status, String creator,
                  int totalSeasons, int totalEpisodes) {

        super(title, genre, releaseYear, rating, status);

        if (creator == null || creator.isBlank()) {
            throw new IllegalArgumentException(
                "Creator cannot be empty."
            );
        }

        if (totalSeasons <= 0 || totalEpisodes <= 0) {
            throw new IllegalArgumentException(
                "Seasons and episodes must be positive."
            );
        }

        this.creator = creator;
        this.totalSeasons = totalSeasons;
        this.totalEpisodes = totalEpisodes;
        this.episodesWatched = 0;
    }

    public void watchEpisode() {
        if (episodesWatched >= totalEpisodes) {
            throw new IllegalStateException(
                "All episodes have been watched."
            );
        }

        if (isNotStarted()) {
            start();
        }

        if (isCompleted()) {
            throw new IllegalStateException(
                "Cannot watch a completed show."
            );
        }

        episodesWatched++;

        if (episodesWatched == totalEpisodes) {
            finish();
        }
    }

    public boolean hasFinishedAllEpisodes() {
        return episodesWatched == totalEpisodes;
    }

    @Override
    public String displaySummary() {
        return "TV SHOW\n"
            + describeBasicInfo()
            + "\nCreator: " + creator
            + "\nSeasons: " + totalSeasons
            + "\nEpisodes watched: "
            + episodesWatched + "/" + totalEpisodes;
    }
}
