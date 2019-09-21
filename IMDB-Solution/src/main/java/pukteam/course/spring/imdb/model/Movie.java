package pukteam.course.spring.imdb.model;

public class Movie {
    private int id;
    private String name;
    private Genre genre;
    private Actor mainActor;
    private Actor secondaryActor;

    public Movie(int id, String name, Genre genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public void setMainActor(Actor mainActor) {
        this.mainActor = mainActor;
    }

    public void setSecondaryActor(Actor secondaryActor) {
        this.secondaryActor = secondaryActor;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", mainActor=" + mainActor +
                ", secondaryActor=" + secondaryActor +
                '}';
    }
}
