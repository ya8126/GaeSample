package jp.itacademy.gae_sample.controller.memcache.employee;

import jp.itacademy.gae_sample.model.Dept;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class EditController extends Controller {

    @Override
    public Navigation run() throws Exception {

        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        if (!v.validate()) {
            return redirect("list");
        }

        Key key = Datastore.createKey(Employee.class, asLong("id"));
        Employee e = Datastore.getOrNull(Employee.class, key);
        if (e == null) {
            return redirect("list");
        }
        
        requestScope("employee", e);
        requestScope("depts", Datastore.query(Dept.class).asList());
        return forward("edit.jsp");
    }
}
