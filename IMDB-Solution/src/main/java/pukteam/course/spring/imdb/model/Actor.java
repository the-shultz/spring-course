package pukteam.course.spring.imdb.model;

public class Actor {
    private int id;
    private String fullName;
    private int age;
    private Gender gender;

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

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
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
