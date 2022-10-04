
package pract1_4;


public class Time {
    int seconds;
    
    public Time(int seconds){
        this.seconds = seconds;
    }

    public Time(int hour, int minute, int seconds){
       this(hour * 3600 + minute * 60 + seconds);
    }

    public String toString(){
        seconds = seconds % 86400;
        int hour = seconds / 3600;
        int minute = seconds / 60 % 60;
        int second = seconds % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);

    }
}
