package api.entities.courses;

import util.RandomStringsGenerator;

public class ExistCourse {

    Integer id;
    boolean isActive;
    String name;

    private ExistCourse(String name) {
        this.name = name;
    }

    public ExistCourse() {
    }

    public static ExistCourse getCourseWithRandomName() {
        return new ExistCourse(RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
