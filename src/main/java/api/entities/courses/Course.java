package api.entities.courses;

import com.fasterxml.jackson.annotation.JsonAlias;
import util.RandomStringsGenerator;

import java.util.Objects;

public class Course implements Cloneable{

    @JsonAlias({"active", "isActive" })
    boolean isActive;

    Integer id;
    String name;

    private Course(String name) {
        this.name = name;
    }

    public Course() {
    }

    public static Course getCourseWithRandomName() {
        return new Course(RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public Course clone() throws CloneNotSupportedException {
        return (Course) super.clone();
    }
}
