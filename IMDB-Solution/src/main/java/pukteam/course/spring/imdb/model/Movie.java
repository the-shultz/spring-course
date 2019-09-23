package pukteam.course.spring.imdb.model;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private Genre genre;
    private List<Actor> actorsInMovie;

    public Movie(int id, String name, Genre genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public void setActorsInMovie(List<Actor> actorsInMovie) {
        this.actorsInMovie = actorsInMovie;
    }

    public int getId() {
        return id;
    }

    public List<Actor> getActorsInMovie() {
        return actorsInMovie;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", actorsInMovie=" + actorsInMovie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
