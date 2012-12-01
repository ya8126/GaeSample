package jp.itacademy.gae_sample.controller.ds.employee;

import java.util.List;

import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class AllController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<Employee> employees = Datastore.query(Employee.class).asList();
        requestScope("employees", employees);
        
        return forward("list.jsp");
    }
}
