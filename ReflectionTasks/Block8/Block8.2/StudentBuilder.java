package SpringTESTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Predicate;

@Component
public class StudentBuilder {

    @Qualifier("range")
    private Predicate<Integer> range;

    public Student buildStudent(String name, Integer...marks){
        Student student = new Student(range);
        student.setName(name);
        student.setMarks(Arrays.asList(marks));
        return student;
    }
}
