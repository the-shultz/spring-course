package pukteam.course.spring.imdb.model;

public class Actor {
    private int id;
    private String fullName;
    private int age;
    private Gender gender;
    private EgoMetrics egoMetrics;

    public void setEgoMetrics(EgoMetrics egoMetrics) {
        this.egoMetrics = egoMetrics;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void addMovieRating(int movieRating) {
        egoMetrics.addParticipatingMovieRating(movieRating);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", egoMetrics=" + egoMetrics +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        return id == actor.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
