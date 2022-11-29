import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<AvrgMarkable> marks;
    private Deque<Actionable> actions =  new ArrayDeque<>();

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(String name, AvrgMarkable...marks) {
         this(name, Arrays.asList(marks));
    }

    public Student(String name, List<AvrgMarkable> marks) {
        this.name = name;
        this.marks = new ArrayList<>(marks);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, marks);
    }

    public boolean equals (Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Student ss = (Student) obj;
        if(this.name != ss.name || this.marks != ss.marks) return false;
        return true;
    }
    public double avarageMark(){
        if(marks.size() == 0){
            return 0;
        }
        int sum=0;
        for(AvrgMarkable mark: marks){
            sum += mark.avarageMark();
        }
        return (double) sum/marks.size();
    }
//    private List<Integer> validateMarks(List<Integer> marks){
//        for (int mark : marks){
//            if (!(mark >= 2 && mark <= 5)){
//                throw new IllegalArgumentException();
//            }
//        }
//        return marks;
//    }
    public boolean isExcelentStudent(){
        return avarageMark() == 5;
    }
    public void setMarks(List<AvrgMarkable> marks) {
        this.marks = new ArrayList<>((marks));
    }
    public void addMark(AvrgMarkable mark) { 
        this.marks.add(mark);
        int index = marks.size()-1;
        actions.push(() -> marks.remove(index));
    }
    public void setMark(int index, AvrgMarkable mark) {
        this.marks.set(index, mark);
    }
    public void setName(String name){
       String tmp = this.name;
       this.name = name;
       actions.push(() -> this.name = name);
    }
    public ArrayList<AvrgMarkable> getMarks() {
        return new ArrayList<>(marks);
    }
    public String getName(){
        return name;
    }
    public void removeMark(int index) {
        this.marks.remove(index);
    }
    public void cancel() {
        actions.pop().act();
    }
    public String toString(){
        return String.format("%s : %s", name, marks);
    }
}
