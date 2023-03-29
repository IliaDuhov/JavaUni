package SpringTESTS;


public class Feedback {
    private String text;
    private int mark;

    public Feedback(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }
    public Feedback(){}

    public int getMark() {
        return mark;
    }
    @Override
    public String toString(){
        return String.format("%s %d", text, mark);
    }
}
