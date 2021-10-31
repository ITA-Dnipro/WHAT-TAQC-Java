package api.entities.courses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import util.RandomStringsGenerator;

public class Course {
    @JsonAlias ({"active", "isActive"})
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
}
