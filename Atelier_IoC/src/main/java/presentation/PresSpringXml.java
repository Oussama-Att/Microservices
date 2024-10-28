package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
        IMetier metier = (IMetier) applicationContext.getBean("metier");
        System.out.println(metier.calcule());
    }
}
