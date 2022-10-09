
package pract1_5;

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
        this(name, new ArrayList<>(Arrays.asList(marks)));
    }

    public Student(String name, List<Integer> marks) {
        this.name = name;
        setMarks(marks);
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMark(int index, int mark) {
        this.marks.set(index, mark);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>(marks);
    }
    public double marksAvarage(){
        if(marks.size() == 0){
            return 0;
        }
        int marksSum = 0;
        for(int mark:marks){
            marksSum += mark;
        }
        return (double) marksSum/marks.size();
    }

    public String toString() {
        return String.format("%s: %s", name, marks);
    }
}
