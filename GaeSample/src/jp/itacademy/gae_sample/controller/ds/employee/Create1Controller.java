package jp.itacademy.gae_sample.controller.ds.employee;

import java.util.Arrays;

import jp.itacademy.gae_sample.controller.ds.CreateSampleController;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class Create1Controller extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Employee employee = new Employee();
        employee.setName("ŽÐ’{ŽO˜Y");
        employee.setHireDate(CreateSampleController.newDate(1980, 9, 9));
        employee.setDeptid(2);
        employee.setSalary(500000);
        employee.setCredentialIds(Arrays.asList(1L, 2L, 3L));
 
        Key key = Datastore.put(employee);
        requestScope("key", key);
        
        return forward("create1.jsp");
    }
}
