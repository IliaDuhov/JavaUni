import java.util.ArrayList;
import java.util.List;


public class Block implements AvrgMarkable{
    private List<AvrgMarkable> marks = new ArrayList<>();

    public Block(List<AvrgMarkable> marks) {
        this.marks = new ArrayList<>(marks);
    }

    @Override
    public double avarageMark() {
        if(marks.size() == 0){
            return 0;
        }
        double sum=0;
        for(AvrgMarkable mark: marks){
            sum += mark.avarageMark();
        }
        return (double) sum/marks.size();
    }
    
}
