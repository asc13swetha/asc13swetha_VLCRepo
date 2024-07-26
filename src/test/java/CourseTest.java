import com.ecz.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {
        private Course course;
        @BeforeEach
        void setUp(){
            course=new Course(1,"wgd","hw",12,true);
        }
        @Test
        void testCourseCreation(){
            assertNotNull(course);
        }
        @Test
        void testCourseId(){
            assertEquals(1,course.getCourseId());
        }
}
