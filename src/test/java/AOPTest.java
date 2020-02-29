import aop.MathCalculator;
import config.ConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigOfAOP.class);

    @Test
    public void print(){
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,1);
    }

    @Test
    public void xxxAwareTest(){
        System.out.println(applicationContext);
    }
}
