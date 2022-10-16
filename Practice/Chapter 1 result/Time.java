
public class Time {
    private int seconds;

    public Time(int secs){
        this.seconds = secs % 86400;
    }

    public Time(int hours, int minutes, int seconds){
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public void displayHours(){
        System.out.printf("Часы - %d\n", seconds / 3600);
    }

    public void displayMinutes(){
        System.out.printf("Минуты - %d\n", seconds / 60 % 60);
    }

    public void displaySeconds(){
        System.out.printf("Секунды - %d\n", seconds % 60);
    }

    public String toString(){

        seconds = seconds % 86400;
        int hours = seconds / 3600;
        int minutes = seconds / 60 % 60;
        int sec = seconds % 60;

        return String.format("%02d:%02d:%02d\n", hours, minutes, sec);

    }
}
