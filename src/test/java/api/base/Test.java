package api.base;

import api.services.LessonServiceApi;
import org.testng.annotations.BeforeClass;

public class Test extends BaseTestApi{

    @BeforeClass
    public void setup() {

    }

    @org.testng.annotations.Test
    public void getLessons(){
        LessonServiceApi lessonServiceApi = new LessonServiceApi();
        lessonServiceApi.getLessons()
                .then().assertThat()
                .statusCode(200)
                .assertThat()
                .header("Content-Encoding", "gzip").log();
    }
}
