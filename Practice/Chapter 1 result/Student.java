
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(String name, Integer ...marks) {
        this(name, Arrays.asList(marks));
    }

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = new ArrayList<>(correctMarks(marks));
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

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>(correctMarks(marks));
    }

    public String toString() {
        return String.format("%s: %s", name, marks);
    }
}
