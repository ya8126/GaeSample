package jp.itacademy.gae_sample.controller.ds.punish;

import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class NewController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("employeeId", v.required(), v.longType());
        if (!v.validate()){
            return redirect("/ds/employee/all");
        }
        
        Key key = Datastore.createKey(Employee.class, asLong("employeeId"));
        Employee employee = Datastore.getOrNull(Employee.class, key);
        if (employee == null){
            return redirect("/ds/employee/all");
        }
        
        requestScope("employee", employee);
        
        return forward("new.jsp");
    }
}
