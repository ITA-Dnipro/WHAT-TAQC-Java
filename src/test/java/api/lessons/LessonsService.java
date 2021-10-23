package api.lessons;

import lessons.data.AddLessonJson;

public interface LessonsService {

    <T> T addLesson(AddLessonJson addLessonJson);
}
