package api.base;

import api.lessons.LessonServiceApi;
import org.testng.annotations.BeforeClass;

public class Test extends BaseTestApi{

    @BeforeClass
    public void setup() {

    }

    @org.testng.annotations.Test
    public void getLessons(){
        LessonServiceApi lessonServiceApi = new LessonServiceApi();

        System.out.println(lessonServiceApi.getLessons());
    }
}
