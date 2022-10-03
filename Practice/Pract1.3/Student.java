
package pract1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    String name;
    public List<Integer> marks;
    
    public Student(String name){
        this.name = name;
        this.marks = new ArrayList<>();
    }
    public Student(String name, Integer ...marks){
        this.name = name;
        for(int x:marks){
            if((x<2)||(x>5)){
                throw new IllegalArgumentException(x + " is not a legal mark");
            }
        }
        this.marks = new ArrayList<>(Arrays.asList(marks));
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
   
    public String toString(){
        return String.format("%s : %s", name,marks);
    }
}
