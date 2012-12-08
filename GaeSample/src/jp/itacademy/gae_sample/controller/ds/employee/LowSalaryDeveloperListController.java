package jp.itacademy.gae_sample.controller.ds.employee;

import java.util.List;

import jp.itacademy.gae_sample.meta.EmployeeMeta;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class LowSalaryDeveloperListController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        EmployeeMeta m = EmployeeMeta.get();
        List<Employee> employees = 
                Datastore
                .query(m)
                .filter(m.deptid.equal(2L), m.salary.lessThanOrEqual(300000))
                .sort(m.salary.desc)
                .asList();
        requestScope("employees", employees);
        
        return forward("list.jsp");

    }
}
