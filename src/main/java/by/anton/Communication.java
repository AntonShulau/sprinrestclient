package by.anton;

import by.anton.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL="http://localhost:8090/spring_rest/api/employees";

    public List<Employee> showAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity=
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> allemp=responseEntity.getBody();
        return allemp;
    }

    public Employee getEmployeeById(int id){
        String idURL=URL+"/"+id;
        ResponseEntity<Employee> employeeResponse=restTemplate.exchange(idURL, HttpMethod.GET,
                null, new ParameterizedTypeReference<Employee>() {
        });
        Employee employee=employeeResponse.getBody();

        return employee;
    }

    public void saveEmployee(@RequestBody Employee employee){
        int id=employee.getId();
        if(id==0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL,employee);
            System.out.println("Employee with id "+id+" was updated");
        }



    }

    public void deleteEmployee(int id){



    }


}
