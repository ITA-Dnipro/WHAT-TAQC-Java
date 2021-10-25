package api.base;

import api.lessons.LessonServiceApi;
import org.testng.annotations.BeforeClass;
import static org.assertj.core.api.Assertions.*;

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
