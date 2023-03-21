package Reflection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.function.Predicate;

@Configuration
public class BeanConfig {
    @Bean
    String hello(){
        return "Hello, world!!!";
    }
    @Bean
    @Scope("prototype")
    int random(){
        int max = 99;
        int min = 0;
        return (int)(Math.random()*(max+1-min)+min);
    }
    @Bean
    @Scope("singleton")
    Date dateTime(){
        return new Date();
    }
    @Bean
    @Scope("prototype")
    boolean checkValue(Integer x){
        Predicate<Integer> more = integer -> integer >=2;
        Predicate<Integer> less = integer -> integer <=2;
        return more.and(less).test(x);
    }
    @Bean
    int max(){
        return 42;
    }
    @Bean
    int min(){
        return 0;
    }

}
