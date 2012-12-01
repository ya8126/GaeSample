package jp.itacademy.gae_sample.controller.ds.employee;

import jp.itacademy.gae_sample.model.Employee;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class Get1Controller extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Key key = Datastore.createKey(Employee.class, 106);
        Employee employee = Datastore.getOrNull(Employee.class, key);
        requestScope("employee", employee);
        
        return forward("get1.jsp");
    }
}
