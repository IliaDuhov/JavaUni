package SpringTESTS;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Configuration
public class BeanConfig {
    @Bean
    String hello(){
        return "Hello, world!!!";
    }
    @Bean
    @Scope("prototype")
    int random(int min, int max){
        return (int)(Math.random()*(max+1-min)+min);
    }
    @Bean
    @Lazy
    Date dateTime(){
        return new Date();
    }
    @Bean
    @Scope("prototype")
    @Qualifier("range")
    Predicate<Integer> range(Integer random){
        Predicate<Integer> more = integer -> integer >=2 && integer <=5;
        return more;
    }
    @Bean
    int max(){
        return 5;
    }
    @Bean
    int min(){
        return 0;
    }
    @Bean
    Feedback normalFeedback(){
        return new Feedback("сойдёт", 3);
    }
    @Bean
    Feedback okFeedback(){
        return new Feedback("хорошо", 4);
    }
    @Bean
    Feedback hardToSayFeedback(@Qualifier("random") int random){
        return new Feedback("сложно сказать", random);
    }
    @Bean
    Feedback bestFeedback(List<Feedback> feedbackList){
        Feedback maxFeedback = new Feedback();
        int maxMark = -1;
        for(Feedback feedback: feedbackList){
            if(feedback.getMark()>maxMark){
                maxMark = feedback.getMark();
                maxFeedback = feedback;
            }
        }
        return maxFeedback;
    }
    @Bean
    Student student(@Qualifier("range") Predicate<Integer> range){
        return new Student(range);
    }
    @Bean
    StudentBuilder studentBuilder(){
        return new StudentBuilder();
    }

}
