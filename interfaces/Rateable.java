package interfaces;
public interface Rateable {
    
    void rate(double stars);
    boolean isRated();
    String displayRating();
    int compareRatingTo(Rateable other);
    
}