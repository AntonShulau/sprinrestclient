package by.anton;

import by.anton.entity.Employee;
import configuration.Myconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EmptyStackException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(Myconfig.class);
        Communication communication=context.getBean("communication",Communication.class);

        List<Employee> employees= communication.showAllEmployees();
//
        System.out.println(employees);
//        Employee empl=new Employee();
//        empl.setName("Andrey");
//        empl.setSurname("Shumanov");
//        empl.setDepartment("HR");
//        empl.setSalary(987);
//        communication.saveEmployee(empl);
//

        communication.deleteEmployee(7);

        List<Employee> employees2= communication.showAllEmployees();
//
        System.out.println(employees2);



    }
}
