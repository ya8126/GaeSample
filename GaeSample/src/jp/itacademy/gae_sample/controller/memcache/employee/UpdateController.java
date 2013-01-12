package jp.itacademy.gae_sample.controller.memcache.employee;

import jp.itacademy.gae_sample.model.Dept;
import jp.itacademy.gae_sample.model.Employee;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;

public class UpdateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Validators v = new Validators(request);
        v.add("id", v.required(), v.longType());
        v.add("name", v.required());
        v.add("deptId", v.required(), v.longType());
        if (!v.validate()){
            return redirect("list");
        }
        
        Key deptKey = Datastore.createKey(Dept.class, asLong("deptId"));
        Dept dept = Datastore.getOrNull(Dept.class, deptKey);
        if (dept==null){
            return redirect("list");
        }
        
        Key key = Datastore.createKey(Employee.class, asLong("id"));
        Employee e = Datastore.getOrNull(Employee.class, key);
        e.setName(asString("name"));
        e.setDeptKey(deptKey);
        Datastore.put(e);
        
        Memcache.delete(key);
        
        return forward("update.jsp");
    }
}
