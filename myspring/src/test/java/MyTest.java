import com.lsl.model.Person;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package PACKAGE_NAME
 * @Description: :
 * @time 2020/3/13 17:50
 */
public class MyTest {

    @Test
    public void test01() {
        String path = "classpath:/spring.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(path);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        Person.speak();
    }
}
