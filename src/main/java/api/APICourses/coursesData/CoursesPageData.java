package api.APICourses.coursesData;

import java.io.Serializable;

public class CoursesPageData implements Serializable{
    Integer id;
    String name;
    Boolean isActive;

    public CoursesPageData(Integer id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return isActive;
    }
}
