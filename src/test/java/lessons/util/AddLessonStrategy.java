package lessons.util;

import util.User;

public interface AddLessonStrategy {
    boolean addNewLesson(User user) throws Exception;
}
