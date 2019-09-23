package pukteam.course.spring.imdb.model;

public class EgoMetrics {

    private int totalMovies;
    private double averageRating;

    public EgoMetrics() {
        totalMovies = 0;
        averageRating = 0;
    }

    public void addParticipatingMovieRating(int rating) {
        double sum = totalMovies * averageRating;
        sum+= rating;
        totalMovies++;
        averageRating = sum / totalMovies;
    }

    public int getTotalMovies() {
        return totalMovies;
    }

    public double getAverageRating() {
        return averageRating;
    }

    @Override
    public String toString() {
        return "EgoMetrics{" +
                "totalMovies=" + totalMovies +
                ", averageRating=" + averageRating +
                '}';
    }
}
