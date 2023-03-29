package SpringTESTS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Student {
    private String name;
    private List<Integer> marks;
    private Predicate<Integer> rule;

    public Student(Predicate<Integer> rule){
        this.rule = rule;
        marks = new ArrayList<>();
    }

    private List<Integer> correctMarks(List<Integer> marks){
        for (int mark : marks){
            if (mark < 2 || mark > 5){
                throw new IllegalArgumentException(mark + " is impossible grade");
            }
        }
        return marks;
    }

    public double getMarksAverage(){

        if(marks.size() == 0){
            return 0;
        }
        int marksSum = 0;
        for(int mark:marks){
            marksSum += mark;
        }
        return (double) marksSum/marks.size();
    }

    public boolean isExcellentStudent(){
        return getMarksAverage() == 5;
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMark(int index, int mark) {
        this.marks.set(index, mark);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>(correctMarks(marks));
    }

    public String toString() {
        return String.format("%s: %s", name, marks);
    }
}