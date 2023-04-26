import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ORM {

    private Connection connection;
    @Autowired
    public ORM(Connection con){
        try {
            this.connection =  con;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public <T> List<T> selectAll(Class<T> clz) throws Exception{
        List<T> lst = new ArrayList<>();
        String className = clz.getSimpleName();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\""+clz.getSimpleName()+"\"");
        Map<String, Method> methods = Arrays.stream(clz.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .collect(Collectors.toMap(method -> method.getName().toLowerCase(), Function.identity()));
        while(resultSet.next()){
            T obj = clz.newInstance();
            for(int i =1; i< methods.size(); i++){
                Method method = methods.get("set" +
                        resultSet.getMetaData().getColumnName(i).toLowerCase());
                String resultObj = resultSet.getString(i);
                int columnType = resultSet.getMetaData().getColumnType(i);

                if(resultSet == null) continue;
            }
            lst.add(obj);
        }
        return lst;
    }
}
